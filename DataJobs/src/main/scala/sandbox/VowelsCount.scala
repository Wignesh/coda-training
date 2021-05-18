package ga.veee
package sandbox

object VowelsCount {
  def main(args: Array[String]): Unit = {
    val sparkContext = SparkSession.getSession.sparkContext
    sparkContext.textFile("/Users/vignesh/Git/coda-training/DataJobs/src/main/scala/sandbox/data.txt")
      .distinct()
      .foreach(println)
  }
}
