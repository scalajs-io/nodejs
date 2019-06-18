package io.scalajs.npm.express.fileupload

import io.scalajs.npm.express.Router

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Simple express file upload middleware that wraps around connect-busboy
  * @see https://www.npmjs.com/package/express-fileupload
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ExpressFileUpload extends Router {

  def apply(): js.Function = js.native

}

/**
  * Express-FileUpload Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("express-fileupload", JSImport.Namespace)
object ExpressFileUpload extends ExpressFileUpload