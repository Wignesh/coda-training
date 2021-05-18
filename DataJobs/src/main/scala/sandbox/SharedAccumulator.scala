package ga.veee
package sandbox

object SharedAccumulator {
  // Job - DriverProgram - Stage - Task
  // Dataframe is also immutable in nature
  // Accumulator / Broadcast
  def main(args: Array[String]) = {
    // master
    val ss = SparkSession.getSession
    // How many number of authentication rows are there for the State = Karnataka
    // using accumulator
    // master
    val sc = ss.sparkContext
    // master
    val sharedAccumulator = sc.longAccumulator("SharedAccumulator")
    // worker
    val textFileRDD = sc.textFile("/Users/vignesh/Downloads/auth.csv")
    // worker
    val mappedRDD = textFileRDD.map(each => {
      val columns = each.split(",")
      if (columns(128).equals("Karnataka"))
        sharedAccumulator.add(1L)
    })
    // collected data will come to the master
    mappedRDD.collect()
    // master
    println("Total Count " + sharedAccumulator.value)
  }
}