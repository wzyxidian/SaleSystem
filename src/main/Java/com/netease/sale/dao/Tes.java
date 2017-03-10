package com.netease.sale.dao;

import java.text.DecimalFormat;

/**
 * Created by Administrator on 2017/3/10.
 */
public class Tes {
    public static void main(String[] args) {
        DecimalFormat decimalFormat = new DecimalFormat("####0.00");
        double result = 5.0 * 3;
        System.out.println(decimalFormat.format(result));
    }
}
