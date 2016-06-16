package org.scalajs.nodejs.kafkanode

import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.nodejs.util.ScalaJsHelper

import scala.scalajs.js

/**
  * Kafka-Node Client Instance
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Client extends js.Object {

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