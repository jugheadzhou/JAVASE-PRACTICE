package com.jugheadzhou.algorithm;

/**
 * @ClassName FactorialTest
 * @Description TODO
 * @Author zhaoRong
 * @Date 2019/4/30 22:59
 **/
public class FactorialTest {

    public static void main(String[] args){
        FactorialTest factorialTest = new FactorialTest();
        System.out.println("阶乘结果："+factorialTest.recFactorial(6));
    }
    /**
     * 使用递归求n阶乘n!=n*(n-1)*(n-2)*...*1
     */
    private int recFactorial(int n){
        if (n > 1){
            return n*recFactorial(n-1);
        }else{
            return 1;
        }
    }
}
