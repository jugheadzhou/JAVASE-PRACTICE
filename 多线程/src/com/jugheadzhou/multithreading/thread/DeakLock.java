package com.jugheadzhou.multithreading.thread;

/**
 * @ClassName: DeakLock
 * @Description: 死锁原理
 * @Author: zhaoRong
 * @Create: 2019/6/21 16:52
 **/
public class DeakLock {
    public static void main(String[] args) {
        final Object a = new Object();
        final Object b = new Object();
        Thread threadA = new Thread(new Runnable() {
            public void run() {
                synchronized (a) {
                    try {
                        System.out.println("now i in threadA-locka");
                        Thread.sleep(1000);
                        synchronized (b) {
                            System.out.println("now i in threadA-lockb");
                        }
                    } catch (Exception e) {
                        // ignore
                    }
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            public void run() {
                synchronized (b) {
                    try {
                        System.out.println("now i in threadB-lockb");
                        Thread.sleep(1000);
                        synchronized (a) {
                            System.out.println("now i in threadB-locka");
                        }
                    } catch (Exception e) {
                        // ignore
                    }
                }
            }
        });

        threadA.start();
        threadB.start();
    }

}
