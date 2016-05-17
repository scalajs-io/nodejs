package examples.nodejs.datastores

import com.github.ldaniels528.meansjs.nodejs.kafkanode.{KafkaNode, Payload}
import com.github.ldaniels528.meansjs.nodejs.{Bootstrap, errors}
import org.scalajs.dom._

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js

/**
  * Producer Scala.js-enhanced Example
  * @author lawrence.daniels@gmail.com
  */
class KafkaProducerEnhanced(bootstrap: Bootstrap) {
  import bootstrap._

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

  producer.onError((err: errors.Error) => {
    console.log("Received error:")
    console.log(err)
  })

}