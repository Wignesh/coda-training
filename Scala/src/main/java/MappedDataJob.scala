package ga.veee.Scala

import org.apache.spark.{SparkConf, SparkContext}

object MappedDataJob {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf()
    sparkConf.setAppName("CodaDataJOB")
    sparkConf.setMaster("local[*]")
    val sparkContext = new SparkContext(sparkConf)
    val textFileRDD = sparkContext.textFile("/Users/vignesh/Downloads/auth.csv")
    val mappedRDD = textFileRDD.map(each => {
      val columns = each.split(",")
      (columns(3), columns(5))
    })
    mappedRDD.saveAsObjectFile("/Users/vignesh/Downloads/mappedRDDObject")
    mappedRDD.foreach(each => println(each))
    sparkContext.stop()
  }
}
