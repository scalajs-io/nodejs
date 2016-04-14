package examples

import com.github.ldaniels528.meansjs.nodejs._
import examples.nodejs.events.EventEmitting
import examples.nodejs.express.ExpressTest
import examples.nodejs.http.HttpServerTest
import examples.nodejs.mongodb.MongoClientTest
import examples.nodejs.net.NetServerTest
import examples.nodejs.timers.IntermediateTimers
import org.scalajs.dom.console

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExportAll

/**
  * MEANS.js Examples
  * @author lawrence.daniels@gmail.com
  */
@JSExportAll
object Examples extends js.JSApp {

  override def main(): Unit = ()

  def start(require: Require) = {
    process.argv.drop(2) foreach {
      case "events" => new EventEmitting(require)
      case "express" => new ExpressTest(require)
      case "http" => new HttpServerTest(require)
      case "mongodb" => new MongoClientTest(require)
      case "net" => new NetServerTest(require)
      case "timers" => new IntermediateTimers(require)
      case arg =>
        console.warn(s"No example found for $arg")
        new IntermediateTimers(require)
    }
  }

}
