package io.scalajs.npm.kafkanode

import io.scalajs.RawOptions
import io.scalajs.nodejs.events.IEventEmitter
import io.scalajs.npm.zookeeper
import io.scalajs.npm.zookeeper.ClientOptions

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * Kafka-Node Client
  * @param connectionString  Zookeeper connection string, default localhost:2181/
  * @param clientId          This is a user-supplied identifier for the client application, default kafka-node-client
  * @param zkOptions         Zookeeper options, see node-zookeeper-client
  * @param noAckBatchOptions when requireAcks is disabled on Producer side we can define the batch properties
  * @example new Client(connectionString, clientId, [zkOptions], [noAckBatchOptions])
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("kafka-node", "Client")
class Client(connectionString: String,
             clientId: String = js.native,
             zkOptions: ClientOptions | RawOptions = js.native,
             noAckBatchOptions: NoAckBatchOptions | RawOptions = js.native)
    extends IEventEmitter {

  def this() = this(null, null, null, null)

  /**
    * Undocumented property
    */
  def zk: ZookeeperClientWrapper = js.native

  /**
    * Closes the connection to Zookeeper and the brokers so that the node process can exit gracefully.
    * @param callback the callback
    */
  def close(callback: js.Function): Unit = js.native

}

/**
  * Zookeeper Client Wrapper
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ZookeeperClientWrapper extends js.Object {

  def client: zookeeper.Client = js.native

}
