package ga.veee.Scala

object Filter {
  // Type Inferences : Scala is a type inferenced
  // Scala is a less verbose
  def main(args: Array[String]) = {
    // List
    // Set
    // Map
    val dataList = List("NoSQL", "Voldemort", "Hbase", "Cassandra", "CouchDB")
    //    for (eachElement <- dataList) {
    //      println(eachElement)
    //    }
    // Transformation
    // Set of methods in scala => help you acheieve business logic functionality
    // Lambda Expression
    // x => {}
    //dataList.foreach(each => println(each))
    //    val filteredList = dataList.filter(each => each.startsWith("C"))
    //    filteredList.foreach(each => println(each))
    val mappedList = dataList.map(each => computeData(each))
    mappedList.foreach(each => println(each))
  }

  def computeData(input: String) = {
    input.concat("_VIGNESH")
  }

}
