package ga.veee.Scala

object CaseClass {
  def main(args: Array[String]): Unit = {
    val dataList = List("Nosql", "datadog", "couchdb")
    val mappedList = dataList.map(each => {
      NoSQL(each, each.length)
    })
    mappedList.foreach(each => println(each.name, each.lengthOfNosql))
  }
}

case class NoSQL(name: String, lengthOfNosql: Int)