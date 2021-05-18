package ga.veee.Scala

import org.apache.spark.{SparkConf, SparkContext}

object SavePoint {
  def main(args: Array[String]): Unit = {
    // RDD - Resilient Distributed Data
    // Transformation - RDD
    // Action - Scala Data Object
    // RDD - Partitions
    // RDD - Lazy Loaded
    // RDD are resilient - fault tolerant
    // RDD are immutable
    // RDD are distributed
    // RDD contains partitions and partitions internally contain data
    def main(args: Array[String]) = {
      val sparkConf = new SparkConf()
      sparkConf.setAppName("CodaDataJOB")
      sparkConf.setMaster("local[*]")
      val sparkContext = new SparkContext(sparkConf)
      sparkContext.setCheckpointDir("/Users/vignesh/Downloads/checkpointDirectory")
      // Spark should always talk to HDFS file system
      val textFileRDD = sparkContext.textFile("/Users/vignesh/Downloads/auth.csv", 100)
      val mappedRDD = textFileRDD.map(each => {
        val columns = each.split(",")
        println(columns(3))
        (columns(3), columns(5))
      })
      val filteredRDD = mappedRDD.filter(each => !each._1.equals("740000"))
      filteredRDD.checkpoint()

      filteredRDD.collect().foreach(each => println(each))
      sparkContext.stop()
    }
  }
}
