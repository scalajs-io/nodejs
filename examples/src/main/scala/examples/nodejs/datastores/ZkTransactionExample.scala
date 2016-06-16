package examples.nodejs.datastores

import org.scalajs.nodejs._
import org.scalajs.nodejs.global.process
import org.scalajs.nodejs.zookeeper.Exception
import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.dom.console
import org.scalajs.nodejs.Bootstrap
import org.scalajs.nodejs.buffer.Buffer
import org.scalajs.nodejs.util.ScalaJsHelper
import org.scalajs.nodejs.zookeeper.{Exception, NodeZookeeperClient}

import scala.scalajs.js

/**
  * Transaction Example
  * @author lawrence.daniels@gmail.com
  */
class ZkTransactionExample(bootstrap: Bootstrap) {
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
    client.transaction().
      create("/txn").
      create("/txn/1", Buffer("transaction")).
      setData("/txn/1", Buffer("test"), -1).
      check("/txn/1").
      remove("/txn/1", -1).
      remove("/txn").
      commit((error: Exception, results: js.Any) => {
        if (isDefined(error)) console.log("Failed to execute the transaction: %s, results: %j", error, results)
        else console.log("Transaction completed.")
        client.close()
      })
  })

  client.connect()

}
