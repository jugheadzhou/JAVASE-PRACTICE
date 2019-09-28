package com.jugheadzhou.algorithm;

import java.util.Arrays;

/**
 * @ClassName NonnegativeMin
 * @Description TODO
 * @Author zhaoRong
 * @Date 2019/4/29 9:22
 **/
public class NonnegativeMin {
    public static void main(String[] args){
        int[] arrys = {2,3,5,-3,1,4,9,3};
        NonnegativeMin nonnegativeMin = new NonnegativeMin();
        nonnegativeMin.findNonnegativeMin(arrys);
//        nonnegativeMin.findDifferenceMin(arrys);
        nonnegativeMin.findNonnegativeMinByDichotomy(arrys);
    }

    /**
     * 一个整型大数据量数组（数据可能有负数，0，正数，也可能有重复的数字），返回此数组的非负最小值
     * @param arrys
     */
    private void findNonnegativeMin(int[] arrys){
        long  startTime = System.currentTimeMillis();    //获取开始时间
        Arrays.sort(arrys);
        System.out.println("排序之后的数组："+Arrays.toString(arrys));
        for (int arry : arrys){
            if (arry > -1){
                System.out.println("非负最小值:"+arry);
                break;
            }
        }
        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
    }

    /**
     * 使用二分法查找
     * @param arrys
     */
    private void findNonnegativeMinByDichotomy(int[] arrys){
        long  startTime = System.currentTimeMillis();    //获取开始时间
        Arrays.sort(arrys);
        System.out.println("排序之后的数组："+Arrays.toString(arrys));
        int start = 0;
        int end = arrys.length - 1;
        int middle = 0;
        while (end > start){
            middle = (end + start)/2;
            if (arrys[middle] > -1){
                end = middle - 1;
            }else if (arrys[middle] < -1){
                start = middle +1;
            }
        }
        System.out.println("非负最小值:"+arrys[middle]);
        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("二分法程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
    }

    /**
     * 有一个整数数组，请求出两两之差绝对值最小的值
     * @param arrys
     */
    private void findDifferenceMin(int[] arrys){
        Arrays.sort(arrys);
        System.out.println("排序之后的数组："+Arrays.toString(arrys));
        int length = arrys.length;
        int min = Math.abs(arrys[length-1] - arrys[0]);
        int i;
        for (i=0; i<length-1; i++){
            int tmp = Math.abs(arrys[i] - arrys[i+1]);
            if (tmp < min){
                min = tmp;
            }
        }
        System.out.println("两两之差绝对值最小的值:"+min);
    }
}
