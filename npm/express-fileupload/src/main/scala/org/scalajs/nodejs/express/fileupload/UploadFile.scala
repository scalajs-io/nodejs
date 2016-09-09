package org.scalajs.nodejs.express.fileupload

import org.scalajs.nodejs.buffer.Buffer
import org.scalajs.nodejs.errors
import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.nodejs.util.ScalaJsHelper

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
