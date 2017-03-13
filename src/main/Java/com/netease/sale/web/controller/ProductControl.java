package com.netease.sale.web.controller;

import com.netease.sale.meta.Buy;
import com.netease.sale.meta.Product;
import com.netease.sale.meta.User;
import com.netease.sale.service.serviceImpl.BuyServiceImpl;
import com.netease.sale.service.serviceImpl.ProductServiceImpl;
import com.netease.sale.service.serviceImpl.UserServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Mod;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/2/19.
 */
@Controller
public class ProductControl {
    @Resource
    private ProductServiceImpl productService;
    @Resource
    private UserServiceImpl userService;
    @Resource
    private BuyServiceImpl buyService;

    @RequestMapping("public")
    public String publicPage(HttpServletRequest request){
        Object userId = request.getSession().getAttribute("userId");
        if(userId != null){
            return "/public";
        }else
            return "/index";
    }
    /**
     * 发布商品
     * @param title
     * @param abstracts
     * @param pictureURL
     * @param detail
     * @param price
     * @param request
     * @return
     */
    @RequestMapping("/publicProduct")
    public ModelAndView  addProduct(@RequestParam("title") String title,
                           @RequestParam("summary") String abstracts,
                           @RequestParam("image") String pictureURL,
                           @RequestParam("detail") String detail,
                           @RequestParam("price") double price,
                           HttpServletRequest request){
        int userId = Integer.valueOf(request.getSession().getAttribute("userId").toString());
        int num = productService.addProduct(title,abstracts,pictureURL,detail,price,userId);
        int productId = 0;
        if(num > 0){
            List<Product> productList = productService.getProductId(title,abstracts,pictureURL,detail,price,userId);
            for(int i=0;i<productList.size();i++){
                if(productList.get(i).getProductId() > productId)
                    productId = productList.get(i).getProductId();
            }
        }
        ModelAndView modelAndView = new ModelAndView("/publicSubmit");
        modelAndView.addObject("productId", productId);
        return modelAndView;
    }

    @RequestMapping("upload")
    @ResponseBody
    public String uploadFile(HttpServletRequest request, @RequestParam("file") MultipartFile file, HttpServletResponse response){

        String fileName = file.getOriginalFilename();
        ServletContext sc = request.getSession().getServletContext();
        String filePath = sc.getRealPath("/img")+File.separator;
        File f = new File(filePath);
        if (!f.exists())
            f.mkdirs();
        if (!file.isEmpty()) {
            try {
                FileOutputStream fos = new FileOutputStream(filePath + fileName);
                InputStream in = file.getInputStream();
                int b = 0;
                while ((b = in.read()) != -1) {
                    fos.write(b);
                }
                fos.close();
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 保存文件地址，用于JSP页面回显
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result",filePath + fileName);

        return jsonObject.toString();
    }
    /**
     * 更新商品信息
     * @param productId
     * @param title
     * @param abstracts
     * @param pictureURL
     * @param detail
     * @param price
     * @param request
     * @return
     */
    @RequestMapping("/editProduct")
    public ModelAndView updateProduct(@RequestParam("productId") int productId,
                                      @RequestParam("title") String title,
                                      @RequestParam("summary") String abstracts,
                                      @RequestParam("image") String pictureURL,
                                      @RequestParam("detail") String detail,
                                      @RequestParam("price") double price,
                                      HttpServletRequest request){
        productService.updateProduct(productId,title,abstracts,pictureURL,detail,price);
        ModelAndView modelAndView = new ModelAndView("/publicSubmit");
        modelAndView.addObject("productId", productId);
        return modelAndView;
    }

    /**
     * 卖家编辑商品，显示商品详情
     * @return
     */
    @RequestMapping("/productEditDetail")
    public ModelAndView productEditDetail(@RequestParam("productId") int productId){
        Product product = productService.getProduct(productId);
        ModelAndView modelAndView = new ModelAndView("/public");
        modelAndView.addObject("productEditDetail", product);
        return modelAndView;
    }

    /**
     * 卖家删除商品
     * @param productId
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String deleteProduct(@RequestParam("productId") int productId){
        try{
            productService.deleteProduct(productId);
        }catch(Exception e){
            e.getMessage();
            return "fail";
        }
        return "success";
    }

    /**
     * 得到卖家自己的商品列表,并标明已经售出商品
     * @param request
     * @return
     */
    @RequestMapping("seller")
    public String sellerProductList(HttpServletRequest request){
        int userId = Integer.valueOf(request.getSession().getAttribute("userId").toString());
//        int userId = 1;
        List<Product> productList = productService.sellerProductList(userId);
        System.out.println(productList.size());
        return "index";
    }

    /**
     * 首页面所有商品展示
     * @throws IOException
     */
    @RequestMapping("/index")
    public ModelAndView productList(HttpServletRequest request) throws IOException{
        ModelAndView modelAndView = new ModelAndView();

        List<Product> products = productService.productList();
        System.out.println("当前共有： " + products.size() + "  件产品");
        modelAndView.addObject("productList", products);

        if(request.getSession().getAttribute("userId") != null
                && (Integer)(request.getSession().getAttribute("flag")) == 0){
            int userId = Integer.valueOf(request.getSession().getAttribute("userId").toString());
            User user = userService.buyedProductList(userId);
            List<Buy> buyItems = user.getBuys();
            System.out.println("购买记录条数：" + buyItems.size());
            Set<Product> buyProducts = new HashSet<Product>();
            Set<Product> unbuyProducts = new HashSet<Product>();
            for (int i=0;i<buyItems.size();i++) {
                buyProducts.add(buyItems.get(i).getProduct());
            }
            for(int i=0;i<products.size();i++){
                if(!buyProducts.contains(products.get(i))){
                    unbuyProducts.add(products.get(i));
                }
            }
            modelAndView.addObject("buyProducts",buyProducts);
            modelAndView.addObject("unbuyProducts",unbuyProducts);
            System.out.println("购买商品种类数：" + buyProducts.size());
        }else if(request.getSession().getAttribute("userId") != null
                && (Integer)(request.getSession().getAttribute("flag")) == 1){
            int userId = Integer.valueOf(request.getSession().getAttribute("userId").toString());
            List<Product> sellerProductList = productService.sellerProductList(userId);
            System.out.println("卖家共有商品数：" + sellerProductList.size());
            List<Product> saleProducts = new ArrayList<Product>();
            for(Product product : sellerProductList){
                if(product.getSaleout() > 0){
                    saleProducts.add(product);
                }
            }
            System.out.println("卖家已卖出商品数：" + saleProducts.size());
            modelAndView.addObject("sellerProductList", sellerProductList);
            modelAndView.addObject("saleProducts", saleProducts);
        }
        modelAndView.setViewName("index");//跳转到指定的页面
        return modelAndView;
    }

    /**
     * 得到产品详情
     * @param productId
     * @param type  0表示不能添加购物车，1表示可以添加购物车
     * @return
     */
    @RequestMapping("/productDetail")
    public ModelAndView showProductDetail(@RequestParam("productId") int productId, @RequestParam("type") int type, HttpServletRequest request){
        Product product = productService.getProduct(productId);
        System.out.println("产品名称:" + product.getTitle());
        ModelAndView modelAndView = new ModelAndView("productDetail");
        modelAndView.addObject("productDetail", product);
        modelAndView.addObject("type",type);
        if(request.getSession().getAttribute("userId") != null
                && (Integer)(request.getSession().getAttribute("flag")) == 0){
            int userId = Integer.valueOf(request.getSession().getAttribute("userId").toString());
            List<Buy> buys = buyService.getBuys(userId, productId);
            int count = 0;
            Set<Double> oldPrice = new HashSet<Double>();
            StringBuffer sb = new StringBuffer();
            for(int i=0;i<buys.size();i++){
                count += buys.get(i).getNumber();
                if(oldPrice.add(buys.get(i).getOldPrice())){
                    sb.append("¥" + buys.get(i).getOldPrice() + " ");
                }
            }
            modelAndView.addObject("count",count);
            modelAndView.addObject("oldPrice", sb);
        }
        return  modelAndView;
    }


    /**
     * 列举用户所有购买的商品
     * @param request
     * @return
     */
    @RequestMapping("showUnbuy")
    public ModelAndView unbuyProductList(HttpServletRequest request){
        int userId = Integer.valueOf(request.getSession().getAttribute("userId").toString());

        User user = userService.unbuyedProductList(userId);
        List<Buy> unbuyItems = user.getBuys();
        Set<Product> unbuyProducts = new HashSet<Product>();
        for (int i=0;i<unbuyItems.size();i++) {
            unbuyProducts.add(unbuyItems.get(i).getProduct());
        }
        System.out.println("未购买商品种类数：" + unbuyProducts.size());

        ModelAndView modelAndView;
        modelAndView = new ModelAndView("/index");//两种重定向的方法都可以
        modelAndView.addObject("unbuyProducts",unbuyProducts);

//        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }


}
