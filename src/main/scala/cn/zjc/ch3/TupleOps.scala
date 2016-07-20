package cn.zjc.ch3

/**
  * @author zjc
  * @version 2016/7/21 0:44
  */
object TupleOps {
  //灵活的tuple
  def main(args: Array[String]): Unit = {
    val triple = (100, "scala", "Spark");
    println(triple._1)
    println(triple._2)
    println(triple._3)
  }
}
