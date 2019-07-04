package io.scalajs.nodejs.fs

import io.scalajs.nodejs.FileMode

import scala.scalajs.js

/**
  * File Append Options
  * @param encoding Default: 'utf8'
  * @param mode     Default: 0o666
  * @param flag     See support of file system flags. Default: 'a'.
  * @author lawrence.daniels@gmail.com
  */
class FileAppendOptions(var encoding: js.UndefOr[String] = js.undefined,
                        var mode: js.UndefOr[FileMode] = js.undefined,
                        var flag: js.UndefOr[String] = js.undefined) extends js.Object
