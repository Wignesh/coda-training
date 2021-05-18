package ga.veee.Scala

import scala.io.Source

object BufferedFileRead {
  def main(args: Array[String]): Unit = {
    val bufferedSource = Source.fromFile("/Users/vignesh/Downloads/auth.csv")

    for (line <- bufferedSource.getLines()) {
      val columns = line.split(",").map(_.trim)
      println(" | " + columns(0) + " | " + columns(8) + " | ")
    }
    bufferedSource.close()
  }

}
