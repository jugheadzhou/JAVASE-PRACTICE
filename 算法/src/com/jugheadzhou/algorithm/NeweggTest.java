package com.jugheadzhou.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName NeweggTest
 * @Description 新蛋笔试题
 * @Author zhaoRong
 * @Date 2019/4/28 19:02
 **/
public class NeweggTest {
    /**
     * 给定数组[2,4,3,5,7,8,9],找出其中和为7的两个数
     * 期待结果 2和5 4和3
     */
    public static void main(String[] args){
        int[] arry = {2,4,3,5,7,8,9};
        int num = 7;
        NeweggTest neweggTest = new NeweggTest();
        //方法一，通过双重循环找出，时间复杂度为n^2
        System.out.println("方法一：");
        neweggTest.findElementByFor(arry,num);
        //方法二，通过map，用7减循环数组元素，时间复杂度为n
        System.out.println("方法二：");
        neweggTest.findElementByMap(arry,num);
    }

    /**
     * 方法一，通过双重循环找出，时间复杂度为n^2
     * @param num
     * @param arry
     */
    private void findElementByFor(int[] arry,int num){
        for (int i=0; i<arry.length-1; i++){
            for (int j=i+1; j<arry.length; j++){
                int count = arry[i] + arry[j];
                if (count == num){
                    System.out.println(arry[i]+","+arry[j]);
                }
            }
        }
    }
    /**
     * 方法二，通过map，用目标和减循环数组元素，时间复杂度为n
     * @param num
     * @param arry
     */
    private void findElementByMap(int[] arry,int num){
        Map<Integer,Integer> map = new HashMap();
        int tmp;
        for(int arr:arry){
            tmp = num - arr;
            if (map.containsKey(tmp)){
                System.out.println(tmp+","+arr);
            }else {
                map.put(arr,arr);
            }
        }
    }
}
