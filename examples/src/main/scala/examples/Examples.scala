package examples

import com.github.ldaniels528.meansjs.nodejs._
import examples.nodejs.{buffers, events, express, http, kafka, mongodb, net, timers, zookeeper}
import org.scalajs.dom.console

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExportAll

/**
  * MEANS.js Examples
  * @author lawrence.daniels@gmail.com
  */
@JSExportAll
object Examples extends js.JSApp {
  private val names = js.Array(
    "Buffers", "EventEmitting", "ExpressTest", "HttpServerTest", "IntermediateTimers", "MongoClientTest",
    "NetServerTest", "ProducerExample", "ProducerEnhanced", "TransactionExample"
  )

  override def main(): Unit = ()

  def start(require: Require) = {
    process.argv.drop(2) foreach {
      case "Buffers" => new buffers.Buffers(require)
      case "EventEmitting" => new events.EventEmitting(require)
      case "ExpressTest" => new express.ExpressTest(require)
      case "HttpServerTest" => new http.HttpServerTest(require)
      case "IntermediateTimers" => new timers.IntermediateTimers(require)
      case "MongoClientTest" => new mongodb.MongoClientTest(require)
      case "NetServerTest" => new net.NetServerTest(require)
      case "ProducerExample" => new kafka.ProducerExample(require)
      case "ProducerEnhanced" => new kafka.ProducerEnhanced(require)
      case "StateExample" => new zookeeper.StateExample(require)
      case "TransactionExample" => new zookeeper.TransactionExample(require)
      case arg =>
        console.warn(s"Syntax: examples.js <exampleName> - Choose one: ${names.mkString(", ")}")
    }
  }

}
