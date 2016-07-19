package examples.nodejs.datastores

import org.scalajs.nodejs._
import org.scalajs.nodejs.globals.process
import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.dom.console
import org.scalajs.nodejs.Bootstrap
import org.scalajs.nodejs.util.ScalaJsHelper
import org.scalajs.nodejs.zookeeper.NodeZookeeperClient

import scala.concurrent.duration._
import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js
import scala.scalajs.js.JSON

/**
  * Zookeeper: Show Children
  * @author lawrence.daniels@gmail.com
  */
class ZkShowChildren(bootstrap: Bootstrap) {
  implicit val require = bootstrap.require

  // get the Zookeeper host
  val zkHost = process.argv.toList match {
    case args if args.length > 3 => args(3)
    case _ => "localhost:2181"
  }

  val zookeeper = NodeZookeeperClient()
  val client = zookeeper.createClient(zkHost)

  client.onceConnected(() => {
    console.log("Connected...")
    client.getChildren("/", (error: String, paths: js.Array[String]) => {
      if (isDefined(error)) {
        console.log(JSON.stringify(error))
        console.log("Failed to execute the getChildren: %s, results: %j", error, paths)
      }
      else console.log(JSON.stringify(paths))

      setTimeout(() =>
        paths foreach { path =>
          val childPath = s"/$path"
          client.getDataFuture[js.Object](childPath) foreach { data =>
            console.log(s"$path => ${JSON.stringify(data)}")
          }
        }, 1.second)
    })

  })
}
