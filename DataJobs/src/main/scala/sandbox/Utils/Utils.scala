package ga.veee
package sandbox.Utils

import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.log4j.Level

import java.util.Properties

object Utils {


  private val producerProps: Properties = Props.getProducerProps()
  private val consumerProps: Properties = Props.getConsumerProps()

  private val consumer = new KafkaConsumer[String, String](consumerProps)
  private val producer = new KafkaProducer[String, String](producerProps)

  def getConsumer(consumerProps: Properties = null): KafkaConsumer[String, String] = {
    if (consumerProps != null) {
      return new KafkaConsumer[String, String](consumerProps)
    }
    Utils.consumer
  }

  def getProducer(producerProps: Properties = null): KafkaProducer[String, String] = {
    if (producerProps != null) {
      return new KafkaProducer[String, String](producerProps)
    }
    Utils.producer
  }
}
