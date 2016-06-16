package org.scalajs.nodejs.multer

import org.scalajs.nodejs.express
import org.scalajs.nodejs.express.Request

import scala.scalajs.js

/**
  * Multer Request Augmentation
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait MulterRequest extends Request {

  def files: js.Array[MulterFile] = js.native

}
