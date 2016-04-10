package com.github.ldaniels528.meansjs.nodejs.http

import com.github.ldaniels528.meansjs.nodejs.net.Server

import scala.scalajs.js

/**
  * Scala.js Binding for Node.js Http Module
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Http extends js.Object {

  def createServer(): Server

  def createServer(callback: js.Function2[HttpRequest, HttpResponse, Unit]): Server

  def request(options: HttpRequestOptions, callback: js.Function1[HttpResponse, Unit]): Unit

}

/**
  * Http Module
  * @author lawrence.daniels@gmail.com
  */
object Http {

  def apply() = {
    val module = js.Dynamic.global.require("http")
    module.asInstanceOf[js.UndefOr[Http]]
  }

}
