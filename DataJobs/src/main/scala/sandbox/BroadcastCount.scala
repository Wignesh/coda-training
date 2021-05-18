package ga.veee
package sandbox

object BroadcastCount {
  def main(args: Array[String]) = {
    //M

    // States - Replace the state name with the state code using broadcast
    // Rajasthan - RH
    // M
    val sc = SparkSession.getSession.sparkContext
    // W
    val textRDD = sc.textFile("/Users/vignesh/Downloads/auth.csv")
    val states = Map(("Rajasthan", "RH"),
      ("Andhra Pradesh", "AN"),
      ("Tamil Nadu", "TN"))
    val broadcastStates = sc.broadcast(states)
    // W
    val resStateColumnRDD = textRDD.map(each => each.split(",")(128))
    // W
    val accumulatorCalculationRDD = resStateColumnRDD.map(each => {
      if (each.trim != null) {
        val bS = broadcastStates.value.get(each.trim)
        if (bS.isDefined) {
          bS.get
        } else "NA"
      }
    })
    // M/W - result to the master
    accumulatorCalculationRDD.foreach(println)
  }
}
