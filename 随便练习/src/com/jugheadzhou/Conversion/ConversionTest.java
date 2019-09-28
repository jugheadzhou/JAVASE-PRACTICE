package com.jugheadzhou.Conversion;

/**
 * @ClassName: ConversionTest
 * @Description: Java 进制转换
 * @Author: zhaoRong
 * @Create: 2019/6/21 17:24
 **/
public class ConversionTest {

    public static void main(String[] args) {
        int a = 10;
        String a1 = Integer.toBinaryString(10);
        System.out.println("10进制转二进制：" + a1);

        String a2 = Integer.toOctalString(10);
        System.out.println("10进制转8进制：" + a2);

        String a3 = Integer.toHexString(10);
        System.out.println("10进制转16进制：" + a3);

        String a4 = Integer.valueOf("1010", 2).toString();
        System.out.println("二进制转10进制：" + a4);

        String a5 = Integer.valueOf("12", 8).toString();
        System.out.println("8进制转10进制：" + a5);

        String a6 = Integer.valueOf("a", 16).toString();
        System.out.println("16进制转10进制：" + a6);

        Integer.sum(1, 2);

    }
}
