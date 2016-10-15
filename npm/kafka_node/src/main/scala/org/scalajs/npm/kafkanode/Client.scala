package org.scalajs.npm.kafkanode

import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.npm.kafkanode.Client.ZookeeperClientWrapper

import scala.scalajs.js

/**
  * Kafka-Node Client Instance
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Client extends js.Object {

  def zk: ZookeeperClientWrapper = js.native

  /**
    * Closes the consumer
    * @param callback the callback
    */
  def close(callback: js.Function): Unit = js.native

}

/**
  * Client Instance Companion
  * @author lawrence.daniels@gmail.com
  */
object Client {

  /**
    * Zookeeper Client Wrapper
    * @author lawrence.daniels@gmail.com
    */
  @js.native
  trait ZookeeperClientWrapper extends js.Object {

    def client: org.scalajs.nodejs.zookeeper.Client = js.native

  }

  /**
    * Client Extensions
    * @param client the given [[Client client]]
    */
  implicit class ClientExtensions(val client: Client) extends AnyVal {

    /**
      * @see [[Client.close()]]
      */
    def closeAsync() = futureCallbackE1[js.Error, js.Any](client.close)

  }

}