package com.jugheadzhou.bio;

import java.io.*;
import java.net.Socket;

/**
 * @ClassName: SocketThread
 * @Description: 将socket放在多线程环境下
 * @Author: zhaoRong
 * @Create: 2019/6/20 9:35
 **/
public class SocketThread extends Thread {

    Socket socket = null;

    public SocketThread(Socket socket) {
        this.socket = socket;
    }

    InputStream inputStream = null;
    InputStreamReader inputStreamReader = null;
    BufferedReader bufferedReader = null;
    PrintWriter printWriter = null;
    OutputStream outputStream = null;

    @Override
    public void run() {
        try {
            inputStream = socket.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            String info = null;
            if ((info = bufferedReader.readLine()) != null) {
                System.out.println("我是服务端，客户端说：" + info);
            }
            socket.shutdownInput();
            outputStream = socket.getOutputStream();
            printWriter = new PrintWriter(outputStream);
            printWriter.write("欢迎你连接到服务端");
            printWriter.flush();
        } catch (IOException i) {
            i.printStackTrace();
        } finally {
            try {
                if (printWriter != null) {
                    inputStream.close();
                }
                if (printWriter != null) {
                    inputStreamReader.close();
                }
                if (printWriter != null) {
                    outputStream.close();
                }
                if (printWriter != null) {
                    bufferedReader.close();
                }
                if (printWriter != null) {
                    printWriter.close();
                }
            } catch (IOException i) {
                i.printStackTrace();
            }

        }

    }
}
