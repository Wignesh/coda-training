package ga.veee
package sandbox

object SortMerge {
  def main(args: Array[String]): Unit = {
    val sparkSession = org.apache.spark.sql.SparkSession.builder()
      .appName("CodaDataJOB")
      .master("local[*]")
      .config("spark.sql.join.preferSortMergeJoin", "true")
      .getOrCreate()

    val customerColumns = Seq("ID", "Login")
    val customerRows = Seq((2, "User#2"), (1, "User#1"), (4, "User#4"), (3, "User#3"))
    val customer = sparkSession.createDataFrame(customerRows).toDF(customerColumns: _*)
    customer.createOrReplaceTempView("CUSTOMER")
    val ordersColumns = Seq("ID", "User_ID")
    val ordersRows = Seq((1001, 2), (1002, 4), (1003, 4), (1004, 1))
    val orders = sparkSession.createDataFrame(ordersRows).toDF(ordersColumns: _*)
    orders.createOrReplaceTempView("ORDER")

    customer
      .join(orders, orders.col("User_Id") === customer.col("ID"))
      .explain()

  }
}
