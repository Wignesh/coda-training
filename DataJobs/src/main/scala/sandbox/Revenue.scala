package ga.veee
package sandbox

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions.{asc, sum}
import org.apache.spark.sql.types.DataTypes

object Revenue {
  def main(args: Array[String]): Unit = {
    val sparkSession = SparkSession.getSession

    val sales1 = getDataFrame("/Users/vignesh/Downloads/sales1.csv", "SALES1", sparkSession)

    val sales2 = getDataFrame("/Users/vignesh/Downloads/sales2.csv", "SALES2", sparkSession)

    val countries = sales1
      .select("Retailer country")
      .where(sales1.col("Retailer country").isNotNull)
      .distinct()

    val revenues = sales2
      .withColumn("Revenue", sales2.col("Revenue").cast(DataTypes.LongType).as("Revenue"))
      .select("Retailer country", "Revenue")
      .where(sales2.col("Revenue").isNotNull)
      .where(sales2.col("Retailer country").isNotNull)
      .groupBy(sales2.col("Retailer country"))
      .agg(sum("Revenue").as("Revenue"))


    val allRevenues = countries
      .join(revenues, "Retailer country")
      .orderBy(asc("Retailer country"))

    println("All countries revenue")
    allRevenues.show(numRows = 30, truncate = false)


    println("France revenue")
    allRevenues
      .select("Retailer country", "Revenue")
      .where(allRevenues("Retailer country") === "France")
      .show()
    /*
    In the sales.csv attached, What is the total revenue for the “Retailer Country” = France ?
      Solve the above problem using dataframe. Fetch the Retailer Country from sales1.csv and revenue
      count from another sales2.csv and compute the revenue by joining them. Sales1.csv and Sales2.csv
      are both identical copies.
    */
  }

  def getDataFrame(path: String, viewName: String, sparkSession: org.apache.spark.sql.SparkSession): DataFrame = {
    val dataFrame = sparkSession
      .read
      .option("header", "true")
      .csv(path)
    dataFrame
      .createOrReplaceTempView(viewName)
    dataFrame
  }
}
