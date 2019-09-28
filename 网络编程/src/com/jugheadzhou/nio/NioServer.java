package com.jugheadzhou.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName: NioServer
 * @Description: nio服务端
 * @Author: zhaoRong
 * @Create: 2019/6/25 17:12
 **/
public class NioServer {

    private void start() {
        try {
            /**
             * 创建selector
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
                    /**
                     * 如果是 可读事件
                     */
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        NioServer nioServer = new NioServer();
    }
}
