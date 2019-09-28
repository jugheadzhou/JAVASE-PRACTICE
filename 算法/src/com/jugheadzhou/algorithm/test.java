package com.jugheadzhou.algorithm;

/**
 * @ClassName test
 * @Description TODO
 * @Author zhaoRong
 * @Date 2019/5/5 19:17
 **/

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class test {
    static Set<List<Integer>> set = new HashSet<>();

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3};
        boolean[] booleans = new boolean[arr.length];
        find(arr, 0, booleans);
        System.out.println(set);
        int i = 4;
        System.out.println(i<<=1);
    }
    static void find(int[] arr, int position, boolean[] isIns) {
        if (position == arr.length) {
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < arr.length;i++) {
                if (isIns[i]) {
                    list.add(arr[i]);
                }
            }
            set.add(list);
        } else {
            isIns[position] = true;
            find(arr, position + 1, isIns);
            isIns[position] = false;
            find(arr, position + 1, isIns);
        }
    }
}
