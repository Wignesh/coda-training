package ga.veee.Scala


object Procedure {
  // Procedure
  def logFatal(fatalMessage: String) = println(s"Error : $fatalMessage")

  def main(args: Array[String]): Unit = {
    logFatal("Error in exec")

  }
}
