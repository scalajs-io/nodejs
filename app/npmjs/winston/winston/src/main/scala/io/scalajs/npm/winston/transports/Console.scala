package io.scalajs.npm.winston
package transports

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Console Transport
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("winston", "transports.Console")
class Console(options: ConsoleTransportOptions = js.native) extends Transport

/**
  * Console Transport Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("winston", "transports.Console")
object Console extends Transport
