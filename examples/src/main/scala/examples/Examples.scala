package examples

import examples.nodejs.actors.ActorsExample
import examples.nodejs.codecs._
import examples.nodejs.concurrency._
import examples.nodejs.csv.CsvParseExample
import examples.nodejs.datastores._
import examples.nodejs.express._
import examples.nodejs.general._
import examples.nodejs.http._
import examples.nodejs.io._
import examples.nodejs.net._
import examples.nodejs.rxjs.ObservableExamples
import examples.nodejs.terminal._
import examples.nodejs.vm._
import org.scalajs.dom.console
import org.scalajs.nodejs.Bootstrap
import org.scalajs.nodejs.globals.process

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExportAll
import scala.util.{Failure, Success, Try}

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
    "CsvParseExample" -> ((bootstrap: Bootstrap) => new CsvParseExample(bootstrap)),
    "DNSExample" -> ((bootstrap: Bootstrap) => new DNSExample(bootstrap)),
    "EscapeHtmlExample" -> ((bootstrap: Bootstrap) => new EscapeHtmlExample(bootstrap)),
    "EventEmitterExample" -> ((bootstrap: Bootstrap) => new EventEmitterExample(bootstrap)),
    "ExpressCSVExample" -> ((bootstrap: Bootstrap) => new ExpressCSVExample(bootstrap)),
    "ExpressRoutingExample" -> ((bootstrap: Bootstrap) => new ExpressRoutingExample(bootstrap)),
    "ExpressServerExample" -> ((bootstrap: Bootstrap) => new ExpressServerExample(bootstrap)),
    "FilesExample" -> ((bootstrap: Bootstrap) => new FilesExample(bootstrap)),
    "HttpServerExample" -> ((bootstrap: Bootstrap) => new HttpServerExample(bootstrap)),
    "HttpServerWithCompression" -> ((bootstrap: Bootstrap) => new HttpServerWithCompression(bootstrap)),
    "JwtSimpleExample" -> ((bootstrap: Bootstrap) => new JwtSimpleExample(bootstrap)),
    "KafkaProducerExample" -> ((bootstrap: Bootstrap) => new KafkaProducerExample(bootstrap)),
    "KafkaProducerEnhanced" -> ((bootstrap: Bootstrap) => new KafkaProducerEnhanced(bootstrap)),
    "MD5Example" -> ((bootstrap: Bootstrap) => new MD5Example(bootstrap)),
    "MemoryFsExample" -> ((bootstrap: Bootstrap) => new MemoryFsExample(bootstrap)),
    "MongoAggregateExample" -> ((bootstrap: Bootstrap) => new MongoAggregateExample(bootstrap)),
    "MongoClientExample" -> ((bootstrap: Bootstrap) => new MongoClientExample(bootstrap)),
    "MongoCollectionExample" -> ((bootstrap: Bootstrap) => new MongoCollectionExample(bootstrap)),
    "MongoGridExample" -> ((bootstrap: Bootstrap) => new MongoGridExample(bootstrap)),
    "MongoGridFSBucketExample" -> ((bootstrap: Bootstrap) => new MongoGridFSBucketExample(bootstrap)),
    "MongoGridStoreExample" -> ((bootstrap: Bootstrap) => new MongoGridStoreExample(bootstrap)),
    "MongoReadPreferenceExample" -> ((bootstrap: Bootstrap) => new MongoReadPreferenceExample(bootstrap)),
    "MongoStreamExample" -> ((bootstrap: Bootstrap) => new MongoStreamExample(bootstrap)),
    "MySQLExample" -> ((bootstrap: Bootstrap) => new MySQLExample(bootstrap)),
    "NetClientServerExample" -> ((bootstrap: Bootstrap) => new NetClientServerExample(bootstrap)),
    "ObservableExamples" -> ((bootstrap: Bootstrap) => new ObservableExamples(bootstrap)),
    "PathExamples" -> ((bootstrap: Bootstrap) => new PathExamples(bootstrap)),
    "ProcessExample" -> ((bootstrap: Bootstrap) => new ProcessExample(bootstrap)),
    "REPLExample" -> ((bootstrap: Bootstrap) => new REPLExample(bootstrap)),
    "StringDecoderExample" -> ((bootstrap: Bootstrap) => new StringDecoderExample(bootstrap)),
    "TimersExample" -> ((bootstrap: Bootstrap) => new TimersExample(bootstrap)),
    "TinyCLI" -> ((bootstrap: Bootstrap) => new TinyCLIExample(bootstrap)),
    "TTYExample" -> ((bootstrap: Bootstrap) => new TTYExample(bootstrap)),
    "URLsExample" -> ((bootstrap: Bootstrap) => new URLsExample(bootstrap)),
    "VMExample" -> ((bootstrap: Bootstrap) => new VMExample(bootstrap)),
    "WatchExample" -> ((bootstrap: Bootstrap) => new WatchExample(bootstrap)),
    "XMLParsingExample" -> ((bootstrap: Bootstrap) => new XMLParsingExample(bootstrap)),
    "ZkShowChildren" -> ((bootstrap: Bootstrap) => new ZkShowChildren(bootstrap)),
    "ZkStateExample" -> ((bootstrap: Bootstrap) => new ZkStateExample(bootstrap)),
    "ZkTransactionExample" -> ((bootstrap: Bootstrap) => new ZkTransactionExample(bootstrap)),
    "ZlibExample" -> ((bootstrap: Bootstrap) => new ZlibExample(bootstrap))
  )

  override def main(): Unit = {
    console.warn("Please use start(Bootstrap)")
  }

  /**
    * Runs an example by name
    * @param bootstrap the given [[Bootstrap bootstrap]]
    */
  def start(bootstrap: Bootstrap) {
    val args = process.argv.drop(2)
    args.headOption match {
      case Some("--all") => runAll(bootstrap)
      case Some(name) => runOne(bootstrap, name, args.tail)
      case None => usageError()
    }
  }

  /**
    * Runs a single (specific) example
    * @param bootstrap the given [[Bootstrap bootstrap]]
    * @param args      the example arguments. The first argument is the example name.
    */
  private def runOne(bootstrap: Bootstrap, name: String, args: js.Array[String]): Unit = {
    console.log(s"Searching for example '$name'")
    examples.get(name) match {
      case Some(example) =>
        console.log(s"Executing example '$name'")
        example(bootstrap)
      case None => usageError()
    }
  }

  /**
    * Runs all examples
    * @param bootstrap the given [[Bootstrap bootstrap]]
    */
  private def runAll(bootstrap: Bootstrap): Unit = {
    val columns = process.env.get("COLUMNS").map(_.toInt) getOrElse 80
    var passed = 0
    var failed: List[String] = Nil

    examples foreach { case (name, example) =>
      console.log(s"Starting $name...")
      Try(example(bootstrap)) match {
        case Success(_) => passed += 1
        case Failure(e) => failed = name :: failed
      }
      console.log("\n" + "*" * columns)
    }

    // display the results
    console.log("example(s) executed: %d", examples.size)
    console.log("example(s) passed:   %d", passed)
    console.log("example(s) failed:   %d", failed.size)

    if (failed.nonEmpty) {
      console.log("\nFailed examples: %s", failed.mkString(", "))
    }
  }

  /**
    * Displays the usages error
    */
  def usageError(): Unit = {
    console.warn("Usage1: examples.js --all")
    console.warn("Usage2: examples.js <example-name>")
    console.log("\nChoose any of the following:")
    console.log(examples.keys.sliding(4, 4) map (_.mkString(", ")) mkString "\n")
  }

}
