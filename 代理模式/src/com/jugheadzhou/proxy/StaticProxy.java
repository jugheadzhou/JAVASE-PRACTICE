package com.jugheadzhou.proxy;

/**
 * @ClassName: StaticProxy
 * @Description: 静态代理类
 * @Author: zhaoRong
 * @Create: 2019/9/22 22:17
 **/
public class StaticProxy implements IMessage {
    private RealMessageImpl realMessage;
    public StaticProxy(RealMessageImpl realMessage){
        this.realMessage = realMessage;
    }
    @Override
    public void send() {

        if (connect()){
            System.out.println("*****静态代理类处理真实业务前操作*****");

            //执行真实业务方法
            realMessage.send();

            System.out.println("*****静态代理类处理真实业务后操作*****");
            this.close();
        }

    }

    @Override
    public String say() {
        String result = null;
        if (connect()){
            System.out.println("*****静态代理类处理真实业务前操作*****");

            //执行真实业务方法
            result = realMessage.say();

            System.out.println("*****静态代理类处理真实业务后操作*****");
            this.close();
        }
        return result;
    }

    private boolean connect(){
        System.out.println("*****连接成功*****");
        return true;
    }

    private void close(){
        System.out.println("*****关闭连接*****");
    }
}
