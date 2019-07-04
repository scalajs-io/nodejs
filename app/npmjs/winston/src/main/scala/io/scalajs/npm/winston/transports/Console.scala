package io.scalajs.npm.winston
package transports

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

/**
  * Console Transport Options
  * @author lawrence.daniels@gmail.com
  */

class ConsoleTransportOptions(val level: js.UndefOr[String] = js.undefined,
                              val formatter: js.UndefOr[js.Function1[ConsoleTransportOptions, String]] = js.undefined,
                              val timestamp: js.UndefOr[js.Function1[Unit, Double]] = js.undefined)
  extends js.Object