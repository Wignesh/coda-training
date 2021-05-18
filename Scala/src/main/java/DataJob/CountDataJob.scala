package ga.veee.Scala
package DataJob

import org.apache.spark.{SparkConf, SparkContext}

object CountDataJob {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf()
    sparkConf.setAppName("CodaDataJOB")
    sparkConf.setMaster("local[*]")
    val sparkContext = new SparkContext(sparkConf)
    val textFileRDD = sparkContext.textFile("/Users/vignesh/Downloads/auth.csv")
    val countedElements = textFileRDD.count()
    println(countedElements)
    sparkContext.stop()
  }
}
}
