import scala.collection.mutable.ArrayBuffer
import scala.util.Sorting.quickSort

object ScalaAction {
  val nums = new Array[Int](10)
  val a = new Array[String](10)
  println("hello")
  val s = Array("Hello", "World")
  s(0) = "GoodBye"
  for (elem <- s) println(elem)

  //ArrayBuffer为动态数组可以添加新元素
  val b = ArrayBuffer[Int]()
  b += 1
  b += (1, 2, 3, 5)
  b ++= Array(8, 13, 21)

  b

  //切去后面五个元素
  b.trimEnd(5)
  b

  //在索引为2的位置插入元素6
  b.insert(2, 6)
  b

  //在索引为2的位置插入数组（7,8,9）
  b.insert(2, 7, 8, 9)
  b

  //删除索引为2的元素
  b.remove(2)
  b
  //删除索引为2起始的后三个元素
  b.remove(2, 3)
  b

  b.toArray
  b

  val c = Array(2, 3, 5, 7, 11)
  //这样表达式会变为Array
  val result = for (elem <- c) yield 2 * elem

  //选择数组中为偶数的元素
  for (elem <- c if elem % 2 == 0) yield 2 * elem

  //选择数组中为偶数的元素
  c.filter(_ % 2 == 0).map(2 * _)

  //聚合求和
  Array(1, 2, 3, 5, 4).sum

  //求最大长度字符串
  ArrayBuffer("Marry", "had", "a", "little", "lamb").max

  //排序
  val d = ArrayBuffer(1, 7, 2, 9)
  val bSorted = d.sorted

  val e = Array(1, 7, 2, 9)
  quickSort(e)
  e

  //在数组之间插入"and"，简直碉堡
  e.mkString(" and ")

  //用<>围住数组
  e.mkString("<", ",", ">")

  //构建二维数组（矩阵）
  val matrix = Array.ofDim[Double](3,4)
  matrix(2)(1) = 42
  matrix

  //数组的元素是数组,第一个元素是数组，有一个元素
  val triangle = new Array[Array[Int]](10)
  for(i<- 0 until triangle.length)
    triangle(i) = new Array[Int](i + 1)
    triangle

}