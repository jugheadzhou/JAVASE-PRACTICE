package com.jugheadzhou.sort;

import java.util.Arrays;

/**
 * @ClassName InsertSort
 * @Description TODO
 * @Author zhaoRong
 * @Date 2019/5/22 13:39
 **/
public class InsertSort {
    /**
     * 插入排序
     */
    public static void main(String[] args){
        int[] array = {1,4,7,3,0,-1,-5,-7,9};
        InsertSort insertSort = new InsertSort();
        insertSort.insertSort(array);
        System.out.println(Arrays.toString(array));
    }
    private void insertSort(int[] array){
        if (array == null || array.length == 1){
            return;
        }
        int len = array.length;
        int tmp;
        for (int i=0;i<len-1;i++){
            int j = i;
            tmp = array[i];
            while (j>0 && tmp < array[j-1]){
                array[j] = array[j-1];
                j--;
            }
            array[j] = tmp;
        }
    }
}
