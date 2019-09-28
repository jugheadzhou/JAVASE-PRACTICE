package com.jugheadzhou.multithreading.producerandconsumer;

/**
 * @ClassName: Consumer
 * @Description: 消费者
 * @Author: zhaoRong
 * @Create: 2019/6/24 15:13
 **/
public class Consumer implements Runnable {
    CPServer cpServer;

    public Consumer(CPServer cpServer) {
        this.cpServer = cpServer;
    }

    @Override
    public void run() {
        while (true) {
            cpServer.getComputer("小米");
        }
    }
}
