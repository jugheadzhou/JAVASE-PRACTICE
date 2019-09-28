package com.jugheadzhou.Array;

import java.util.Arrays;

/**
 * @ClassName: ArrayTest
 * @Description: 数组测试
 * @Author: zhaoRong
 * @Create: 2019/6/23 17:00
 **/
public class ArrayTest {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5, 6, 9};
        Arrays.fill(array, 5);
        try {
            int a = 3/0;
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(Arrays.toString(array));
    }
}
