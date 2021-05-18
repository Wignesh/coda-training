package ga.veee
package sandbox

object CSVSelect {
  // Dataframe is also immutable in nature
  def main(args: Array[String]): Unit = {

    val sparkSession = SparkSession.getSession

    val authDF = sparkSession.read
      .option("header", "true")
      .csv("/Users/vignesh/Downloads/auth.csv")

    val auaASALicenseDF = authDF.select("aua", "sa", "license_id")


    auaASALicenseDF.show()
  }
}
