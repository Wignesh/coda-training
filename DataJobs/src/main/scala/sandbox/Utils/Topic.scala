package ga.veee
package sandbox.Utils

import org.apache.kafka.clients.admin.{AdminClient, NewTopic}
import org.apache.kafka.clients.consumer.KafkaConsumer

import java.util.Arrays.asList

object Topic {

  private val consumer: KafkaConsumer[String, String] = Utils.getConsumer()

  def listTopics(consumer: KafkaConsumer[String, String] = Topic.consumer): Array[Topic] = {
    val topics = consumer.listTopics()
    topics.keySet().toArray.map(topic =>
      Topic(topic = topic.toString, partition = topics.get(topic).toArray.length, replicas = topics.get(topic).get(0).replicas().length)
    )
  }

  def createTopic(consumer: KafkaConsumer[String, String] = Topic.consumer, topic: String, partitions: Int = 1, replication: Short = 1): Unit = {
    if (!listTopics(consumer).exists(_topic => _topic.topic.equals(topic))) {
      val admin = AdminClient.create(Props.getAdminProps())
      val result = admin.createTopics(asList(new NewTopic(topic, partitions, replication))).values()

      for (entry <- result.keySet().toArray) {
        try {
          println(result.get(entry).isDone)
          println(s"$entry Created")
        } catch {
          case ee: Exception => {
            println(ee.printStackTrace())
          }
        }
      }
    } else {
      println(s"$topic already exist")
    }
  }

}

case class Topic(topic: String, partition: Int = 1, replicas: Int = 1)
