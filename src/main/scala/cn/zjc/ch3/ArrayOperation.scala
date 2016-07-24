package cn.zjc.ch3

/**
  * @author zjc
  * @version 2016/7/21 0:46
  * 数组
  */
object ArrayOperation {

  def main(args: Array[String]): Unit = {
    val array = Array(1,2,3,4,5,6)
    for(i <- 0 until array.length){
      println(array(i))
    }

    //简洁写法
    for(i<- array){
      println(i)
    }
  }
}
