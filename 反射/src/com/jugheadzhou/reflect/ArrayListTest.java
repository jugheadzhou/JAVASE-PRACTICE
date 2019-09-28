package com.jugheadzhou.reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @ClassName ArrayListTest
 * @Description TODO
 * @Author zhaoRong
 * @Date 2019/6/4 14:39
 **/
public class ArrayListTest {
    public static void main(String[] args) {
        /**
         * java通过反射理解集合泛型的本质是：在编译时防止输入错误，编译之后是去泛型化的。
         */
        ArrayList a1 = new ArrayList();
        ArrayList<String> a2 = new ArrayList<>();
        a2.add("小李");
//        a2.add(1);
        Class c1 = a1.getClass();
        Class c2 = a2.getClass();
        System.out.println(a1 == a2);
        System.out.println(c1 == c2);
        try {
            Method m2 = c2.getMethod("add",Object.class);
            m2.invoke(a2,1);
//            for(String s:a2){
//                System.out.println(s);
//            }
            System.out.println(a2);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
}
