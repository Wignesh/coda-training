package ga.veee
package sandbox

import org.apache.spark.sql.types.DataTypes

object ServiceAgency {
  def main(args: Array[String]): Unit = {
    val auth = DataFrames.getDataFrame("/Users/vignesh/Downloads/auth.csv", "AUTH", SparkSession.getSession)
    auth
      .withColumn("AUA", auth.col("AUA").cast(DataTypes.LongType).as("AUA"))
      .select("SA")
      .filter(auth.col("AUA") > 650000 && auth.col("RES_STATE_NAME").notEqual("Delhi") && !auth.col("SA").isNaN)
      .show(false)
  }
}
