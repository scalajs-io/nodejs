package io.scalajs.npm.kafkanode

import io.scalajs.nodejs.{console, process}
import org.scalatest.funspec.AnyFunSpec

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js

/**
  * Client Test
  * @author lawrence.daniels@gmail.com
  */
class ClientTest extends AnyFunSpec {
  private val topic = "testing"

  describe("Client") {

    it("should produce and consume data") {
      process.env.get("ZK_HOST") match {
        case None =>
          info("No Zookeeper host was specified. Set 'ZK_HOST=localhost:2181'")

        case Some(zkConnect) =>
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

          consumer.onError { error =>
            console.log("error: %j", error)
          }
      }
    }

  }

}
