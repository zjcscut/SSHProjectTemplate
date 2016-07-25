package cn.zjcscut.compile;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Target {

  public static void main(String[] args){
      System.out.println("Hello World! Today is ---------------" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
  }
}
