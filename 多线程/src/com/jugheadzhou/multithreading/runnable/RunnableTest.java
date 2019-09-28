package com.jugheadzhou.multithreading.runnable;

/**
 * @ClassName: RunnableTest
 * @Description: runnable测试类
 * @Author: zhaoRong
 * @Create: 2019/6/21 15:07
 **/
public class RunnableTest {

    public static void main(String[] args) {
        System.out.println("主线程开始运行！");
        RunnableDemo rd = new RunnableDemo();
        Thread t1 = new Thread(rd, "窗口一");
        Thread t2 = new Thread(rd, "窗口二");
        Thread t3 = new Thread(rd, "窗口三");
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException i) {
            i.printStackTrace();
        }
        System.out.println("主线程结束运行！");
    }
}
