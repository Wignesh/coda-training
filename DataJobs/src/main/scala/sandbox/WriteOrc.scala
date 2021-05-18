package ga.veee
package sandbox

object WriteOrc {
  def main(args: Array[String]): Unit = {
    val auaASALicenseDF = DF.getGroups
    auaASALicenseDF.write.orc("/Users/vignesh/Git/coda-training/DataJobs/src/data/orc")
  }
}
