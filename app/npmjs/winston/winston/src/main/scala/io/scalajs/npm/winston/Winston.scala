package io.scalajs.npm.winston

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * winston - A multi-transport async logging library for Node.js
  * @see https://www.npmjs.com/package/winston#using-the-default-logger
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("winston", JSImport.Namespace)
object Winston extends Logger