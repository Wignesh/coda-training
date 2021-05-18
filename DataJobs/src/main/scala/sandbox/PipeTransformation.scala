package ga.veee
package sandbox

object PipeTransformation {
  def main(args: Array[String]): Unit = {
    val textFileRDD = SparkSession.getSession.sparkContext.textFile("/Users/vignesh/Downloads/auth.csv")
    textFileRDD.pipe("ls -l").foreach(println)
  }
}
