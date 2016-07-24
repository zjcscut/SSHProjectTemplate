package cn.zjc.ch4

import scala.io.Source

/**
  * @author zjc
  * @version 2016/7/21 1:15
  * 懒加载
  */
object LazyOps {
  def main(args: Array[String]): Unit = {
    //lazy只有第一次被使用的时候才会实例化,懒加载
    lazy val file = Source.fromFile("C:\\sss.test")

    for(line<- file){
      println(line)
    }
  }
}
