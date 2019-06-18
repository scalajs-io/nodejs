package io.scalajs.npm.nodefetch

import io.scalajs.nodejs.stream.Readable

import scala.scalajs.js

/**
  * Fetch Response
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait FetchResponse extends js.Object {

  /////////////////////////////////////////////////////////////
  //    Properties
  /////////////////////////////////////////////////////////////

  def body: Readable = js.native

  def ok: Boolean = js.native

  def status: Int = js.native

  def statusText: String = js.native

  def headers: Headers = js.native

  /////////////////////////////////////////////////////////////
  //    Methods
  /////////////////////////////////////////////////////////////

  def json(): js.Any = js.native

  def text(): js.Any = js.native

}