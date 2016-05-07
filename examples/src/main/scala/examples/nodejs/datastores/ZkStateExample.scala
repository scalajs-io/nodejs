package examples.nodejs.datastores

import com.github.ldaniels528.meansjs.nodejs._
import com.github.ldaniels528.meansjs.nodejs.zookeeper.NodeZookeeperClient
import org.scalajs.dom.console

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.util.{Failure, Success}

/**
  * State Example
  * @author lawrence.daniels@gmail.com
  */
class ZkStateExample(bootstrap: Bootstrap) {
  import bootstrap._

  val zookeeper = require[NodeZookeeperClient]("node-zookeeper-client")

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

  client.getChildrenAsync("/") onComplete {
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
