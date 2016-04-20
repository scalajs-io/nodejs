package examples.nodejs.kafka

import com.github.ldaniels528.meansjs.kafkanode.KafkaNode._
import com.github.ldaniels528.meansjs.kafkanode._
import com.github.ldaniels528.meansjs.nodejs.Require
import org.scalajs.dom.console

import scala.scalajs.js

/**
  * Producer Example
  * @author lawrence.daniels@gmail.com
  */
class ProducerExample(require: Require) {

  val kafka = require[KafkaNode]("kafka-node")
  val client = kafka.Client("dev528:2181")
  val producer = kafka.Producer(client)

  val payloads = js.Array(Payload(
    topic = "test", messages = "This is the First Message I am sending", partition = 1
  ))

  // producer "on" ready to send payload to kafka.
  producer.on("ready", () => {
    console.log("Received ready:")

    producer.send(payloads, (err: KafkaError, data: js.Any) => {
      console.log("Received data:")
      console.log(data)
    })
  })

  producer.on("error", (err: KafkaError) => {
    console.log("Received error:")
    console.log(err)
  })

}
