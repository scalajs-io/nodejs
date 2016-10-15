package examples.nodejs.datastores.kafka

import org.scalajs.nodejs.globals.process
import org.scalajs.npm.kafkanode.{ConsumerOptions, FetchRequest, KafkaNode}
import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.nodejs.{Bootstrap, console}
import org.scalajs.sjs.OptionHelper._

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js

/**
  * Kafka Consumer Example
  * @author lawrence.daniels@gmail.com
  */
class KafkaConsumerExample(bootstrap: Bootstrap) {
  implicit val $require = bootstrap.require

  val topic = process.env.get("kafka_topic") getOrElse "testing"
  val zkConnect = (process.env.get("zk_connect") ?? process.env.get("ZK_CONNECT")) getOrElse "localhost:2181"

  val kafka = KafkaNode()
  val client = kafka.Client(zkConnect)

  val producer = kafka.Producer(client)
  producer.createTopicsFuture(topics = js.Array(topic), async = true) foreach { _ =>
      console.log(s"Created topic $topic")
  }

  val consumer = kafka.Consumer(client, js.Array(new FetchRequest(topic = topic, offset = 0)),
    new ConsumerOptions(
      groupId = "kafka-node-group",
      autoCommit = true,
      autoCommitIntervalMs = 5000,
      fetchMaxWaitMs = 100,
      fetchMinBytes = 4,
      fetchMaxBytes = 1024 * 1024,
      fromOffset = 0L,
      encoding = "utf8"
    ))

  consumer.onMessage((message: String) => {
    console.log("message: %j", message)
  })

  consumer.onError((error: js.Any) => {
    console.log("error: %j", error)
  })

}
