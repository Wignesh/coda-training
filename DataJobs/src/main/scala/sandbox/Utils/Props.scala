package ga.veee
package sandbox.Utils

import org.apache.kafka.clients.admin.AdminClientConfig
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.producer.ProducerConfig

import java.util.Properties
import scala.collection.JavaConverters.mapAsJavaMapConverter


object Props {

  private val producerProps: Properties = new Properties()
  producerProps.putAll(
    Map(
      ProducerConfig.BOOTSTRAP_SERVERS_CONFIG -> "localhost:9092",
      ProducerConfig.CLIENT_ID_CONFIG -> "ProducerPresidio",
      ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG -> "org.apache.kafka.common.serialization.StringSerializer",
      ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG -> "org.apache.kafka.common.serialization.StringSerializer",
      ProducerConfig.LINGER_MS_CONFIG -> "1",
      ProducerConfig.BATCH_SIZE_CONFIG -> "445",
//      ProducerConfig.TRANSACTIONAL_ID_CONFIG -> "ProducerPresidio",
      "compression.codec" -> "1",
      "request.required.acks" -> "-1"
    ).asJava
  )

  private val consumerProps: Properties = new Properties()
  consumerProps.putAll(
    Map(
      ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG -> "localhost:9092",
      ConsumerConfig.GROUP_ID_CONFIG -> "GroupPresidio",
      ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG -> "1000",
      ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG -> "30000",
      ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG -> "org.apache.kafka.common.serialization.StringDeserializer",
      ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG -> "org.apache.kafka.common.serialization.StringDeserializer",
      ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG -> "true",
      ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG -> "1000",
    ).asJava
  )

  private val adminProps: Properties = new Properties()
  adminProps.putAll(
    Map(
      AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG -> "localhost:9092",
      ConsumerConfig.GROUP_ID_CONFIG -> "GroupPresidio"
    ).asJava
  )


  def getProducerProps(server: String = "localhost:9092", producerName: String = "ProducerPresidio"): Properties = {
    producerProps.replace(ProducerConfig.CLIENT_ID_CONFIG, producerName)
    producerProps.replace(ProducerConfig.TRANSACTIONAL_ID_CONFIG, producerName)
    producerProps.replace(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, server)
    producerProps
  }

  def getConsumerProps(server: String = "localhost:9092", groupId: String = "GroupPresidio"): Properties = {
    consumerProps.replace(ConsumerConfig.GROUP_ID_CONFIG, groupId)
    producerProps.replace(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, server)
    consumerProps
  }

  def getAdminProps(server: String = "localhost:9092", groupId: String = "GroupPresidio"): Properties = {
    adminProps.replace(ConsumerConfig.GROUP_ID_CONFIG, groupId)
    producerProps.replace(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, server)
    adminProps
  }
}
