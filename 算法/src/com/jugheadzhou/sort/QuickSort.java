package com.jugheadzhou.sort;

import java.util.Arrays;

/**
 * @ClassName: QuickSort
 * @Description: 快速排序
 * @Author: zhaoRong
 * @Create: 2019/6/20 14:25
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] array = {2, -1, 6, 7, 0, 99, 3, 5};
        System.out.println("快排之前的数组：" + Arrays.toString(array));
        QuickSort.quickSort(array, 0, array.length - 1);
        System.out.println("快排之后的数组：");
        QuickSort.arrayToString(array);
    }

    public static void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        //取数组第一个数作为基本值
        int baseValue = array[start];
        int i = start;
        int j = end;
        while (i < j) {
            while (baseValue <= array[j] && i < j) {
                j--;
            }
            while (baseValue >= array[i] && i < j) {
                i++;
            }
            if (i < j) {
                int tmpValue = array[i];
                array[i] = array[j];
                array[j] = tmpValue;
            }
        }

        array[start] = array[i];
        array[i] = baseValue;

        quickSort(array, start, i - 1);
        quickSort(array, i + 1, end);
    }

    public static void arrayToString(int[] array) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("[");
        for (int arr : array) {
            buffer.append(arr);
            buffer.append(",");
            buffer.append(" ");
        }
        buffer.append("]");
        if (buffer.length() >= 2) {
            System.out.println(buffer.toString());
        }
    }
}
