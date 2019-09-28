package com.jugheadzhou.multithreading.producerandconsumer;

/**
 * @ClassName: CPTest
 * @Description: 多线程模式
 * @Author: zhaoRong
 * @Create: 2019/6/24 15:14
 **/
public class CPTest {
    public static void main(String[] args) {
        CPServer cpServer = new CPServer();
        Consumer consumer = new Consumer(cpServer);
        Producer producer = new Producer(cpServer);
        Thread aThread = new Thread(consumer, "消费者A");
        Thread bThread = new Thread(consumer, "消费者B");
        Thread apThread = new Thread(producer, "生成者A");
        Thread bpThread = new Thread(producer, "生成者B");
        aThread.start();
        bThread.start();
        apThread.start();
        bpThread.start();
    }
}
