package com.jugheadzhou.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName: DynamicProxy
 * @Description: 动态代理类
 * @Author: zhaoRong
 * @Create: 2019/9/22 22:20
 **/
public class DynamicProxy implements InvocationHandler {
    //真实业务实现对象
    private Object object;

    /**
     * 进行真实业务对象与代理业务对象之间的绑定
     * @param o 真实业务对象
     * @return 代理业务对象
     */
    public Object bind(Object o){

        this.object = o;

        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result = null;
        if (connect()){
            System.out.println("****动态代理类执行真实业务方法前操作****");

            //执行真实方法
            result = method.invoke(this.object,args);

            System.out.println("****动态代理类执行真实业务方法后操作****");
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
