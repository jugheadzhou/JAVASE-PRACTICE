package com.jugheadzhou.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @ClassName: ClientSocket
 * @Description: 客户端socket
 * @Author: zhaoRong
 * @Create: 2019/6/20 8:56
 **/
public class ClientSocket {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8888);
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.write("我是客户端发送的信息哈哈");
            printWriter.flush();
            socket.shutdownOutput();
            printWriter.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
