package cn.zjc.ch3

/**
  * @author zjc
  * @version 2016/7/21 0:50
  */
object MapOperation {

  def main(args: Array[String]): Unit = {
    val args = Map("name" -> "zjc", "age" -> 25)
    for ((k, v) <- args) {
      println("key is " + k + " value = " + v)
    }

    //占位符 不打印value,只打印全部key
    for ((k, _) <- args) {
      println("key is " + k)
    }
  }
}
