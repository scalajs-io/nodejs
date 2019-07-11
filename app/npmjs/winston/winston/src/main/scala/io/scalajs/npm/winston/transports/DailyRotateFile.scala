package io.scalajs.npm.winston
package transports

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Daily Rotate Transport
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("winston", "transports.DailyRotateFile")
class DailyRotateFile(options: DailyRotateFileOptions = js.native) extends Transport

