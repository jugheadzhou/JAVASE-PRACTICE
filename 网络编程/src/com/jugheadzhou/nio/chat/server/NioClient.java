package com.jugheadzhou.nio.chat.server;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * @ClassName: NioClient
 * @Description: Nio客户端
 * @Author: zhaoRong
 * @Create: 2019/9/29 20:58
 **/
public class NioClient {
    /**
     * 启动
     */
    public void start(String name) throws Exception{
        /**
         * 连接服务器端
         */
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",8000));
        /**
         * 接收服务端响应
         */
        //新开一个线程，专门用来接收服务端响应数据

        Selector selector = Selector.open();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
        new Thread(new NioClientHandler(selector)).start();
        /**
         * 向服务端发送数据
         */
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String request = scanner.nextLine();
            if (request != null && request.length() >0){
                socketChannel.write(Charset.forName("UTF-8")
                        .encode(name+":"+request));
            }

        }

    }

    public static void main(String[] args) throws Exception{
//        new NioClient().start("test");
    }
}
