package ga.veee.Scala

import org.apache.spark.{SparkConf, SparkContext}

object SaveAsObjectDataJob {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf()
    sparkConf.setAppName("CodaDataJOB")
    sparkConf.setMaster("local[*]")
    val sparkContext = new SparkContext(sparkConf)
    val textFileRDD = sparkContext.textFile("/Users/vignesh/Downloads/auth.csv")
    textFileRDD.saveAsObjectFile("/Users/vignesh/Git/coda-training/Scala/src/savedObjectFile.csv")
    sparkContext.stop()
  }

}
