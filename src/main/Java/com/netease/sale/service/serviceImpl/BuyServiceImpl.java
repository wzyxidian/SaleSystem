package com.netease.sale.service.serviceImpl;

import com.netease.sale.dao.BuyDao;
import com.netease.sale.meta.Buy;
import com.netease.sale.service.BuyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/2/19.
 */
@Service("buyServiceImpl")
public class BuyServiceImpl implements BuyService {

    @Resource
    private BuyDao buyDao;

    @Override
    public List<Buy> getBuys(int buyerId, int goodsId) {
        return buyDao.getBuys(buyerId, goodsId);
    }

    @Override
    public int addBuyList(List<Buy> buyList) {
        return buyDao.addBuyList(buyList);
    }


}
