package cn.zjc.ch2

import java.io._

/**
  * @author zjc
  * @version 2016/7/20 0:16
  */

//object里面的所有东西都是静态的
object ScalaBasic {

  def main(args: Array[String]): Unit = {
    //    println("scala basic")
    //    dowhile()
    //    println(looper(100,298))

    //    var file = if (!args.isEmpty) args(0) else "scala.txt"
    //    println(file)

    //原生循环写法
//    for (i <- 1 to 10) {
//      println(i)
//    }

    //获取当前工作目录下的所有文件,相当于System.getProperties("user.dir")
    var files = new File("./src/main/scala/cn/zjc/ch1").listFiles()  //返回的是一个File[]
    for(file<- files){
      println(file)  //输出文件列表
    }


    //异常处理
//    val n = 99
//    val file = "Spark.txt"
//    try {
//        var half = if (n% 2 == 0) n/2 else throw
//          new RuntimeException("N must be event")
//    }catch {
//      case e :Exception => println("The Exception is :" + e.getMessage)
//    }finally {
//      println("finally ")
//    }
//
//    println("抛出异常后是否会执行检验-----")
  }

  def dowhile(): Unit = {
    //一般变量
    var line = ""
    do {
      line = readLine()
      println("read: " + line)
    } while (line != "")
  }

  def looper(x: Long, y: Long): Long = {
    var a = x
    var b = y
    while (a != 0) {
      var temp = a;
      a = b % a
      b = temp
    }
    b
  }



}
