package ga.veee.Scala

import org.apache.spark.{SparkConf, SparkContext}

object SaveAsTextDataJob {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf()
    sparkConf.setAppName("CodaDataJOB")
    sparkConf.setMaster("local[*]")
    val sparkContext = new SparkContext(sparkConf)
    val textFileRDD = sparkContext.textFile("/Users/vignesh/Downloads/auth.csv")
    textFileRDD.saveAsTextFile("/Users/vignesh/Git/coda-training/Scala/src/savedTextFile")
    sparkContext.stop()
  }
}
