package com.jugheadzhou.multithreading.producerandconsumer;

/**
 * @ClassName: Producer
 * @Description: 生成者
 * @Author: zhaoRong
 * @Create: 2019/6/24 15:12
 **/
public class Producer implements Runnable {
    CPServer cpServer;

    public Producer(CPServer cpServer) {
        this.cpServer = cpServer;
    }

    @Override
    public void run() {
        while (true) {
            cpServer.putComputer("小米");
        }
    }
}
