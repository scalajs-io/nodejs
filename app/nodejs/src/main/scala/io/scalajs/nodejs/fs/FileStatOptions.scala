package io.scalajs.nodejs.fs

import scala.scalajs.js

/**
  * File Stat Options
  * @param bigint Whether the numeric values in the returned fs.Stats object should be bigint. Default: false.
  */
class FileStatOptions(var bigint: js.UndefOr[Boolean] = js.undefined) extends js.Object