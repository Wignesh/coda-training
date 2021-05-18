package ga.veee
package sandbox.NorthernVace

import sandbox.Utils.{Topic, Utils}
import sandbox.{DataFrames, SparkSession}

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import org.apache.spark.sql.functions.{col, struct, to_json}

object Producer {
  def main(args: Array[String]): Unit = {
    val TOPIC = "NORTHERN-VACE"

    Topic.createTopic(topic = TOPIC)

    println(Topic.listTopics().mkString("Array(", ", ", ")"))


    val records = DataFrames
      .getDataFrame("/Users/vignesh/Downloads/auth.csv", "AUTH", SparkSession.getSession)
      .withColumn("json", to_json(struct(col("*"))))
      .select("auth_code", "json")
      .limit(50)

    for (record <- records) {
      sendRecord(Utils.getProducer(), TOPIC, record.getString(0), record.getString(1))
    }

  }


  def sendRecord(producer: KafkaProducer[String, String], topic: String, key: String, value: String): Unit = {
    println(s"Sending record ${key}")
    val record = new ProducerRecord[String, String](topic, key, value)
    producer.send(record)
    producer.flush()
  }
}
