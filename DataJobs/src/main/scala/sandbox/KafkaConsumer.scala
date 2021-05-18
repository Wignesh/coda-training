package ga.veee
package sandbox

import org.apache.kafka.clients.consumer.{ConsumerConfig, KafkaConsumer}

import java.util
import java.util.Properties
import scala.collection.JavaConverters.iterableAsScalaIterableConverter

object KafkaConsumer {
  def main(args: Array[String]) = {
    val props = new Properties()
    props.put("bootstrap.servers", "localhost:9092")
    // When changed the consumer group, it behaves as a TOPIC or QUEUE
    props.put("group.id", "Coda-Group-2")
    //props.put("enable.auto.commit", "true")
    props.put("auto.commit.interval.ms", "1000")
    props.put("session.timeout.ms", "30000")
    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true")
    props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000")
    val consumer = new KafkaConsumer[String, String](props)
    consumer.subscribe(util.Arrays.asList("CASSANDRA-TOPIC"))
    while (true) {
      val records = consumer.poll(1)
      for (record <- records.asScala) {
        println(" Printing the key and value - key - " + record.key() + " value - " + record.value())
      }
    }
  }
}
