package ga.veee
package sandbox

object CartesianTransformations {
  def main(args: Array[String]): Unit = {
    val textFileRDD = SparkSession.getSession.sparkContext.textFile("/Users/vignesh/Downloads/auth.csv")
    val auaRDD = textFileRDD.map(each => {
      val columns = each.split(",")
      (columns(2))
    })

    val saRDD = textFileRDD.map(each => {
      val columns = each.split(",")
      (columns(2))
    })

    auaRDD.cartesian(saRDD).foreach(println)

  }

}
