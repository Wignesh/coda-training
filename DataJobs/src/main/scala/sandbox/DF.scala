package ga.veee
package sandbox

import org.apache.spark.sql.DataFrame

object DF {
  private val sparkSession = SparkSession.getSession

  private val authDF = sparkSession.read
    .option("header", "true")
    .csv("/Users/vignesh/Downloads/auth.csv")

  private val auaASALicenseDF = authDF.select("aua", "sa", "license_id")

  def getGroups: DataFrame = {
    auaASALicenseDF
  }
}
