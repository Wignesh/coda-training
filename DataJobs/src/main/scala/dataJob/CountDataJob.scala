package ga.veee
package dataJob

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
    println("Counting.....")
    for (i <- 1 to 10) {
      Thread.sleep(1000)
      println(i)
    }
    println("-------------------------------")
    println(countedElements)
    println("-------------------------------")
    sparkContext.stop()
  }
}
//spark-submit --name CodaDataJOB --master spark://bdsncluster:7077 --deploy-mode client --class ga.veee.dataJob.CountDataJob fs/data/DataJobs.jar
