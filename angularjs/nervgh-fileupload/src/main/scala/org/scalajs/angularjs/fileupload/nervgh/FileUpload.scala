package org.scalajs.angularjs.fileupload.nervgh

import scala.scalajs.js

/**
  * AngularJS File Upload
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait FileUpload extends js.Object {

  def upload[T](config: FileUploadConfig): FileUploadPromise[T] = js.native

}


