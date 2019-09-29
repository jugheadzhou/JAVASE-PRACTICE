package com.jugheadzhou.nio.chat.server;

import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName: NioClientHandler
 * @Description: 客户端线程类，专门用来接收服务端响应信息
 * @Author: zhaoRong
 * @Create: 2019/9/29 21:13
 **/
public class NioClientHandler implements Runnable{
    private Selector selector;

    public NioClientHandler(Selector selector){
        this.selector = selector;
    }
    @Override
    public void run() {
        try {
            for (; ; ) {
                int readyChannels = selector.select();

                if (readyChannels == 0) continue;
                /**
                 * 获取可用channel集合
                 */
                Set<SelectionKey> selectionKeySet = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeySet.iterator();
                if (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    /**
                     * 移除set当前的selectionKey
                     */
                    iterator.remove();
                    /**
                     * 根据就绪状态。调用对应方法处理业务逻辑
                     */
                    /**
                     * 如果是 可读事件
                     */
                    if (selectionKey.isReadable()){
                        this.readHandler(selectionKey,selector);
                    }
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }

    /**
     * 可读事件处理器
     */
    private void readHandler(SelectionKey selectionKey, Selector selector) throws Exception{
        /**
         * 要从selectionKey中获取到以及就绪的Channel
         */
        SocketChannel socketChannel = (SocketChannel)selectionKey.channel();

        /**
         * 创建buffer
         */
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        /**
         * 循环读取服务端响应信息
         */
        String response = "";
        while (socketChannel.read(byteBuffer) > 0){

            /**
             * 切换buffer为读模式
             */
            byteBuffer.flip();

            /**
             * 读取buffer中的内容
             */

            response += Charset.forName("UTF-8").decode(byteBuffer);
        }

        /**
         * 将Channel再次注册到selector上，监听其他可读事件
         */
        socketChannel.register(selector,SelectionKey.OP_READ);

        /**
         * 将客户端发送的请求信息 广播给其他客户端
         */

        if (response.length() > 0){
            //将服务器端响应信息打印到本地
            System.out.println("==" + response);
        }

    }
}
