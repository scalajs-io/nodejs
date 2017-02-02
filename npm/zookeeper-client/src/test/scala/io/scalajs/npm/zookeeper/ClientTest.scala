package io.scalajs.npm.zookeeper

import io.scalajs.nodejs._
import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.util.ScalaJsHelper._
import org.scalatest.FunSpec

import scala.concurrent.duration._
import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js
import scala.scalajs.js.JSON
import scala.util.{Failure, Success}

/**
  * Client Test
  * @author lawrence.daniels@gmail.com
  */
class ClientTest extends FunSpec {

  describe("Client") {
    val zkHost = "localhost:2181"

    it("can cycle recursively through children") {
      val client = NodeZookeeperClient.createClient(zkHost)
      client.onceConnected(() => {
        info("Connected...")
        client.getChildren(
          "/",
          (error: String, paths: js.Array[String]) => {
            if (isDefined(error))
              info(s"Failed to execute the getChildren: ${JSON.stringify(error)}, results: ${JSON.stringify(paths)}")
            else info(JSON.stringify(paths))

            setTimeout(
              () =>
                paths foreach { path =>
                  val childPath = s"/$path"
                  client.getDataFuture[js.Object](childPath) foreach { data =>
                    info(s"$path => ${JSON.stringify(data)}")
                  }
              },
              1.second
            )
          }
        )
      })
    }

    it("can create and commit data") {
      val client = NodeZookeeperClient.createClient(zkHost)
      client.onceConnected(() => {
        console.log("Connected...")
        client
          .transaction()
          .create("/txn")
          .create("/txn/1", Buffer.from("transaction"))
          .setData("/txn/1", Buffer.from("test"), -1)
          .check("/txn/1")
          .remove("/txn/1", -1)
          .remove("/txn")
          .commit((error: Exception, results: js.Any) => {
            if (isDefined(error)) console.log("Failed to execute the transaction: %s, results: %j", error, results)
            else console.log("Transaction completed.")
            client.close()
          })
      })

      client.connect()
    }

    it("retrieve state from Zookeeper") {
      val client = NodeZookeeperClient.createClient(zkHost)
      client.onceConnected(() => {
        console.log("once: Connected")
      })

      client.onConnected(() => {
        console.log("on: Connected")
      })

      client.getChildrenFuture("/") onComplete {
        case Success(path) =>
          console.log("path = %j", path)
        case Failure(e) =>
          console.log(e.getMessage)
      }

      console.log("client.getSessionId = %j", client.getSessionId())
      console.log("client.getSessionTimeout = %j", client.getSessionTimeout())
      console.log("client.getSessionPassword = %j", client.getSessionPassword())
      console.log("client.getState = %j", client.getState())
    }

  }

}
