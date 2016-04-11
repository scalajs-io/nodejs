package com.github.ldaniels528.meansjs.nodejs.http

import scala.scalajs.js

/**
  * Scala.js Binding for Node.js Http Module
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Http extends js.Object {

  def createServer(callback: js.Function2[ClientRequest, ServerResponse, Unit]): Server

  def createServer(): Server

  def request(options: HttpRequestOptions, callback: js.Function1[ServerResponse, Unit]): Unit

}

