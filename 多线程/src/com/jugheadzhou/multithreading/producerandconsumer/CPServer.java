package com.jugheadzhou.multithreading.producerandconsumer;

/**
 * @ClassName: CPServer
 * @Description: 业务
 * @Author: zhaoRong
 * @Create: 2019/6/24 15:33
 **/
public class CPServer {
    private int num = 10;

    /**
     * 消费者获得电脑
     *
     * @param name
     */
    public synchronized void getComputer(String name) {
        if (num <= 0) {
            try {
                this.wait();
            } catch (InterruptedException i) {
                i.printStackTrace();
            }
            System.out.println("库存不足！");
            return;
        }
        num -= 1;
        System.out.println(Thread.currentThread().getName() + "获得一台" + name + "电脑,剩余库存：" + num);
        notifyAll();
    }

    /**
     * 生成者生成电脑
     *
     * @param name
     */
    public synchronized void putComputer(String name) {
        if (num >= 10) {
            try {
                this.wait();
            } catch (InterruptedException i) {
                i.printStackTrace();
            }
            System.out.println("库存已满");
            return;
        }
        num += 1;
        System.out.println(Thread.currentThread().getName() + "生产了一台" + name + "电脑,剩余库存：" + num);
        notifyAll();
    }
}
