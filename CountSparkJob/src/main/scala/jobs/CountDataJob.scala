package global.coda
package jobs

import org.apache.spark.{SparkConf, SparkContext}

object CountDataJob {
  
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf()
    sparkConf.setAppName("CodaDataJOB")
    sparkConf.setMaster("spark://bdsncluster:7077")
    val sparkContext = new SparkContext(sparkConf)
    val textFileRDD = sparkContext.textFile("hdfs://localhost:9000/data/auth.csv")
    val countedElements = textFileRDD.count()
    println("-------------------------------")
    println(countedElements)
    println("-------------------------------")
    sparkContext.stop()
  }
}
