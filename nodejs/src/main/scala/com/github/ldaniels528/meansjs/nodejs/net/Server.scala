package com.github.ldaniels528.meansjs.nodejs.net

import scala.scalajs.js

/**
  * Scala.js Binding for Node.js Server
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Server extends js.Object {

  def address(): Server.Address

  def listen(port: Int): Unit

  def listen(port: Int, hostname: String): Unit

  def listen(port: Int, hostname: String, backlog: Int): Unit

  def listen(port: Int, hostname: String, backlog: Int, callback: js.Function): Unit

  def listening: Boolean

  def maxHeadersCount: Int

  def setTimeout(msecs: Int, callback: js.Function): Unit

}

/**
  * Server Companion
  * @author lawrence.daniels@gmail.com
  */
object Server {

  @js.native
  trait Address extends js.Object {
    var address: js.UndefOr[String]
    var port: js.UndefOr[Int]

  }

}