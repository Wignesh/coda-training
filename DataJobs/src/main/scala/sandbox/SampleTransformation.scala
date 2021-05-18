package ga.veee
package sandbox

object SampleTransformation {
  def main(args: Array[String]): Unit = {
    SparkSession
      .getSession
      .sparkContext
      .textFile("/Users/vignesh/Downloads/auth.csv")
      .map(each => {
        val columns = each.split(",")
        (columns(2))
      })
      .sample(withReplacement = true, 0.2)
      .foreach(println)
  }
}
