package org.scalajs.nodejs.express.fileupload

import scala.scalajs.js

/**
  * Express Uploaded Files
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait UploadedFiles extends js.Object {

  def files: js.Dictionary[UploadFile] = js.native

}
