package ga.veee
package sandbox

object WriteJson {
  def main(args: Array[String]): Unit = {
    val auaASALicenseDF = DF.getGroups
    auaASALicenseDF.write.json("/Users/vignesh/Git/coda-training/DataJobs/src/data/json")
  }
}
