package ga.veee
package sandbox

object DistinctTransformation {
  def main(args: Array[String]): Unit = {
    val textFileRDD = SparkSession.getSession.sparkContext.textFile("/Users/vignesh/Downloads/auth.csv")
    val distinctRDD = textFileRDD.map(each => {
      val columns = each.split(",")
      (columns(2))
    }).distinct()

    distinctRDD.foreach(println)

  }
}
