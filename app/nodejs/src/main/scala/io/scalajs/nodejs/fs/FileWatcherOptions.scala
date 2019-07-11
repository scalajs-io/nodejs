package io.scalajs.nodejs.fs

import io.scalajs.FlexibleOptions

import scala.scalajs.js

/**
  * File Watcher Options
  * @param persistent <Boolean>
  * @param interval   <Integer>
  */
class FileWatcherOptions(var persistent: js.UndefOr[Boolean] = js.undefined,
                         var interval: js.UndefOr[Int] = js.undefined) extends js.Object

/**
  * File Watcher Options Companion
  * @author lawrence.daniels@gmail.com
  */
object FileWatcherOptions extends FlexibleOptions[FileWatcherOptions]