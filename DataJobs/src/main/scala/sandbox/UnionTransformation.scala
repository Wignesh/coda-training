package ga.veee
package sandbox

import org.apache.spark.sql.functions.col

object UnionTransformation {

  def main(args: Array[String]): Unit = {

    val authDF = SparkSession
      .getSession
      .read
      .option("header", "true")
      .csv("/Users/vignesh/Downloads/auth.csv")

    authDF
      .createOrReplaceTempView("AUTH")


    val uid = authDF
      .select("uid_gen_date")
      .where(col("uid_gen_date").isNotNull)
      .toJavaRDD

    val uid2012 = uid
      .filter(
        row =>
          row
            .getString(0)
            .startsWith("2012")
      )

    val uid2013 = uid
      .filter(
        row =>
          row
            .getString(0)
            .startsWith("2013")
      )

    uid2012
      .union(uid2013)
      .foreach(println)

  }
}
