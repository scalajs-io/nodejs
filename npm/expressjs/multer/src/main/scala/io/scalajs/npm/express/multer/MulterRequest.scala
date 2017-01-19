package io.scalajs.npm.express.multer

import io.scalajs.npm.express.Request

import scala.scalajs.js

/**
  * Multer Request Augmentation
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait MulterRequest extends Request {

  def files: js.Array[MulterFile] = js.native

}
