package com.github.ldaniels528.meansjs.nodejs.multer

import com.github.ldaniels528.meansjs.nodejs.express

import scala.scalajs.js

/**
  * Multer Request Augmentation
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait MulterRequest extends express.Request {

  def files: js.Array[MulterFile] = js.native

}
