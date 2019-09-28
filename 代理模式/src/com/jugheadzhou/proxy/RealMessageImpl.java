package com.jugheadzhou.proxy;

/**
 * @ClassName: RealMessageImpl
 * @Description: 真实实现类
 * @Author: zhaoRong
 * @Create: 2019/9/22 22:13
 **/
public class RealMessageImpl implements IMessage {
    @Override
    public void send() {
        System.out.println("【RealMessageImpl】发送消息：i love you");
    }

    @Override
    public String say() {
        return "【RealMessageImpl】您好！！！！！";
    }
}
