package io.scalajs.nodejs.fs

import io.scalajs.FlexibleOptions

import scala.scalajs.js

/**
  * File Encoding Options
  * @param encoding      the character encoding (e.g. "utf8")
  * @param withFileTypes if true [[Fs.readdir()]] will return [[Dirent]]s instead of [[String]]s or [[io.scalajs.nodejs.buffer.Buffer]]s
  * @author lawrence.daniels@gmail.com
  */
class FileEncodingOptions(var encoding: js.UndefOr[String] = js.undefined,
                          var withFileTypes: js.UndefOr[Boolean] = js.undefined) extends js.Object

/**
  * File Encoding Options Companion
  * @author lawrence.daniels@gmail.com
  */
object FileEncodingOptions extends FlexibleOptions[FileEncodingOptions]