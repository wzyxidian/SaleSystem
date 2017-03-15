package com.netease.sale.web.controller;

import com.netease.sale.meta.Buy;
import com.netease.sale.meta.Product;
import com.netease.sale.meta.User;
import com.netease.sale.service.serviceImpl.BuyServiceImpl;
import com.netease.sale.service.serviceImpl.ProductServiceImpl;
import com.netease.sale.service.serviceImpl.UserServiceImpl;
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
import java.text.DecimalFormat;
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

    /**
     * 首页面(未登陆、买家、卖家)所有商品展示
     * flag用来区分买家和卖家
     *           0：表示买家
     *           1：表示卖家
     * @throws IOException
     */
    @RequestMapping("/index")
    public ModelAndView productList(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        List<Product> products = productService.productList();

        if (products != null && products.size() != 0) {
            modelAndView.addObject("productList", products);

            //买家的商品列举情况，包括已购买与未购买
            if (request.getSession().getAttribute("userId") != null
                    && (Integer) (request.getSession().getAttribute("flag")) == 0) {
                return new ModelAndView("forward:/showBuyerProductList");
            }//卖家拥有的商品列表
            else if (request.getSession().getAttribute("userId") != null
                    && (Integer) (request.getSession().getAttribute("flag")) == 1) {
                return new ModelAndView("forward:/sellerProductList");
            }
        }
        modelAndView.setViewName("index");//跳转到指定的页面
        return modelAndView;
    }

    /**
     * 列举买家所有购买的商品和未购买的商品
     * @param request
     * @return
     */
    @RequestMapping("/showBuyerProductList")
    public ModelAndView buyerProductList(HttpServletRequest request){
        int userId = Integer.valueOf(request.getSession().getAttribute("userId").toString());
        ModelAndView modelAndView = new ModelAndView("/index");
        List<Product> products = productService.productList();
        User user = userService.buyedProductList(userId);
        if(user != null){
            List<Buy> buyItems = user.getBuys();
            if(buyItems != null && buyItems.size() != 0){
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
            }

        }
        return modelAndView;
    }

    /**
     * 得到卖家自己的商品列表,并标明已经售出商品
     * @param request
     * @return
     */
    @RequestMapping("/sellerProductList")
    public ModelAndView sellerProductList(HttpServletRequest request){
        int userId = Integer.valueOf(request.getSession().getAttribute("userId").toString());
        List<Product> sellerProductList = productService.sellerProductList(userId);
        ModelAndView modelAndView = new ModelAndView("/index");
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
        return modelAndView;
    }

    /**
     * 卖家删除未出售商品
     * @param productId
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String deleteProduct(@RequestParam("productId") int productId){
        int num = productService.deleteProduct(productId);
        if(num > 0)
            return "success";
        else
            return "fail";
    }

    /**
     * 得到产品详情
     * @param productId
     * @param type  用来区分未购买商品详情面还是已购买商品详情页
     *              0:买家已购买商品
     *              1:表示买家未购买的商品的详情页和卖家的商品详情页
     * @return
     */
    @RequestMapping("/productDetail")
    public ModelAndView showProductDetail(@RequestParam("productId") int productId, @RequestParam("type") int type, HttpServletRequest request){
        Product product = productService.getProduct(productId);
        ModelAndView modelAndView = new ModelAndView("/productDetail");
        modelAndView.addObject("productDetail", product);
        modelAndView.addObject("type",type);
        if(request.getSession().getAttribute("userId") != null
                && (Integer)(request.getSession().getAttribute("flag")) == 0
                && type == 0){
            int userId = Integer.valueOf(request.getSession().getAttribute("userId").toString());
            List<Buy> buys = buyService.getBuys(userId, productId);
            int count = 0;
            Set<String> oldPrice = new HashSet<String>();
            StringBuffer sb = new StringBuffer();
            for(int i=0;i<buys.size();i++){
                count += buys.get(i).getNumber();
                if(oldPrice.add(buys.get(i).getOldPrice().toString())){
                    sb.append("¥" + buys.get(i).getOldPrice() + " ");
                }
            }
            modelAndView.addObject("count",count);
            modelAndView.addObject("oldPrice", sb);
        }
        return  modelAndView;
    }

    /**
     * 卖家发布的主页面
     * @param request
     * @return
     */
    @RequestMapping("/public")
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
        DecimalFormat df = new DecimalFormat("######0.00");
        double formatPrice = Double.valueOf(df.format(price));
        int num = productService.addProduct(title,abstracts,pictureURL,detail,formatPrice,userId);
        int productId = 0;
        if(num > 0){
            List<Product> productList = productService.getProductId(title,abstracts,pictureURL,detail,formatPrice,userId);
            for(int i=0;i<productList.size();i++){
                if(productList.get(i).getProductId() > productId)
                    productId = productList.get(i).getProductId();
            }
            ModelAndView modelAndView = new ModelAndView("/publicSubmit");
            modelAndView.addObject("productId", productId);
            return modelAndView;
        }else {
            return new ModelAndView("/public");
        }

    }

    /**
     * 图片上传
     * @param request
     * @param file
     * @return
     */
    @RequestMapping("/upload")
    @ResponseBody
    public String uploadFile(HttpServletRequest request, @RequestParam("file") MultipartFile file, HttpServletResponse response){
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
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
        jsonObject.put("result", "img/" + fileName);

        return jsonObject.toString();
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
     * 更新商品信息
     * @param productId
     * @param title
     * @param abstracts
     * @param pictureURL
     * @param detail
     * @param price
     * @return
     */
    @RequestMapping("/editProduct")
    public ModelAndView updateProduct(@RequestParam("productId") int productId,
                                      @RequestParam("title") String title,
                                      @RequestParam("summary") String abstracts,
                                      @RequestParam("image") String pictureURL,
                                      @RequestParam("detail") String detail,
                                      @RequestParam("price") double price){
        DecimalFormat df = new DecimalFormat("######0.00");
        double formatPrice = Double.valueOf(df.format(price));
        int num = productService.updateProduct(productId,title,abstracts,pictureURL,detail,formatPrice);
        ModelAndView modelAndView = null;
        if(num > 0){
            modelAndView = new ModelAndView("/publicSubmit");
            modelAndView.addObject("productId", productId);
        }else{
            modelAndView = new ModelAndView("forward:/productEditDetail?productId="+productId);
        }
        return modelAndView;
    }

}
