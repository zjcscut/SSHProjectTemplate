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
import java.net.Socket;

/**
 * @author zhangjinci
 * @version 2016/9/9 11:47
 * @function
 */
public class Client {

    public static void main(String[] args){
         String msg = "Hello World!";
         try {
             Socket socket = new Socket("127.0.0.1",9080);

             PrintWriter writer = new PrintWriter(socket.getOutputStream());
             BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));

             writer.println(msg);
             writer.flush();
             String line = is.readLine();
             System.out.println("receive data from server:" + line);

             writer.close();
             is.close();
             socket.close();
         }catch (Exception e){
             e.printStackTrace();
         }
    }
}
