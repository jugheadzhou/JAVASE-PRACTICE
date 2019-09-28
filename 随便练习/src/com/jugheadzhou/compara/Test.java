package com.jugheadzhou.compara;

/**
 * @ClassName: Test
 * @Description: 比较测试类
 * @Author: zhaoRong
 * @Create: 2019/6/22 9:29
 **/
public class Test {
    public static void main(String[] args) {
        Person dog1 = new Person("小黑狗", 9);
        Person dog2 = new Person("小黄狗", 5);
        int flag = dog1.compare(dog1, dog2);
        if (flag < 0) {
            System.out.println("dog1小于dog2");
        } else if (flag == 0) {
            System.out.println("dog1等于dog2");
        } else {
            System.out.println("dog1大于dog2");
        }
    }
}
