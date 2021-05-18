package ga.veee.Scala

import coda.dataprocessing.DataProcessingReckoner

object DataJobs {
  // Type Inferences : Scala is a type inferenced
  // Scala is a less verbose
  // Scala is a expressive language of programming
  def main(args : Array[String]) = {
    val dataList = List("NoSQL", "Voldemort", "Hbase", "Cassandra", "CouchDB")
    val dataSet = Set("NoSQL", "Voldemort", "Voldemort", "Hbase", "Cassandra", "CouchDB")
    dataSet.foreach(each => println(each))
    val dataTuple = ("NoSQL", "Voldemort", "Voldemort", "Hbase", "Cassandra", "CouchDB")
    val dataMap = Map(10001 -> "DocumentStore", 10002 -> "KV Store", 10004 -> "KV Cache")
    dataMap.foreach(each => println(each._1))
    dataMap.foreach(each => println(each._2))
    //val dataProcessing1 = new DataProcessingReckoner();
    //val dataProcessing2 = new DataProcessingReckoner()
    val dataProcessing = new DataProcessingReckoner
    dataProcessing computeBigData "OracleDB"
  }
}