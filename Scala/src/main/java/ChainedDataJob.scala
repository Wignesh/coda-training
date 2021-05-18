package ga.veee.Scala

import org.apache.spark.{SparkConf, SparkContext}

object ChainedDataJob {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf()
    sparkConf.setAppName("CodaDataJOB")
    sparkConf.setMaster("local[*]")
    val sparkContext = new SparkContext(sparkConf)
//    val textFileRDD = sparkContext.textFile("/Users/vignesh/Downloads/auth.csv", 100)
//    val mappedRDD = textFileRDD.map(each => {
//      val columns = each.split(",")
//      println(columns(3))
//      (columns(3), columns(5))
//    })
//
//    val filteredRDD = mappedRDD.filter(each => !each._1.equals("740000"))
//    filteredRDD.collect().foreach(each => println(each))

    sparkContext.textFile("/Users/vignesh/Downloads/auth.csv", 100)
      .map(each => {
        val columns = each.split(",")
        println(columns(3))
        (columns(3), columns(5))
      })
      .filter(each => !each._1.equals("740000"))
      .collect()
      .foreach(each => println(each))
  }
}
