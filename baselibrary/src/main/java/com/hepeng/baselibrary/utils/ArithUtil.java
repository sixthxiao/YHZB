package com.hepeng.baselibrary.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class ArithUtil {
    private static final int DEF_DIV_SCALE = 10;

    private ArithUtil() {
    }

    public static double add(double d1, double d2) {
        BigDecimal b1 = new BigDecimal(Double.toString(d1));
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        return b1.add(b2).doubleValue();

    }

    public static double sub(double d1, double d2) {
        BigDecimal b1 = new BigDecimal(Double.toString(d1));
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        return b1.subtract(b2).doubleValue();

    }

    public static double mul(double d1, double d2) {
        BigDecimal b1 = new BigDecimal(Double.toString(d1));
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        return b1.multiply(b2).doubleValue();

    }

    public static double div(double d1, double d2) {

        return div(d1, d2, DEF_DIV_SCALE);

    }

    public static double div(double d1, double d2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(d1));
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    //保留point位小数，超出进一位
    public static String ddValue(double f, int point) {
        BigDecimal b = new BigDecimal(f);
        String pointStr = "0.";
        for (int i = 0; i < point; i++) {
            pointStr = pointStr + "0";
        }
        DecimalFormat df = new DecimalFormat(pointStr);
        return df.format(b.setScale(point, BigDecimal.ROUND_UP));
    }

    //保留point位小数，超出位数直接舍去，不进1
    public static String downValue(double f, int point) {
        BigDecimal b = new BigDecimal(f);
        String pointStr;
        if (point <= 0) {
            pointStr = "0";
        } else {
            pointStr = "0.";
            for (int i = 0; i < point; i++) {
                pointStr = pointStr + "0";
            }
        }
        DecimalFormat df = new DecimalFormat(pointStr);
        return df.format(b.setScale(point, BigDecimal.ROUND_DOWN));
    }
}