package com.jugheadzhou.multithreading.runnable;

/**
 * @ClassName: RunnableDemo
 * @Description: runnable测试、
 * @Author: zhaoRong
 * @Create: 2019/6/21 14:57
 **/
public class RunnableDemo implements Runnable {
    private int num = 10;

    @Override
    public void run() {
        while (num > 0) {
            sale();
//            try {
//                Thread.sleep(1000);
//            }catch (InterruptedException i){
//                i.printStackTrace();
//            }
        }
    }

    private synchronized void sale() {
        if (num > 0) {
            System.out.println(Thread.currentThread().getName() + "第" + num + "张票已售出。");
            num--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException i) {
                i.printStackTrace();
            }
        } else {
            System.out.println("票已售完！");
        }
    }
}
