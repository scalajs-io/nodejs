package io.scalajs.npm.kafkanode

import io.scalajs.nodejs.console
import io.scalajs.util.ScalaJsHelper._
import org.scalatest.FunSpec

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js

/**
  * Client Test
  * @author lawrence.daniels@gmail.com
  */
class ClientTest extends FunSpec {
  private val topic     = "testing"
  private val zkConnect = "localhost:2181"

  describe("Client") {

    it("should produce and consume data") {
      val client = new Client(zkConnect)

      val producer = new Producer(client)
      producer.createTopicsFuture(topics = js.Array(topic), async = true) foreach { _ =>
        console.log(s"Created topic $topic")
      }

      val consumer = new Consumer(
        client,
        js.Array(new FetchRequest(topic = topic, offset = 0)),
        new ConsumerOptions(
          groupId = "kafka-node-group",
          autoCommit = true,
          autoCommitIntervalMs = 5000,
          fetchMaxWaitMs = 100,
          fetchMinBytes = 4,
          fetchMaxBytes = 1024 * 1024,
          fromOffset = 0L,
          encoding = "utf8"
        )
      )

      consumer.onMessage((message: String) => {
        console.log("message: %j", message)
      })

      consumer.onError((error: js.Any) => {
        console.log("error: %j", error)
      })
    }

  }

}
