package com.github.ldaniels528.meansjs.nodejs.watch

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Watch Options
  * @param ignoreDotFiles         When true this option means that when the file tree is walked it will ignore files
  *                               that being with "."
  * @param filter                 You can use this option to provide a function that returns true or false for each file
  *                               and directory to decide whether or not that file/directory is included in the watcher.
  * @param interval               Specifies the interval duration in milliseconds, the time period between polling for
  *                               file changes.
  * @param ignoreUnreadableDir    When true, this options means that when a file can't be read, this file is silently skipped.
  * @param ignoreNotPermitted     When true, this options means that when a file can't be read due to permission issues,
  *                               this file is silently skipped.
  * @param ignoreDirectoryPattern When a regex pattern is set, e.g. /node_modules/, these directories are silently skipped.
  */
@ScalaJSDefined
class WatchOptions(ignoreDotFiles: js.UndefOr[Boolean] = js.undefined,
                   filter: js.Function = null,
                   interval: js.UndefOr[Int] = js.undefined,
                   ignoreUnreadableDir: js.UndefOr[Boolean] = js.undefined,
                   ignoreNotPermitted: js.UndefOr[Boolean] = js.undefined,
                   ignoreDirectoryPattern: String = null) extends js.Object