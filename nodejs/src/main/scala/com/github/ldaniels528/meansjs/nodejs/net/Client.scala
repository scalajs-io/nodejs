package com.github.ldaniels528.meansjs.nodejs.net

import com.github.ldaniels528.meansjs.nodejs.events.EventEmitter

import scala.scalajs.js

/**
  * Net Client
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Client extends EventEmitter {

  def end(): Unit = js.native

  def end(text: String): Unit = js.native

  def write(text: String): Unit = js.native

}

/**
  * Client Companion
  * @author lawrence.daniels@gmail.com
  */
object Client {

  /**
    * Client Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class ClientExtensions(val client: Client) extends AnyVal {

    /**
      * @see [[Client.on()]]
      */
    def onData(callback: js.Function) = client.on("data", callback)

    /**
      * @see [[Client.on()]]
      */
    def onEnd(callback: js.Function) = client.on("end", callback)

    /**
      * @see [[Client.on()]]
      */
    def onError(callback: js.Function) = client.on("error", callback)

  }

}