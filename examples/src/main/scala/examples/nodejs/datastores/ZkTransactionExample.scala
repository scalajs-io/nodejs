package examples.nodejs.datastores

import com.github.ldaniels528.meansjs.nodejs._
import com.github.ldaniels528.meansjs.nodejs.buffer.Buffer
import com.github.ldaniels528.meansjs.nodejs.zookeeper.{Exception, NodeZookeeperClient}
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._
import org.scalajs.dom.console

import scala.scalajs.js

/**
  * Transaction Example
  * @author lawrence.daniels@gmail.com
  */
class ZkTransactionExample(bootstrap: Bootstrap) {
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
