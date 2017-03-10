package com.netease.sale.service.serviceImpl;

import com.netease.sale.dao.BuyDao;
import com.netease.sale.meta.Buy;
import com.netease.sale.service.BuyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2017/2/19.
 */
@Service("buyServiceImpl")
public class BuyServiceImpl implements BuyService {

    @Resource
    private BuyDao buyDao;
    @Override
    public void addBuy(int buyerId, int goodsId, int number, String buyTime, double oldPrice) {
            buyDao.addBuy(buyerId,goodsId,number,buyTime,oldPrice);
    }

    @Override
    public List<Buy> getBuys(int buyerId, int goodsId) {
        return buyDao.getBuys(buyerId, goodsId);
    }


}
