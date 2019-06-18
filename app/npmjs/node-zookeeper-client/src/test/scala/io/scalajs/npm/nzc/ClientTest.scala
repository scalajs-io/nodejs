package io.scalajs.npm.nzc

import io.scalajs.JSON
import io.scalajs.nodejs._
import io.scalajs.util.ScalaJsHelper._
import org.scalatest.FunSpec

import scala.concurrent.Future
import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js

/**
  * Client Test
  * @author lawrence.daniels@gmail.com
  */
class ClientTest extends FunSpec {

  describe("Client") {

    it("can cycle recursively through children") {
      process.env.get("ZK_HOST") match {
        case Some(zkHost) =>
          val client = NodeZookeeperClient.createClient(zkHost)
          client.onceConnected(() => {
            info(s"Connected to $zkHost...")
            client.getChildren("/", (error: String, paths: js.Array[String]) => {
              if (isDefined(error))
                alert(s"Failed to execute the getChildren: ${JSON.stringify(error)}, results: ${JSON.stringify(paths)}")
              else info(JSON.stringify(paths))

              val tasks = Future.sequence(paths.toSeq map { path =>
                client.getDataFuture[String](path = s"/$path").map(path -> _)
              })

              tasks foreach { tuples =>
                tuples foreach { case (path, values) =>
                  info(s"$path: ${JSON.stringify(values)}")
                }
              }

              tasks onComplete { _ =>
                client.close()
              }
            })
          })
          client.connect()

        case None =>
          info("No Zookeeper host was specified. Set 'ZK_HOST=localhost:2181'")
      }
    }

  }

}
