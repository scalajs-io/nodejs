package examples

import com.github.ldaniels528.meansjs.nodejs._
import examples.nodejs.concurrency._
import examples.nodejs.datastores._
import examples.nodejs.general._
import examples.nodejs.io._
import examples.nodejs.net._
import org.scalajs.dom.console

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExportAll

/**
  * MEANS.js Examples
  * @author lawrence.daniels@gmail.com
  */
@JSExportAll
object Examples extends js.JSApp {
  private val examples = Map(
    "AsyncForEachOfExample" -> ((bootstrap: Bootstrap) => new AsyncForEachOfExample(bootstrap)),
    "AsyncWaterfallExample" -> ((bootstrap: Bootstrap) => new AsyncWaterfallExample(bootstrap)),
    "Buffers" -> ((bootstrap: Bootstrap) => new Buffers(bootstrap)),
    "Classes" -> ((bootstrap: Bootstrap) => new Classes(bootstrap)),
    "ClientRequestExample" -> ((bootstrap: Bootstrap) => new ClientRequestExample(bootstrap)),
    "Compression" -> ((bootstrap: Bootstrap) => new Compression(bootstrap)),
    "EventEmitterExample" -> ((bootstrap: Bootstrap) => new EventEmitterExample(bootstrap)),
    "ExpressRoutingExample" -> ((bootstrap: Bootstrap) => new ExpressRoutingExample(bootstrap)),
    "ExpressServerExample" -> ((bootstrap: Bootstrap) => new ExpressServerExample(bootstrap)),
    "Files" -> ((bootstrap: Bootstrap) => new Files(bootstrap)),
    "HttpServerExample" -> ((bootstrap: Bootstrap) => new HttpServerExample(bootstrap)),
    "IntermediateTimers" -> ((bootstrap: Bootstrap) => new IntermediateTimers(bootstrap)),
    "JwtSimpleExample" -> ((bootstrap: Bootstrap) => new JwtSimpleExample(bootstrap)),
    "MongoAggregateExample" -> ((bootstrap: Bootstrap) => new MongoAggregateExample(bootstrap)),
    "MongoClientExample" -> ((bootstrap: Bootstrap) => new MongoClientExample(bootstrap)),
    "MongoGridExample" -> ((bootstrap: Bootstrap) => new MongoGridExample(bootstrap)),
    "MongoGridFSBucketExample" -> ((bootstrap: Bootstrap) => new MongoGridFSBucketExample(bootstrap)),
    "MongoGridStoreExample" -> ((bootstrap: Bootstrap) => new MongoGridStoreExample(bootstrap)),
    "MongoStreamExample" -> ((bootstrap: Bootstrap) => new MongoStreamExample(bootstrap)),
    "NetServerExample" -> ((bootstrap: Bootstrap) => new NetServerExample(bootstrap)),
    "ProcessInfo" -> ((bootstrap: Bootstrap) => new ProcessInfo(bootstrap)),
    "ProducerExample" -> ((bootstrap: Bootstrap) => new KafkaProducerExample(bootstrap)),
    "ProducerEnhanced" -> ((bootstrap: Bootstrap) => new KafkaProducerEnhanced(bootstrap)),
    "REPLExample" -> ((bootstrap: Bootstrap) => new REPLExample(bootstrap)),
    "ServerWithCompression" -> ((bootstrap: Bootstrap) => new ServerWithCompression(bootstrap)),
    "StringDecoderExample" -> ((bootstrap: Bootstrap) => new StringDecoderExample(bootstrap)),
    "TinyCLI" -> ((bootstrap: Bootstrap) => new TinyCLI(bootstrap)),
    "URLs" -> ((bootstrap: Bootstrap) => new URLs(bootstrap)),
    "XMLParsingExample" -> ((bootstrap: Bootstrap) => new XMLParsingExample(bootstrap)),
    "ZkShowChildren" -> ((bootstrap: Bootstrap) => new ZkShowChildren(bootstrap)),
    "ZkStateExample" -> ((bootstrap: Bootstrap) => new ZkStateExample(bootstrap)),
    "ZkTransactionExample" -> ((bootstrap: Bootstrap) => new ZkTransactionExample(bootstrap))
  )

  override def main(): Unit = ()

  def start(bootstrap: Bootstrap) {
    val args = process.argv.drop(2)
    if (args.isEmpty) usageError()
    else {
      val outcome = for {
        arg <- args.headOption
        _ = console.log(s"Searching for example '$arg'")
        example <- examples.get(arg)
      } yield (arg, example)

      outcome match {
        case Some((arg, example)) =>
          console.log(s"Executing example '$arg'")
          example(bootstrap)
        case _ => usageError()
      }
    }
  }

  def usageError(): Unit = {
    val choices = examples.keys.sliding(4, 4) map (_.mkString(", ")) mkString "\n"
    console.warn("Usage: examples.js <example1>[, <example2>[, <exampleN>]]\n")
    console.log("Choose any of the following:")
    console.log(choices)
  }

}
