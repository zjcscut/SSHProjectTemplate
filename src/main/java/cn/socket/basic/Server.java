/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.socket.basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zhangjinci
 * @version 2016/9/9 11:44
 * @function
 */
public class Server {

    public static void main(String[] args){
         try {

             ServerSocket server = new ServerSocket(9080); //监听8080端口
             Socket socket = server.accept();

             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             String data = reader.readLine();
             System.out.println("receive data from Client:" + data);

             PrintWriter writer = new PrintWriter(socket.getOutputStream());
             writer.println("receive data:" + data);
             writer.flush();

             writer.close();
             reader.close();
             socket.close();
             server.close();
         }catch (Exception e){
             e.printStackTrace();
         }
    }
}
