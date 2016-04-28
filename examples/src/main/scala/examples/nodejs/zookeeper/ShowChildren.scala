package examples.nodejs.zookeeper

import com.github.ldaniels528.meansjs.nodejs.{Require, _}
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._
import com.github.ldaniels528.meansjs.zookeeper._
import org.scalajs.dom.console

import scala.concurrent.duration._
import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js
import scala.scalajs.js.JSON

/**
  * Zookeeper: Show Children
  * @author lawrence.daniels@gmail.com
  */
class ShowChildren(require: Require) {

  val zookeeper = require[NodeZookeeper]("node-zookeeper-client")
  val client = zookeeper.createClient("dev528:2181")

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
          client.getDataAsync[js.Object](childPath) foreach { data =>
            console.log(s"$path => ${JSON.stringify(data)}")
          }
        }, 1.second)
    })

  })
}
