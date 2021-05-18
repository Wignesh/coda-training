package ga.veee
package sandbox

  object WordCount {
  def main(args: Array[String]): Unit = {
    val sparkSession = SparkSession.getSession
    val sparkContext = sparkSession.sparkContext
    sparkContext.textFile("/Users/vignesh/Git/coda-training/DataJobs/src/main/scala/sandbox/data.txt")
      .flatMap(each => each.split(" "))
      .map(each => (each, 1))
      .reduceByKey(_ + _)
      .foreach(println)
  }
}
