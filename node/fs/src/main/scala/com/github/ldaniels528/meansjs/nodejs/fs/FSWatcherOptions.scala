package com.github.ldaniels528.meansjs.nodejs.fs

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * FS Watcher Options
  * @param encoding   Specifies the character encoding to be used for the filename passed to the listener (default: "utf8")
  * @param persistent Indicates whether the process should continue to run as long as files are being watched (default: true)
  * @param recursive  Indicates whether all subdirectories should be watched, or only the current directory.
  *                   The applies when a directory is specified, and only on supported platforms (See Caveats) (default: false)
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class FSWatcherOptions(var encoding: js.UndefOr[String] = js.undefined,
                       var persistent: js.UndefOr[Boolean] = js.undefined,
                       var recursive: js.UndefOr[Boolean] = js.undefined) extends js.Object
