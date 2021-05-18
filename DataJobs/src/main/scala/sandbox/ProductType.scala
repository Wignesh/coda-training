package ga.veee
package sandbox

import org.apache.spark.sql.DataFrame


object ProductType {
  def main(args: Array[String]): Unit = {
    val sales = DataFrames.getDataFrame("/Users/vignesh/Downloads/sales.csv", "SALES1")

    sales
      .select("Product type")
      .where(sales.col("Product line") === "Golf Equipment")
      .distinct()
      .show()
    /*
    * In the sales.csv attached, for the ProductLine=“Golf Equipment” how many ProductType are there ?
    *
    */
  }

}
