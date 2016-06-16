package examples.nodejs.datastores

import org.scalajs.nodejs.kafkanode.Payload
import org.scalajs.nodejs.errors
import org.scalajs.dom.console
import org.scalajs.nodejs.Bootstrap
import org.scalajs.nodejs.errors.Error
import org.scalajs.nodejs.kafkanode.{KafkaNode, Payload}

import scala.scalajs.js

/**
  * Producer Example
  * @author lawrence.daniels@gmail.com
  */
class KafkaProducerExample(bootstrap: Bootstrap) {
  implicit val require = bootstrap.require

  val kafka = KafkaNode()
  val client = kafka.Client("dev528:2181")
  val producer = kafka.Producer(client)

  val payloads = js.Array(Payload(
    topic = "test", messages = "This is the First Message I am sending", partition = 1
  ))

  // producer "on" ready to send payload to kafka.
  producer.on("ready", () => {
    console.log("Received ready:")

    producer.send(payloads, (err: Error, data: js.Any) => {
      console.log("Received data:")
      console.log(data)
    })
  })

  producer.on("error", (err: Error) => {
    console.log("Received error:")
    console.log(err)
  })

}
