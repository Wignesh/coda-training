package ga.veee.Scala

import org.apache.spark.{SparkConf, SparkContext}

object CollectDataJob {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf()
    sparkConf.setAppName("CodaDataJOB")
    sparkConf.setMaster("local[*]")
    val sparkContext = new SparkContext(sparkConf)
    val textFileRDD = sparkContext.textFile("/Users/vignesh/Downloads/auth.csv")
    val collectElements = textFileRDD.collect()
    collectElements.foreach(each => println(each))
    sparkContext.stop()
  }
}
