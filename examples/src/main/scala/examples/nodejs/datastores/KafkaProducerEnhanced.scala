package examples.nodejs.datastores

import org.scalajs.nodejs.kafkanode.Payload
import org.scalajs.nodejs.errors
import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.dom._
import org.scalajs.nodejs.Bootstrap
import org.scalajs.nodejs.errors.Error
import org.scalajs.nodejs.kafkanode.{KafkaNode, Payload}
import org.scalajs.nodejs.util.ScalaJsHelper

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js

/**
  * Producer Scala.js-enhanced Example
  * @author lawrence.daniels@gmail.com
  */
class KafkaProducerEnhanced(bootstrap: Bootstrap) {
  implicit val require = bootstrap.require

  val kafka = KafkaNode()
  val client = kafka.Client("dev528:2181")
  val producer = kafka.Producer(client)

  val payloads = js.Array(Payload(
    topic = "test", messages = "This is the First Message I am sending", partition = 1
  ))

  // producer "on" ready to send payload to kafka.
  producer.onReady(() => {
    console.log("Received ready:")

    producer.sendFuture(payloads) foreach { data =>
      console.log("Received data:")
      console.log(data)
    }
  })

  producer.onError((err: Error) => {
    console.log("Received error:")
    console.log(err)
  })

}