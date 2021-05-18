package ga.veee
package sandbox

import org.apache.spark.sql.DataFrame

object DataFrames {
  def getDataFrame(path: String, viewName: String, sparkSession: org.apache.spark.sql.SparkSession): DataFrame = {
    val dataFrame = sparkSession
      .read
      .option("header", "true")
      .csv(path)
    dataFrame
      .createOrReplaceTempView(viewName)
    dataFrame
  }

  def getDataFrame(path: String, viewName: String): DataFrame = {
    val dataFrame = SparkSession
      .getSession
      .read
      .option("header", "true")
      .csv(path)
    dataFrame
      .createOrReplaceTempView(viewName)
    dataFrame
  }
}
