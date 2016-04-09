package com.github.ldaniels528.nodesjs.nodejs.http

import scala.scalajs.js

/**
  * Http Response
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait HttpResponse extends js.Object {

  ////////////////////////////////////////////////////
  //      Properties
  ////////////////////////////////////////////////////

  var statusCode: Int

  ////////////////////////////////////////////////////
  //    Functions
  ////////////////////////////////////////////////////

  def end(): Unit

  def end(data: js.Any): Unit

  def on(event: String, callback: js.Function): Unit

  def render(path: String): Unit

  def send(data: js.Any): Unit

  def sendStatus(code: Int): Unit

  def set(name: String, value: js.Any): Unit

  def set(values: js.Dictionary[js.Any]): Unit

  def setEncoding(encoding: String): Unit

  def status(code: Int): HttpStatus

  def `type`(mime: String): js.UndefOr[String]

  def write(text: String): Unit

  def writeHead(statusCode: Int, mimeType: js.Dictionary[String])

}
