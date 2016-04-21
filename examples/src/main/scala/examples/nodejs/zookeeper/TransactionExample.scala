package examples.nodejs.zookeeper

import com.github.ldaniels528.meansjs.nodejs._
import com.github.ldaniels528.meansjs.nodejs.buffer.Buffer
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._
import com.github.ldaniels528.meansjs.zookeeper.NodeZookeeper.ZookeeperError
import com.github.ldaniels528.meansjs.zookeeper._
import org.scalajs.dom.console

import scala.scalajs.js

/**
  * Transaction Example
  * @author lawrence.daniels@gmail.com
  */
class TransactionExample(require: Require) {

  val zookeeper = require[NodeZookeeper]("node-zookeeper-client")
  val client = zookeeper.createClient("dev528:2181")

  console.log(zookeeper)

  client.onceConnected(() => {
    console.log("Connected...")
    client.transaction().
      create("/txn").
      create("/txn/1", Buffer("transaction")).
      setData("/txn/1", Buffer("test"), -1).
      check("/txn/1").
      remove("/txn/1", -1).
      remove("/txn").
      commit((error: ZookeeperError, results: js.Any) => {
        if (isDefined(error)) console.log("Failed to execute the transaction: %s, results: %j", error, results)
        else console.log("Transaction completed.")
        client.close()
      })
  })

  client.connect()

}
