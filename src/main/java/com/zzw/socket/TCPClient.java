package com.zzw.socket;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * TCPClient
 *
 * @author Daydreamer
 * @date 2018/3/16 17:48
 */
public class TCPClient{
    public static void main(String[] args) throws Exception{
        //系统随机给client的端口，本地IP地址与服务端端口相连
        Socket s = new Socket("127.0.0.1", 6666);
        OutputStream os = s.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeUTF("hello Server!");
        dos.flush();
        dos.close();
        s.close();
        //连完要关掉，清理资源
    }
}
