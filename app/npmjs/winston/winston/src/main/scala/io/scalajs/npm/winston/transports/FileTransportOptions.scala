package io.scalajs.npm.winston.transports

import io.scalajs.FlexibleOptions

import scala.scalajs.js

/**
  * Winston Transport Options
  * @param filename the name of the file to log to
  */
class FileTransportOptions(var name: js.UndefOr[String] = js.undefined,
                           var filename: js.UndefOr[String] = js.undefined,
                           var level: js.UndefOr[String] = js.undefined,
                           var formatter: js.UndefOr[js.Function1[FileTransportOptions, String]] = js.undefined,
                           var timestamp: js.UndefOr[js.Function1[Unit, Double]] = js.undefined) extends js.Object

/**
  * Winston Transport Options
  * @author lawrence.daniels@gmail.com
  */
object FileTransportOptions extends FlexibleOptions[FileTransportOptions]