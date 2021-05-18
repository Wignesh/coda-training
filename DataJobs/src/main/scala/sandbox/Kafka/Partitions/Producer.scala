package ga.veee
package sandbox.Kafka.Partitions

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

import java.util.Properties

object Producer {
  def main(args: Array[String]): Unit = {

    val props = new Properties()
    props.put("bootstrap.servers", "localhost:9092")
    props.put("client.id", "PresidioProducer")

    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("linger.ms", "1")
    props.put("batch.size", "445")
    props.put("compression.codec", "1")
    props.put("request.required.acks", "-1")

    val producer = new KafkaProducer[String, String](props)
    val data = new ProducerRecord[String, String]("MONGO-TOPIC", "8890", "1osql-data-is-coming-in")
    producer.send(data)
    producer.flush()
  }
}
