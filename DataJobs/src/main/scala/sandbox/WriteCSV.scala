package ga.veee
package sandbox

object WriteCSV {
  def main(args: Array[String]): Unit = {
    val auaASALicenseDF = DF.getGroups

    auaASALicenseDF.write.csv("/Users/vignesh/Git/coda-training/DataJobs/src/data/csv")

  }


}
