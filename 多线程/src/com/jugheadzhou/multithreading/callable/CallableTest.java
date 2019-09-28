package com.jugheadzhou.multithreading.callable;

import java.util.concurrent.FutureTask;

/**
 * @ClassName: CallableTest
 * @Description: callable测试类
 * @Author: zhaoRong
 * @Create: 2019/6/26 21:35
 **/
public class CallableTest {
    public static void main(String[] args) {
        CallableDemo callableDemo = new CallableDemo();
        FutureTask futureTask = new FutureTask(callableDemo);
        Thread thread = new Thread(futureTask);
        thread.start();
    }
}
