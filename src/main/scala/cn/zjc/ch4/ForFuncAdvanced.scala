package cn.zjc.ch4

/**
  * @author zjc
  * @version 2016/7/21 0:59
  */
object ForFuncAdvanced {
  def main(args: Array[String]): Unit = {
    /**
      * for( 1 <= i <= 2) {
      * for(1 <= j <= 2){}
      * }
      */
    for (i <- 1 to 2; j <- 1 to 2) {
      print((100 * i + j) + " ")
    }
    println()


    /**
      * for( 1 <= i <= 2) {
      * for(1 <= j <= 2){
      * if (i != j){
      *
      * }
      * }
      * }
      */
    for (i <- 1 to 2; j <- 1 to 2 if i != j) {
      print((100 * i + j) + " ")
    }
    println()

    //函数必须有返回值，这样是实现函数式编程的基础(返回值是Scala自己推断出来)
    //命名函数
    def addA(x: Int) = x + 100

    //匿名函数
    val add = (x: Int) => x + 200
    println("result1 === " + addA(1))
    //匿名函数可以这样传参数
    println("result1 === " + add(2))

    def fac(n: Int): Int = if (n <= 0) 1 else n * fac(n - 1)
    println("fac result === " + fac(10))

    //设置默认值(默认参数)
    def combine(content: String, left: String = "{", right: String = "}"): String = left + content + right
    println("combine result === " + combine("zjc","<<",">>"))

    //函数参数是可变的
    def connected (args:Int*)={
      var result = 0
      for (arg <- args) result += arg
      result
    }
    println("the result form a connected is:" + connected(1,2,3,4,5,6))
  }
}
