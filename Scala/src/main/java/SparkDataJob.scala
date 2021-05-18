package ga.veee.Scala

import org.apache.spark.{SparkConf, SparkContext}


object SparkDataJob {
  // RDD - Resilient Distributed Data
  // Transformation - RDD
  // Action - Scala Data Object
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf()
    sparkConf.setAppName("CodaDataJOB")
    sparkConf.setMaster("local[*]")
    val sparkContext = new SparkContext(sparkConf)
    val textFileRDD = sparkContext.textFile("/Users/vignesh/Downloads/auth.csv")
    textFileRDD.foreach(each => println(each))
    sparkContext.stop()
  }

}
