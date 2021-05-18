package ga.veee.Scala

object Method {
  def main(args: Array[String]): Unit = {
    computeData(1001, "HBase")
    println(computedData(1001, "HBase"))
    println(sum(1, 2))
    weaveData(10001, "StarDog", true)
    weaveData(id = 10001, name = "StarDog", isLoggable = true)
    weaveData(10001, "StarDog", true)
    weaveData(name = "StarDog", isLoggable = true)
    monopolizeDaa("a", "b", "c")
  }

  def computeData(id: Int, dataName: String): Unit = {
    println("Id is - " + id + " data is - " + dataName)
  }

  def computedData(id: Int, dataName: String): String = {
    val concat = "Cassandra_" + dataName
    concat
  }

  def sum(a: Int, b: Int): Int = {
    a + b
  }

  def monopolizeDaa(args: String*): Unit = {
    for (arg <- args) {
      println(arg)
    }
  }

  def +(data: Int): Unit = {

  }

  def weaveData(id: Int = 3000, name: String, isLoggable: Boolean) = {
  }
}
