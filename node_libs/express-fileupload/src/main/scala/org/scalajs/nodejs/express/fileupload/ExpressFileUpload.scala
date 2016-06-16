package org.scalajs.nodejs.express.fileupload

import org.scalajs.nodejs.NodeRequire
import org.scalajs.nodejs.express.Router
import org.scalajs.nodejs.express.Router

import scala.scalajs.js

/**
  * Express File Upload
  * @author lawrence.daniels@gmail.com
  * @see [[https://www.npmjs.com/package/express-fileupload]]
  * @version 0.0.5
  */
@js.native
trait ExpressFileUpload extends js.Object with Router {

  def apply(): js.Function = js.native

}

/**
  * ExpressFileUpload Companion
  * @author lawrence.daniels@gmail.com
  */
object ExpressFileUpload {

  /**
    * Convenience method for retrieving the 'express-fileupload' module
    * @param require the implicit [[NodeRequire require function]]
    * @return the ExpressFileUpload instance
    */
  def apply()(implicit require: NodeRequire) = require[ExpressFileUpload]("express-fileupload")

}