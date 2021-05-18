package ga.veee
package sandbox

object WriteText {
  def main(args: Array[String]): Unit = {
    val auaASALicenseDF = DF.getGroups
    auaASALicenseDF.write.text("/Users/vignesh/Git/coda-training/DataJobs/src/data/text")
  }
}
