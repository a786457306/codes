package com.zzw.socket;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

    public static void main(String[] args) throws IOException {
        // 如果没有多个IP地址，默认当前活动的ip地址，只需要指定端口即可。
        ServerSocket server = new ServerSocket(2000);
    }
}
