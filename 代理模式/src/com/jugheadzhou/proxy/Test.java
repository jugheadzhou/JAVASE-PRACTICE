package com.jugheadzhou.proxy;

/**
 * @ClassName: Test
 * @Description:
 * @Author: zhaoRong
 * @Create: 2019/9/22 22:11
 **/
public class Test {
    public static void main(String[] args) {
        //静态代理测试
        IMessage message = new StaticProxy(new RealMessageImpl());
//        message.send();

        //动态代理测试
        IMessage iMessage = (IMessage) new DynamicProxy().bind(new RealMessageImpl());
//        iMessage.send();

        //动态代理测试
        IMessage sMessage = (IMessage) new DynamicProxy().bind(new RealMessageImpl());
        System.out.println(sMessage.say());

    }
}
