package ga.veee.Scala

// Write down the problem statement
// Nouns - Classes
// Adverb - function
// Abstract Nouns - interfaces / Abstract Classes
object Reducer {
  def main(args: Array[String]): Unit = {
    val numList = List(1, 2, 3, 4, 5)

    var result = numList.reduce((x, y) => x + y)
    println(result)
    result = numList.reduceRight((x, y) => x + y)
    println(result)
    result = numList.reduceLeft((x, y) => x + y)
    println(result)
  }
}
