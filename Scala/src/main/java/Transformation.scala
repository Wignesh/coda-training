package ga.veee.Scala

object Transformation {
  def main(args: Array[String]): Unit = {
    val dataList = List("couchDB", "cassandra", "mongodb")
    //    dataList.foreach(each => println(each))
    //    dataList.foreach(println(_))
    //    dataList.foreach(println)
    val countriesList = List("Brazil", "Austria", "Bahamas", "Bangladesh", "Cook Islands")
    val countriesCodeList = List("BR", "AS", "BH", "BG", "CI")
    val countedElements = countriesList.count(each => each.startsWith("B"))
    print(countedElements)
    val zippedList = countriesList.zip(countriesCodeList)
    zippedList.foreach(each => println(each))
    val zippedIndex = countriesList.zipWithIndex
    val partitionedList = countriesList.partition(each => each.startsWith("B"))
    partitionedList._1.foreach(println)
    partitionedList._2.foreach(println)
  }
}
