package com.jugheadzhou.nio.chat.client;

import com.jugheadzhou.nio.chat.server.NioClient;

/**
 * @ClassName: AClient
 * @Description: 模拟客户端A
 * @Author: zhaoRong
 * @Create: 2019/9/29 21:51
 **/
public class AClient {
    public static void main(String[] args) throws Exception{
        new NioClient().start("AClient");
    }
}
