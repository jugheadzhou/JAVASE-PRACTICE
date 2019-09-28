package com.jugheadzhou.multithreading.thread;

/**
 * @ClassName: ThreadDemo
 * @Description: java多线程经典问题–购票问题
 * @Author: zhaoRong
 * @Create: 2019/6/21 13:03
 **/
public class ThreadDemo extends Thread {
    private String name;//窗口名称
    private Thread thread;
    private static Object object = "ob";
    private static int num = 200;
    private static int count = 0;

    public ThreadDemo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (num > 0) {
            //上锁，在一个用户执行完一个操作之前，其他用户不能操作
            synchronized (object) {
                if (num > 0) {
                    System.out.println(name + "第" + num + "张票已售出");
                    count++;
                    num--;
                } else {
                    System.out.println("张票已售完");
                    System.out.println(count + "张票已售完");
                }
            }
            try {
                //添加一段时间
                this.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void start() {
        if (thread == null) {
            thread = new Thread(this, name);
            thread.start();
        }
    }
}
