package ga.veee.Scala

object Countries {
  def main(args: Array[String]): Unit = {
    val countries = List("Brazil", "Austria", "Bahamas", "Bangladesh", "Cook Islands")
    println("Tail Elements")
    countries.tail.foreach { x => println(x) }
    println("Head Element")
    println(countries.head)
  }
}
