package ga.veee
package sandbox

object CSVRead {
  def main(args: Array[String]): Unit = {
    val sparkSession = SparkSession.getSession
    val authDF = sparkSession.read
      .option("header", "true")
      .csv("/Users/vignesh/Downloads/auth.csv")
    authDF.createOrReplaceTempView("AUTH_TABLE")
    val auaASADF = sparkSession.sql("SELECT AUA,ASA FROM AUTH_TABLE")
    auaASADF.show()
  }
}
