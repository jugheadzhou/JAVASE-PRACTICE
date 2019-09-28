package com.jugheadzhou.multithreading.thread;

/**
 * @ClassName: ThreadDemo1
 * @Description: 多线程练习
 * @Author: zhaoRong
 * @Create: 2019/6/21 13:34
 **/
public class ThreadDemo1 extends Thread {
    private String name;
    private Thread thread;
    private static Object object = "object";
    private static int num = 20;
    private static int count = 0;

    public ThreadDemo1(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (num > 0) {
            sale();
        }
    }

    private void sale() {
        synchronized (object) {
            if (num > 0) {
                System.out.println(name + "第" + num + "已售出。");
                num--;
                count++;
            } else {
                System.out.println(count + "张票已经售完！");
            }
        }
        try {
            this.sleep(1000);
        } catch (InterruptedException i) {
            i.printStackTrace();
        }
    }

    @Override
    public synchronized void start() {
        if (thread == null) {
            thread = new Thread(this, name);
            thread.start();
        }
    }
}
