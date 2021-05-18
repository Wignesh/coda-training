package ga.veee
package sandbox

object SparkSession {
  private val sparkSession = org.apache.spark.sql.SparkSession.builder()
    .appName("CodaDataJOB")
    .master("local[*]")
    .getOrCreate()

  sparkSession
    .sparkContext
    .setLogLevel("OFF")

  def getSession: org.apache.spark.sql.SparkSession = {
    sparkSession
  }

}
