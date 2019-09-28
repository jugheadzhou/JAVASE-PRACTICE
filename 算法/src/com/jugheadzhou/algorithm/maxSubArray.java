package com.jugheadzhou.algorithm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName maxSubArray
 * @Description 求最大子数组之和
 * @Author zhaoRong
 * @Date 2019/5/7 15:17
 **/
public class maxSubArray {
        public static int max(int m,int n){
            return m>n ? m :n;
        }

        public static int maxSubArrayMethodFour(int arr[]){
            //    程序运行结果：
            //    输入：
            //            8 1 -2 4 8 -4 7 -1 -5
            //    输出：
            //            15
            int n=arr.length;
            int nAll=arr[0];     //有n个数字数组的最大子数组和
            int nEnd=arr[0];     //有那个数字数组包含最后一个元素的子数组的最大和

            for(int i=1;i<n;i++){
                nEnd=max(nEnd+arr[i],arr[i]);
                nAll=max(nEnd,nAll);
            }

            return nAll;
        }

        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            int number=Integer.parseInt(sc.next());
            //number表示数组的长度
            int[] num=new int[number];

            //对数组元素循环赋值
            for(int i=0;i<number;i++){
                num[i]=(int)sc.nextInt();
            }
            System.out.println(Arrays.toString(num));
            System.out.println(maxSubArrayMethodFour(num));

        }
    }
