package io.scalajs.npm.winston
package transports

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * File Transport
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("winston", "transports.File")
class File(options: FileTransportOptions = js.native) extends Transport

/**
  * File Transport Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("winston", "transports.File")
object File extends Transport
