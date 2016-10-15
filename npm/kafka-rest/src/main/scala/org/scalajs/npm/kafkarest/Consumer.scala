package org.scalajs.npm.kafkarest

import org.scalajs.nodejs.{errors, stream}

import scala.scalajs.js

/**
  * Kafka Consumer
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Consumer extends js.Object {

  def join(properties: js.Dictionary[String], callback: js.Function2[errors.Error, Consumer, Any]): Unit = js.native

  def raw: js.Object = js.native

  /**
    * Request a graceful shutdown of the consumer instance, which also cleans up the stream
    * @param callback the zero-parameter callback function
    */
  def shutdown(callback: js.Function0[Any]): Unit = js.native

  def subscribe(name: String): stream.Readable = js.native


}
