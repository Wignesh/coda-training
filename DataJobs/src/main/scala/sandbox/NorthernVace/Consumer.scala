package ga.veee
package sandbox.NorthernVace

import sandbox.Utils.Utils

import org.apache.log4j.Level

import java.time.Duration
import java.util
import scala.collection.JavaConverters.iterableAsScalaIterableConverter

object Consumer {
  def main(args: Array[String]): Unit = {

    val consumer = Utils.getConsumer()
    val TOPIC = "NORTHERN-VACE"

    consumer.subscribe(util.Arrays.asList(TOPIC))

    while (true) {
      val records = consumer.poll(Duration.ofMillis(100))
      for (record <- records.asScala) {
        println(" Printing the key and value - key - " + record.key() + " value - " + record.value())
      }
    }
  }
}
