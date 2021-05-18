package ga.veee.Scala

import org.apache.spark.{SparkConf, SparkContext}

object PartionDataJob {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf()
    sparkConf.setAppName("CodaDataJOB")
    sparkConf.setMaster("local[*]")
    val sparkContext = new SparkContext(sparkConf)
    // Spark should always talk to HDFS file system
    val textFileRDD = sparkContext.textFile("/Users/vignesh/Downloads/auth.csv", 100)
    val mappedRDD = textFileRDD.map(each => {
      val columns = each.split(",")
      println(columns(3))
      (columns(3), columns(5))
    })
    mappedRDD.collect()
  }
}
