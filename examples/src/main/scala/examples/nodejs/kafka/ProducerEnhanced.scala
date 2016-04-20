package examples.nodejs.kafka

import com.github.ldaniels528.meansjs.kafkanode.KafkaNode._
import com.github.ldaniels528.meansjs.kafkanode.{KafkaNode, Payload}
import com.github.ldaniels528.meansjs.nodejs.Require
import org.scalajs.dom._

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js

/**
  * Producer Scala.js-enhanced Example
  * @author lawrence.daniels@gmail.com
  */
class ProducerEnhanced(require: Require) {

  val kafka = require[KafkaNode]("kafka-node")
  val client = kafka.Client("dev528:2181")
  val producer = kafka.Producer(client)

  val payloads = js.Array(Payload(
    topic = "test", messages = "This is the First Message I am sending", partition = 1
  ))

  // producer "on" ready to send payload to kafka.
  producer.onReady(() => {
    console.log("Received ready:")

    producer.sendAsync(payloads) foreach { data =>
      console.log("Received data:")
      console.log(data)
    }
  })

  producer.onError((err: KafkaError) => {
    console.log("Received error:")
    console.log(err)
  })

}