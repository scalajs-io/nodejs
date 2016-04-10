package com.github.ldaniels528.meansjs.nodejs.http

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

/**
  * Http Response
  * @author lawrence.daniels@gmail.com
  */
object HttpResponse {

  /**
    * Http Response Enrichment
    * @author lawrence.daniels@gmail.com
    */
  implicit class HttpResponseEnrich(val response: HttpResponse) extends AnyVal {

    def badRequest() = response.sendStatus(400)

    def badRequest(message: String) = response.sendStatus(400)

    def internalServerError() = response.sendStatus(400)

    def internalServerError(message: String) = response.sendStatus(400)

    def internalServerError(cause: Throwable) = response.sendStatus(400)

    def notFound() = response.sendStatus(404)

    def notFound(message: String) = response.sendStatus(404)

  }

}