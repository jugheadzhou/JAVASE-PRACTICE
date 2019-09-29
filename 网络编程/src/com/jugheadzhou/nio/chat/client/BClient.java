package com.jugheadzhou.nio.chat.client;

import com.jugheadzhou.nio.chat.server.NioClient;

/**
 * @ClassName: BClient
 * @Description: 模拟客户端B
 * @Author: zhaoRong
 * @Create: 2019/9/29 21:51
 **/
public class BClient {
    public static void main(String[] args) throws Exception{
        new NioClient().start("BClient");
    }
}
