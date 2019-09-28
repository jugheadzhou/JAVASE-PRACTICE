package com.jugheadzhou.bio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName: ServerSockets
 * @Description: socket服务端
 * @Author: zhaoRong
 * @Create: 2019/6/20 8:55
 **/
public class ServerSockets {


    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("服务端开始启动...");
            //等到客户端的连接
            int count = 0;
            while (true) {
                Socket socket = serverSocket.accept();
                count++;
                System.out.println("第" + count + "次执行线程");
                System.out.println("客户端的数量：" + count);
                InetAddress inetAddress = socket.getInetAddress();
                System.out.println("客户端的ip:" + inetAddress.getHostAddress());
                System.out.println("客户端的主机名:" + inetAddress.getHostName());
                //为每个客户端开启一个线程
                SocketThread socketThread = new SocketThread(socket);
                socketThread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
