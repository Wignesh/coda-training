package ga.veee
package sandbox

import org.apache.spark.sql.functions.desc

object CountPeople {
  def main(args: Array[String]): Unit = {

    val authDF = SparkSession
      .getSession
      .read
      .option("header", "true")
      .csv("/Users/vignesh/Downloads/auth.csv")

    authDF.createOrReplaceTempView("AUTH_TABLE")

    authDF.select("RES_STATE_NAME")
      .groupBy("RES_STATE_NAME")
      .count()
      .orderBy(desc("count"))
      .show(50)


    SparkSession
      .getSession
      .sql("SELECT RES_STATE_NAME,COUNT(*) AS COUNT FROM AUTH_TABLE GROUP BY RES_STATE_NAME ORDER BY COUNT DESC")
      .show(50)
  }
}
