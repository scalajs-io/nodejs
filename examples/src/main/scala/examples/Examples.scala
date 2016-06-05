package examples

import com.github.ldaniels528.meansjs.nodejs._
import examples.nodejs.actors.ActorsExample
import examples.nodejs.codecs._
import examples.nodejs.concurrency._
import examples.nodejs.datastores._
import examples.nodejs.express._
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
    "ActorsExample" -> ((bootstrap: Bootstrap) => new ActorsExample(bootstrap)),
    "AsyncForEachOfExample" -> ((bootstrap: Bootstrap) => new AsyncForEachOfExample(bootstrap)),
    "AsyncWaterfallExample" -> ((bootstrap: Bootstrap) => new AsyncWaterfallExample(bootstrap)),
    "BuffersExample" -> ((bootstrap: Bootstrap) => new BuffersExample(bootstrap)),
    "CassandraExample" -> ((bootstrap: Bootstrap) => new CassandraExample(bootstrap)),
    "ClassesExample" -> ((bootstrap: Bootstrap) => new ClassesExample(bootstrap)),
    "ClientRequestExample" -> ((bootstrap: Bootstrap) => new ClientRequestExample(bootstrap)),
    "ClusterExample" -> ((bootstrap: Bootstrap) => new ClusterExample(bootstrap)),
    "ColorsExample" -> ((bootstrap: Bootstrap) => new ColorsExample(bootstrap)),
    "CompressionExample" -> ((bootstrap: Bootstrap) => new CompressionExample(bootstrap)),
    "EscapeHtmlExample" -> ((bootstrap: Bootstrap) => new EscapeHtmlExample(bootstrap)),
    "EventEmitterExample" -> ((bootstrap: Bootstrap) => new EventEmitterExample(bootstrap)),
    "ExpressRoutingExample" -> ((bootstrap: Bootstrap) => new ExpressRoutingExample(bootstrap)),
    "ExpressServerExample" -> ((bootstrap: Bootstrap) => new ExpressServerExample(bootstrap)),
    "FilesExample" -> ((bootstrap: Bootstrap) => new FilesExample(bootstrap)),
    "HttpServerExample" -> ((bootstrap: Bootstrap) => new HttpServerExample(bootstrap)),
    "JwtSimpleExample" -> ((bootstrap: Bootstrap) => new JwtSimpleExample(bootstrap)),
    "KafkaProducerExample" -> ((bootstrap: Bootstrap) => new KafkaProducerExample(bootstrap)),
    "KafkaProducerEnhanced" -> ((bootstrap: Bootstrap) => new KafkaProducerEnhanced(bootstrap)),
    "MD5Example" -> ((bootstrap: Bootstrap) => new MD5Example(bootstrap)),
    "MongoAggregateExample" -> ((bootstrap: Bootstrap) => new MongoAggregateExample(bootstrap)),
    "MongoClientExample" -> ((bootstrap: Bootstrap) => new MongoClientExample(bootstrap)),
    "MongoGridExample" -> ((bootstrap: Bootstrap) => new MongoGridExample(bootstrap)),
    "MongoGridFSBucketExample" -> ((bootstrap: Bootstrap) => new MongoGridFSBucketExample(bootstrap)),
    "MongoGridStoreExample" -> ((bootstrap: Bootstrap) => new MongoGridStoreExample(bootstrap)),
    "MongoStreamExample" -> ((bootstrap: Bootstrap) => new MongoStreamExample(bootstrap)),
    "MySQLExample" -> ((bootstrap: Bootstrap) => new MySQLExample(bootstrap)),
    "NetClientServerExample" -> ((bootstrap: Bootstrap) => new NetClientServerExample(bootstrap)),
    "PathExamples" -> ((bootstrap: Bootstrap) => new PathExamples(bootstrap)),
    "ProcessExample" -> ((bootstrap: Bootstrap) => new ProcessExample(bootstrap)),
    "REPLExample" -> ((bootstrap: Bootstrap) => new REPLExample(bootstrap)),
    "ServerWithCompression" -> ((bootstrap: Bootstrap) => new ServerWithCompression(bootstrap)),
    "StringDecoderExample" -> ((bootstrap: Bootstrap) => new StringDecoderExample(bootstrap)),
    "TimersExample" -> ((bootstrap: Bootstrap) => new TimersExample(bootstrap)),
    "TinyCLI" -> ((bootstrap: Bootstrap) => new TinyCLI(bootstrap)),
    "URLsExample" -> ((bootstrap: Bootstrap) => new URLsExample(bootstrap)),
    "WatchExample" -> ((bootstrap: Bootstrap) => new WatchExample(bootstrap)),
    "XMLParsingExample" -> ((bootstrap: Bootstrap) => new XMLParsingExample(bootstrap)),
    "ZkShowChildren" -> ((bootstrap: Bootstrap) => new ZkShowChildren(bootstrap)),
    "ZkStateExample" -> ((bootstrap: Bootstrap) => new ZkStateExample(bootstrap)),
    "ZkTransactionExample" -> ((bootstrap: Bootstrap) => new ZkTransactionExample(bootstrap)),
    "ZlibExample" -> ((bootstrap: Bootstrap) => new ZlibExample(bootstrap))
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
    console.warn("Usage: examples.js <example1>[, <example2>[, <exampleN>]]\n")
    console.log("Choose any of the following:")
    console.log(examples.keys.sliding(4, 4) map (_.mkString(", ")) mkString "\n")
  }

}
