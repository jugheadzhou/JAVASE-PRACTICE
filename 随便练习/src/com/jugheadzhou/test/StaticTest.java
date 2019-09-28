package com.jugheadzhou.test;

/**
 * @ClassName StaticTest
 * @Description TODO
 * @Author zhaoRong
 * @Date 2019/5/8 9:12
 **/
public class StaticTest {
        String name; // 声明变量name
        String sex; // 声明变量sex
        static int age;// 声明静态变量age

        // 构造方法
        public StaticTest() {
            System.out.println("通过构造方法初始化name");
            name = "tom";
        }

        // 初始化块
        {
            System.out.println("y");
            sex = "男";
        }

        // 静态初始化块
        static{
            System.out.println("通过静态初始化块初始化age");
            age = 20;
        }

        public void show() {
            System.out.println("姓名：" + name + "，性别：" + sex + "，年龄：" + age);
        }

        public static void main(String[] args) {

            // 创建对象
            StaticTest hello = new StaticTest();
            // 调用对象的show方法
            hello.show();
            System.out.println(Integer.MIN_VALUE);


        }
}