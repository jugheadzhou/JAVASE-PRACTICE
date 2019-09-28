package com.jugheadzhou.multithreading.thread;

/**
 * @ClassName: Test
 * @Description: 测试线程
 * @Author: zhaoRong
 * @Create: 2019/6/21 13:05
 **/
public class Test {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "主线程开始运行！");
        //定义三个进程窗口
        ThreadDemo1 sta1 = new ThreadDemo1("窗口一");
        ThreadDemo1 sta2 = new ThreadDemo1("窗口二");
        ThreadDemo1 sta3 = new ThreadDemo1("窗口三");
        sta1.setPriority(Thread.MAX_PRIORITY);//设置优先级
//        ThreadDemo sta1 = new ThreadDemo("窗口一");
//        ThreadDemo sta2 = new ThreadDemo("窗口二");
//        ThreadDemo sta3 = new ThreadDemo("窗口三");
        sta1.start();
        sta2.start();
        sta3.start();
        try {
            sta1.join(1000);
            sta2.join(1000);
            sta3.join(1000);
        } catch (InterruptedException i) {
            i.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "主线程结束运行！");


    }
}
