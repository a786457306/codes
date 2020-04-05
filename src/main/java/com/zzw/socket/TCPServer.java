package com.zzw.socket;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCPServer
 *
 * @author Daydreamer
 * @date 2018/3/16 17:44
 */
public class TCPServer {
    public static void main(String[] args) throws Exception{
        //服务器应用程序，不间断运行，等待客户端连接
        // 一个应用程序只占一个端口，信息发到端口上。
        // 此时应用程序在持续监听
        ServerSocket ss = new ServerSocket(6666);
        while(true) {
            Socket s = ss.accept();//接收连接到服务器的应用程序。有几个连接就accept几次。阻塞式方法，没有客户端连接就等着。
            System.out.println("a client connected!");
        }
    }
}