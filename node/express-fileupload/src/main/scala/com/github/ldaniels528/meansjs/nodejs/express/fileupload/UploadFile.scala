package com.github.ldaniels528.meansjs.nodejs.express.fileupload

import com.github.ldaniels528.meansjs.nodejs.buffer.Buffer

import scala.scalajs.js

/**
  * Express Upload File
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait UploadFile extends js.Object {

  def name: String = js.native

  def data: Buffer = js.native

  def encoding: String = js.native

  def mimetype: String = js.native

  def mv(path: String, callback: js.Function): js.Any = js.native

}
