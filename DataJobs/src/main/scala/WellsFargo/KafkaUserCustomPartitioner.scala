package ga.veee
package WellsFargo

import org.apache.kafka.clients.producer.Partitioner
import org.apache.kafka.common.Cluster

import java.util

class KafkaUserCustomPartitioner extends Partitioner {
  override def partition(topic: String, key: Any, keyBytes: Array[Byte], value: Any, valueBytes: Array[Byte], cluster: Cluster): Int = {
    val _key = key.asInstanceOf[String].toLowerCase.charAt(0)
    _key match {
      case 'c' => 98
      case 'v' => 99
      case 'x' | 'w' => 1
    }
  }

  override def close(): Unit = {

  }

  override def configure(configs: util.Map[String, _]): Unit = {

  }
}