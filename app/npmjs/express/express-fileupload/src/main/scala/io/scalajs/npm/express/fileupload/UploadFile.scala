package io.scalajs.npm.express.fileupload

import io.scalajs.nodejs.FileIOError
import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.util.PromiseHelper._

import scala.concurrent.Future
import scala.scalajs.js

/**
  * Express Upload File
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait UploadFile extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * The name of the file
    */
  def name: String = js.native

  /**
    * A buffer representation of the file
    */
  def data: Buffer = js.native

  /**
    * The file's encoding
    */
  def encoding: String = js.native

  /**
    * The file's MIME type
    */
  def mimetype: String = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * A function to move the file elsewhere on your server.
    * @param path     the given path to move the file to
    * @param callback the callback/handler function
    */
  def mv(path: String, callback: js.Function1[FileIOError, Any]): Unit = js.native

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
    def mvFuture(path: String): Future[Unit] = promiseWithError0[FileIOError](file.mv(path, _))

  }

}
