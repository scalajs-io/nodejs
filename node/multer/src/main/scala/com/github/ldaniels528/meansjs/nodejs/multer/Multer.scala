package com.github.ldaniels528.meansjs.nodejs.multer

import com.github.ldaniels528.meansjs.nodejs.NodeModule
import com.github.ldaniels528.meansjs.nodejs.express.Router

import scala.scalajs.js

/**
  * Multer is a node.js middleware for handling multipart/form-data.
  * @author lawrence.daniels@gmail.com
  * @see https://github.com/expressjs/multer
  * @version 1.1.0
  */
@js.native
trait Multer extends NodeModule {

  def apply(options: MulterOptions): Router = js.native

  def diskStorage: js.Dynamic = js.native

  def memoryStorage: js.Dynamic = js.native

}