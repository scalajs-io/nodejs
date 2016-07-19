package examples.nodejs.datastores

import org.scalajs.nodejs._
import org.scalajs.nodejs.globals.process
import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.dom.console
import org.scalajs.nodejs.Bootstrap
import org.scalajs.nodejs.util.ScalaJsHelper
import org.scalajs.nodejs.zookeeper.NodeZookeeperClient

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.util.{Failure, Success}

/**
  * State Example
  * @author lawrence.daniels@gmail.com
  */
class ZkStateExample(bootstrap: Bootstrap) {
  implicit val require = bootstrap.require

  val zookeeper = NodeZookeeperClient()

  // get the Zookeeper host
  val zkHost = process.argv.toList match {
    case args if args.length > 3 => args(3)
    case _ => "localhost:2181"
  }

  console.log("Connecting to %s...", zkHost)
  val client = zookeeper.createClient(zkHost)

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
