package examples.nodejs.datastores

import com.github.ldaniels528.meansjs.nodejs._
import com.github.ldaniels528.meansjs.nodejs.zookeeper.NodeZookeeperClient
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._
import org.scalajs.dom.console

import scala.concurrent.duration._
import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js
import scala.scalajs.js.JSON

/**
  * Zookeeper: Show Children
  * @author lawrence.daniels@gmail.com
  */
class ZkShowChildren(bootstrap: Bootstrap) {
  import bootstrap._

  // get the Zookeeper host
  val zkHost = process.argv.toList match {
    case args if args.length > 3 => args(3)
    case _ => "localhost:2181"
  }

  val zookeeper = require[NodeZookeeperClient]("node-zookeeper-client")
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
