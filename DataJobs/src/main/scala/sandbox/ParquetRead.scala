package ga.veee
package sandbox

object ParquetRead {
  def main(args: Array[String]): Unit = {
    val authDF = SparkSession.getSession.read
      .option("header", "true")
      .parquet("/Users/vignesh/Git/coda-training/DataJobs/src/data/parquet")
    authDF.show()
  }
}
