package cn.zjc.ch6

/**
  * @author zjc
  * @version 2016/7/22 0:28
  * @description
  *
  */
object Map_Tuple {

  def main(args: Array[String]): Unit = {
    //把两个数组的相同索引的值拼接（拉链操作）("[2","-5","]8")
    val symbols = Array("[","-","]")
    val counts = Array(2,5,8)
    val pairs = symbols.zip(counts)




    //这样实例化的map不可以改变
    val map = Map("book" -> 10, "gun" -> 20, "ipad" -> 2000)

    for ((k, v) <- map) yield (k, v * 0.9)

    //这样实例化的map是可以修改的
    val scores = scala.collection.mutable.Map("book" -> 10, "gun" -> 20, "ipad" -> 2000)
    //如果不存在key则返回设置的值
    val value = scores.getOrElse("hadoop", 0)
    //从map中添加值
    scores += ("R" -> 9)
    //从map中删去值
    scores -= "gun"

    //类似于TreeMap
    val sortScore = scala.collection.immutable.SortedMap("book" -> 10, "gun" -> 20, "ipad" -> 2000)

    //Tuple(类似于数组，但是每个元素都可以自定义类型（混合类型）)
    val tuple = (1,2,3,4,"Rocky","Spark")
    val third = tuple._3

    //tuple反向赋值
    val (first,second,thirda,fourth,fifth,sixth) = tuple

    //下划线作为占位符，只返回前两个元素
    val (f,s,_,_,_,_) = tuple

    //partition辅助函数，把大写字母分为一组，其他字母抽离再分组
    "Rocky Spark".partition(_.isUpper)
  }
}