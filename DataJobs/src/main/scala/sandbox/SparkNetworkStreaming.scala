package ga.veee
package sandbox

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

object SparkNetworkStreaming {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf()
      .setAppName("NetworkWordCount")
      .setMaster("local[*]")

    val streamingContext = new StreamingContext(sparkConf, Seconds(1))
    streamingContext.sparkContext.setLogLevel("OFF")

    val lines = streamingContext.socketTextStream("localhost", 8888)

    val words = lines
      .flatMap(_.split(" "))

      words
      .map(x => (x, 1))
      .reduceByKey(_ + _)
      .print()

    streamingContext.start()

    streamingContext.awaitTermination()
  }
}
