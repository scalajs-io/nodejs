package io.scalajs.npm.kafkanode

import io.scalajs.nodejs.fs.Fs
import io.scalajs.nodejs.readline.{Readline, ReadlineOptions}
import io.scalajs.nodejs.{Error, console, process}
import io.scalajs.util.ScalaJsHelper._
import org.scalatest.FunSpec

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js

/**
  * Producer Test
  * @author lawrence.daniels@gmail.com
  */
class ProducerTest extends FunSpec {
  private val topic     = "testing"
  private val zkConnect = "localhost:2181"

  describe("Producer") {

    it("should produce data #1") {
      val client   = new Client(zkConnect)
      val producer = new Producer(client)
      val payloads = js.Array(
        (1 to 10000) map (n =>
                            new Payload(
                              topic = topic,
                              messages = s"I've sent you $n notices. Final notice.",
                              partition = n % 10
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

    it("should produce data #2") {
      val client   = new Client(zkConnect)
      val producer = new Producer(client)

      // producer "on" ready to send payload to kafka.
      producer.onReady(() => {
        console.log("Received ready:")

        var lineNo = 0
        val file   = process.cwd() + "/examples.js"
        val reader = Readline.createInterface(
          new ReadlineOptions(
            input = Fs.createReadStream(file),
            output = process.stdout,
            terminal = false
          ))

        reader.onLine { line =>
          lineNo += 1
          console.log("[%d] %s", lineNo, line)

          val payloads = js.Array(new Payload(topic = topic, messages = line))
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

    it("should produce data #3") {
      val client   = new Client(zkConnect)
      val payloads = js.Array((0 to 9) map (n => new FetchRequest(topic = topic, partition = n)): _*)
      val consumer = new Consumer(client, payloads, new ConsumerOptions(groupId = "1", autoCommit = true))
      //(0 to 9) foreach (n => consumer.setOffset(topic = topic, partition = n, offset = 0))

      consumer.onMessage((message: js.Any) => {
        console.log(message)
      })
    }

    it("supports a Scala-ified producer") {
      val client   = new Client(zkConnect)
      val producer = new Producer(client)

      val payloads = js.Array(
        new Payload(
          topic = "test",
          messages = "This is the First Message I am sending",
          partition = 1
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

  }

}
