package io.scalajs.npm.winston
package transports

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

/**
  * Winston Transport Options
  * @param filename the name of the file to log to
  */

class FileTransportOptions(val name: js.UndefOr[String] = js.undefined,
                           val filename: js.UndefOr[String] = js.undefined,
                           val level: js.UndefOr[String] = js.undefined,
                           val formatter: js.UndefOr[js.Function1[FileTransportOptions, String]] = js.undefined,
                           val timestamp: js.UndefOr[js.Function1[Unit, Double]] = js.undefined) extends js.Object