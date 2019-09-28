package com.jugheadzhou.algorithm;

import java.util.Arrays;

/**
 * @ClassName ProductTest
 * @Description TODO
 * @Author zhaoRong
 * @Date 2019/4/29 9:11
 **/
public class ProductTest {
    public static void main(String[] args){
        /**
         * 给定一个无序数组，包含正数、负数和0，要求从中找出3个数的乘积，使得乘积最大，
         * 要求时间复杂度：O(n)，空间复杂度：O(1)
         */
        ProductTest productTest = new ProductTest();
        int[] arrys = {1,9,2,4,8,-1,0};
        productTest.findMaxProduct(arrys);
        productTest.findMaxAndMin(arrys);
    }

    /**
     * 找出给定数组中3个数的乘积，使得乘积最大
     * @param arrys
     */
    private void findMaxProduct(int[] arrys){
        System.out.println("排序前的数组："+Arrays.toString(arrys));
        Arrays.sort(arrys);
        System.out.println("排序后的数组为："+Arrays.toString(arrys));
        int length = arrys.length;
        int maxProduct = arrys[length-1]*arrys[length-2]*arrys[length-3];
        System.out.println("满足条件的最大乘积:"+maxProduct);
    }

    /**
     * 通过排序找出数组的最大值与最小值
     * @param arrys
     */
    private void findMaxAndMin(int[] arrys){
        System.out.println("排序前的数组："+Arrays.toString(arrys));
        Arrays.sort(arrys);
        System.out.println("排序后的数组为："+Arrays.toString(arrys));
        System.out.println("最大值："+arrys[arrys.length-1]);
        System.out.println("最小值："+arrys[0]);
    }
}
