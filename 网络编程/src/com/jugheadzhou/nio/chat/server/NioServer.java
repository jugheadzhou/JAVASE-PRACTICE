package com.jugheadzhou.nio.chat.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName: NioServer
 * @Description: nio服务端
 * @Author: zhaoRong
 * @Create: 2019/6/25 17:12
 **/
public class NioServer {

    private void start() throws Exception{
        try {
            /**
             * 1.创建selector
             */
            Selector selector = Selector.open();
            /**
             * 通过serverSocketChannel创建channel通道
             */
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            /**
             * 为channel通道绑定监听端口
             */
            serverSocketChannel.bind(new InetSocketAddress(8000));
            /**
             * 设置channel为阻塞状态
             */
            serverSocketChannel.configureBlocking(false);
            /**
             * 将channel注册到selector上，监听连接事件
             */
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("服务端启动成功");
            /**
             * 循环等待新连接的接入
             */
            for (; ; ) {
                /**
                 * TODO 获取可用channel数量
                 */
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
                     * 如果是 接入事件
                     */
                    if (selectionKey.isAcceptable()){
                        this.acceptHandler(serverSocketChannel,selector);
                    }
                    /**
                     * 如果是 可读事件
                     */
                    if (selectionKey.isReadable()){
                        this.readHandler(selectionKey,selector);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * 接入事件处理器
     */
    private void acceptHandler(ServerSocketChannel serverSocketChannel,Selector selector) throws Exception{

        /**
         * 如果是接入事件，创建socketChannel
         */
        SocketChannel socketChannel = serverSocketChannel.accept();

        /**
         * 将socketChannel设置为非阻塞工作模式
         */
        socketChannel.configureBlocking(false);

        /**
         * 将channel注册到selector上，监听可读事件
         */
        socketChannel.register(selector,SelectionKey.OP_READ);

        /**
         * 回复客户端提示信息
         */
        socketChannel.write(Charset.forName("UTF-8")
                .encode("你与聊天室其他人都不是朋友关系，请注意安全！"));
    }

    /**
     * 可读事件处理器
     */
    private void readHandler(SelectionKey selectionKey,Selector selector) throws Exception{
        /**
         * 要从selectionKey中获取到以及就绪的Channel
         */
        SocketChannel socketChannel = (SocketChannel)selectionKey.channel();

        /**
         * 创建buffer
         */
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        /**
         * 循环读取客户端请求信息
         */
        String request = "";
        while (socketChannel.read(byteBuffer) > 0){

            /**
             * 切换buffer为读模式
             */
            byteBuffer.flip();

            /**
             * 读取buffer中的内容
             */

            request += Charset.forName("UTF-8").decode(byteBuffer);
        }

        /**
         * 将Channel再次注册到selector上，监听其他可读事件
         */
        socketChannel.register(selector,SelectionKey.OP_READ);

        /**
         * 将客户端发送的请求信息 广播给其他客户端
         */

        if (request.length() > 0){
            //广播给其他客户端
            broadCast(selector,socketChannel,request);
        }

    }

    /**
     * 广播给其他客户端
     */
    private void broadCast(Selector selector,SocketChannel sourceChannel,String request){

        /**
         * 获取带所有已接入的客户端Channel
         */
        Set<SelectionKey> selectionKeySet = selector.keys();

        /**
         * 循环向所有Channel广播信息
         */
        selectionKeySet.forEach(selectionKey -> {
            Channel targetChannel = selectionKey.channel();
            //剔除发消息的客户端
            if (targetChannel instanceof SocketChannel && targetChannel != sourceChannel){

                try{
                    ((SocketChannel) targetChannel).write(Charset.forName("UTF-8").encode(request));
                }catch (Exception e){
                    System.out.println(e);
                }

            }
        });
    }

    public static void main(String[] args) throws Exception{
        NioServer nioServer = new NioServer();
        nioServer.start();
    }
}
