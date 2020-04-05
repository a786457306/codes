package com.zzw.socket;

import java.io.*;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        // 设置超时时间
        socket.setSoTimeout(3000);
        // 连接本地2000端口，超时时间为3000ms
        socket.connect(new InetSocketAddress(Inet4Address.getLocalHost(), 2000), 3000);
        System.out.println("已发起服务器链接");
        System.out.println("客户端信息：" + socket.getLocalAddress() + "P:" + socket.getLocalPort());
        System.out.println("服务端信息：" + socket.getInetAddress() + "P:" + socket.getPort());

        try {
            trans(socket);
        } catch (Exception e) {
            System.out.println("异常关闭");
        } finally {
            socket.close();
            System.out.println("客户端已退出");
        }
    }

    /**
     * 发送 接收数据
     *
     * @param client
     * @throws IOException
     */
    private static void trans(Socket client) throws IOException {
        // 客户端
        // 读取键盘输入流
        InputStream in = System.in;
        BufferedReader input = new BufferedReader(new InputStreamReader(in));

        // 获取客户端输出流并打印
        OutputStream output = client.getOutputStream();
        PrintStream socketPrintStream = new PrintStream(output);

        // 从服务器得到socket输入流，转换为bufferReader
        InputStream inputStream = client.getInputStream();
        BufferedReader socketBufferReader = new BufferedReader(new InputStreamReader(inputStream));

        boolean flag = true;
        do {
//          将键盘输入信息发送到服务器
            // 键盘读取一行
            String str = input.readLine();
            // 发送到服务器
            socketPrintStream.println(str);

            // 从服务器发送的数据中读取一行，读到结束符就结束
            String echo = socketBufferReader.readLine();
            if ("end".equalsIgnoreCase(echo)) {
                flag = false;
            }
        } while (flag);

        socketBufferReader.close();
        socketPrintStream.close();

    }
}
