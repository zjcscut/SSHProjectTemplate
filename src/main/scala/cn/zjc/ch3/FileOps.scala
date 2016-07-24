package cn.zjc.ch3

import scala.io.Source

/**
  * @author zjc
  * @version 2016/7/21 0:53
  *          文件操作
  */
object FileOps {
  def main(args: Array[String]): Unit = {
    //从文件读取内容
    //    val file = Source.fromFile("J:\\red.txt")
    //从网页读取文件内容
    val file = Source.fromURL("https://www.baidu.com")
    for (line <- file) {
      println(line)
    }
  }
}
