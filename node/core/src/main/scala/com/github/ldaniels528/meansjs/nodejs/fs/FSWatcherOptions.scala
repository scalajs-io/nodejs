package com.github.ldaniels528.meansjs.nodejs.fs

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * FS Watcher Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class FSWatcherOptions extends js.Object {

  /**
    * Specifies the character encoding to be used for the filename passed to the listener. default = 'utf8'
    */
  var encoding: js.UndefOr[String] = _

  /**
    * Indicates whether the process should continue to run as long as files are being watched. default = true
    */
  var persistent: js.UndefOr[Boolean] = _

  /**
    * Indicates whether all subdirectories should be watched, or only the current directory.
    * The applies when a directory is specified, and only on supported platforms (See Caveats). default = false
    */
  var recursive: js.UndefOr[Boolean] = _

}

/**
  * Watcher Options Companion
  * @author lawrence.daniels@gmail.com
  */
object FSWatcherOptions {

  def apply(encoding: js.UndefOr[String] = js.undefined,
            persistent: js.UndefOr[Boolean] = js.undefined,
            recursive: js.UndefOr[Boolean] = js.undefined) = {
    val options = new FSWatcherOptions()
    options.persistent = persistent
    options.recursive = recursive
    options.encoding = encoding
    options
  }

}