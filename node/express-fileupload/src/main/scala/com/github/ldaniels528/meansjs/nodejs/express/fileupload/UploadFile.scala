package com.github.ldaniels528.meansjs.nodejs.express.fileupload

import com.github.ldaniels528.meansjs.nodejs.buffer.Buffer
import com.github.ldaniels528.meansjs.nodejs.errors
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

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

  def mv(path: String, callback: js.Function): Unit = js.native

}

/**
  * Upload File Companion
  * @author lawrence.daniels@gmail.com
  */
object UploadFile {

  /**
    * Upload File Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class UploadFileExtensions(val file: UploadFile) extends AnyVal {

    @inline
    def mvFuture(path: String) = futureCallbackE0[errors.Error](file.mv(path, _))

  }

}
