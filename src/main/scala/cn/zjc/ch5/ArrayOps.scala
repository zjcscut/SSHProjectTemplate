package cn.zjc.ch5

/**
  * @author zjc
  * @version 2016/7/21 23:47
  *
  */
object ArrayOps {

  def main(args: Array[String]): Unit = {
    val s= Array("Hello","World")
    s(0) = "GoodBye"
    for(elem <- s) println(elem)
  }

}
