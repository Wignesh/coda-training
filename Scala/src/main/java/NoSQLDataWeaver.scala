package ga.veee.Scala

// Java - Object oriented (Objects)
// Scala - OO + FP (Functions)
// Scala is a less verbose, type inference,functional language
object NoSQLDataWeaver {
  def weaveData(id: Int = 3000, name: String, isLoggable: Boolean) = {
  }

  // Procedure
  def logFatal(fatalMessage: String) = println(s"Error : $fatalMessage")

  def +(data: Int): Unit = {

  }

  def monopolizeDaa(args: String*): Unit = {
    for (arg <- args) {
      println(arg)
    }
  }

  def main(args: Array[String]): Unit = {
    logFatal("Error in exec")
    weaveData(10001, "StarDog", true)
    weaveData(id = 10001, name = "StarDog", isLoggable = true)
    weaveData(10001, "StarDog", true)
    weaveData(name = "StarDog", isLoggable = true)
    monopolizeDaa("a", "b", "c")
  }
}
//1073