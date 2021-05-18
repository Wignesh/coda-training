package ga.veee.Scala

import scala.io.Source

object FileRead {
  def main(args: Array[String]): Unit = {
    val file = Source.fromFile("/Users/vignesh/Downloads/auth.csv")
    val lines = file.getLines()
    for (eachLine <- lines) {
      val columns = eachLine.split(",")
      println(" | " + columns(0) + " | " + columns(8) + " | ")
    }
  }

}
