package io.scalajs.npm.express.fileupload

import io.scalajs.npm.express.Request

import scala.scalajs.js

/**
  * Express Uploaded Files
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait UploadedFiles extends js.Object {
  self: Request =>

  def files: js.Dictionary[UploadFile] = js.native

}
