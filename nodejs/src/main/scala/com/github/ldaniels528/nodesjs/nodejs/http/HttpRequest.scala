package com.github.ldaniels528.nodesjs.nodejs.http

import scala.scalajs.js

/**
  * Http Request
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait HttpRequest extends js.Object {

  def body: js.Any

  def end(): Unit

  def end(text: String): Unit

  def on(event: String, callback: js.Function)

  def param(name: String): js.UndefOr[String]

  def params: js.Dynamic

  def query: js.Dynamic

  def setNoDelay(): Unit

  def setNoDelay(noDelay: Int): Unit

  /**
    * @see https://nodejs.org/api/net.html#net_socket_setkeepalive_enable_initialdelay
    * @param enable
    * @param initialDelay
    */
  def setSocketKeepAlive(enable: js.UndefOr[Boolean] = js.undefined, initialDelay: js.UndefOr[Int] = js.undefined)

}

/**
  * Http Request Companion
  * @author lawrence.daniels@gmail.com
  */
object HttpRequest {

  /**
    * Http Request Enrichment
    * @author lawrence.daniels@gmail.com
    */
  implicit class HttpRequestEnrich(val request: HttpRequest) extends AnyVal {

    def bodyAs[T <: js.Any] = request.body.asInstanceOf[T]

  }

}