package com.jugheadzhou.Array;

/**
 * @ClassName: ArrayMaxDiff
 * @Description: 求数组的最大差值
 * @Author: zhaoRong
 * @Create: 2019/6/24 10:51
 **/
public class ArrayMaxDiff {
    public static void main(String[] args) {
        /**
         * 问题描述：
         * 数组中的一个数字减去它右边子数组中的一个数字可以得到一个差值，求所有可能的差值中的最大值。
         * 例如，数组{1,4,17,3,2,9}中，最大的差值为17-2=15
         */
        int[] array = {1, 4, 17, 3, 2, 9, 1};
        System.out.println("最大差值为：" + ArrayMaxDiff.getMaxDiff(array));
    }

    private static int getMaxDiff(int[] array) {
        int length = array.length - 1;
        int maxDiff = Integer.MIN_VALUE;
        System.out.println("最小int值：" + maxDiff);
        int maxArrayValue = array[0];
        for (int i = 0; i < length; i++) {
            maxDiff = Integer.max(maxArrayValue - array[i + 1], maxDiff);
            maxArrayValue = Integer.max(maxArrayValue, array[i + 1]);
            System.out.println("计算过程中差值变化：" + maxDiff);
        }


        return maxDiff;
    }
}
