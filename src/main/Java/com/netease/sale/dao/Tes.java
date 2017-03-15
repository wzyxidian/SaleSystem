package com.netease.sale.dao;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by Administrator on 2017/3/10.
 */
public class Tes {
    public static void main(String[] args) {
        DecimalFormat decimalFormat = new DecimalFormat("####0.00");
        double result = 5.0 * 3;
        double   f   =   111231.5;
        NumberFormat nf = NumberFormat.getNumberInstance();


        // 保留两位小数
        nf.setMaximumFractionDigits(2);


        // 如果不需要四舍五入，可以使用RoundingMode.DOWN
        nf.setRoundingMode(RoundingMode.UP);


        System.out.println(nf.format(f));
    }
}
