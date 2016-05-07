package examples.nodejs.datastores

import com.github.ldaniels528.meansjs.nodejs.Bootstrap
import com.github.ldaniels528.meansjs.nodejs.kafkanode.KafkaNode.KafkaError
import com.github.ldaniels528.meansjs.nodejs.kafkanode.{KafkaNode, Payload}
import org.scalajs.dom.console

import scala.scalajs.js

/**
  * Producer Example
  * @author lawrence.daniels@gmail.com
  */
class KafkaProducerExample(bootstrap: Bootstrap) {
  import bootstrap._

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
