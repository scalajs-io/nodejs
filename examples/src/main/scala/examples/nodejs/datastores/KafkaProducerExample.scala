package examples.nodejs.datastores

import org.scalajs.nodejs.errors.Error
import org.scalajs.nodejs.fs.Fs
import org.scalajs.nodejs.globals.process
import org.scalajs.nodejs.kafkanode.{ConsumerOptions, FetchRequest, KafkaNode, Payload}
import org.scalajs.nodejs.readline.{Readline, ReadlineOptions}
import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.nodejs.{Bootstrap, console}

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js

/**
  * Producer Example
  * @author lawrence.daniels@gmail.com
  */
class KafkaProducerExample(bootstrap: Bootstrap) {

  import bootstrap._

  implicit val $require = bootstrap.require

  val topic = "testing"

  val kafka = KafkaNode()
  val client = kafka.Client("dev111:2181")

  test1()

  def test1(): Unit = {
    console.log("test1:")

    val producer = kafka.Producer(client)
    val payloads = js.Array((1 to 10000) map (n => Payload(
      topic = topic, messages = s"I've sent you $n notices. Final notice.", partition = n % 10
    )): _*)

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

  def test2(): Unit = {
    console.log("test2:")

    val fs = Fs()
    val readline = Readline()

    val producer = kafka.Producer(client)

    // producer "on" ready to send payload to kafka.
    producer.onReady(() => {
      console.log("Received ready:")

      var lineNo = 0
      val file = __dirname + "/examples.js"
      val reader = readline.createInterface(new ReadlineOptions(
        input = fs.createReadStream(file),
        output = process.stdout,
        terminal = false
      ))

      reader.onLine { line =>
        lineNo += 1
        console.log("[%d] %s", lineNo, line)

        val payloads = js.Array(Payload(topic = topic, messages = line))
        producer.sendFuture(payloads) foreach { _ =>
          console.log("messages", payloads)
        }
      }

      reader.onClose(() => {
        reader.onClose { () =>
          console.log("# stream closed.")
        }
      })
    })

    producer.onError((err: Error) => {
      console.log("Received error:")
      console.log(err)
    })
  }

  def test3(): Unit = {
    console.log("test3:")

    val payloads = js.Array((0 to 9) map (n => FetchRequest(topic = topic, partition = n)): _*)
    val consumer = kafka.Consumer(client, payloads, new ConsumerOptions(groupId = "1", autoCommit = true))
    //(0 to 9) foreach (n => consumer.setOffset(topic = topic, partition = n, offset = 0))

    consumer.onMessage((message: js.Any) => {
      console.log(message)
    })
  }

}
