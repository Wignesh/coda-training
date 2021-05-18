package ga.veee
package sandbox


object WriteParquet {
  def main(args: Array[String]): Unit = {
    val auaASALicenseDF = DF.getGroups
    auaASALicenseDF.write.parquet("/Users/vignesh/Git/coda-training/DataJobs/src/data/parquet")
  }

}
