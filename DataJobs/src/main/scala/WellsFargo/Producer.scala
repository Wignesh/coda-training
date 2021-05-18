package ga.veee
package WellsFargo

import sandbox.Utils.{Props, Topic, Utils}

import org.apache.kafka.clients.producer.{Callback, ProducerConfig, ProducerRecord, RecordMetadata}

object Producer {
  def main(args: Array[String]): Unit = {

    val TOPIC = "QURE-DATA-LINEAGE"
    Topic.createTopic(topic = TOPIC, partitions = 100)

    val callback = new Callback {
      override def onCompletion(recordMetadata: RecordMetadata, e: Exception): Unit = {
        println("LEO - " + recordMetadata.offset())
        println(recordMetadata.topic())
        println(recordMetadata.partition())
      }
    }
    val producerProps = Props.getProducerProps()
    producerProps.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, "ga.veee.WellsFargo.KafkaUserCustomPartitioner")

    val producer = Utils.getProducer(producerProps = producerProps)
    val data = new ProducerRecord[String, String](TOPIC, "coda-cold", "coda-hot")
    producer.send(data, callback)
    producer.flush()

  }
}
