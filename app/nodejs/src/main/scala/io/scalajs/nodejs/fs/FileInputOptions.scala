package io.scalajs.nodejs.fs

import io.scalajs.FlexibleOptions
import io.scalajs.nodejs.FileDescriptor

import scala.scalajs.js

/**
  * File Input Options
  * @author lawrence.daniels@gmail.com
  */
class FileInputOptions(var flags: js.UndefOr[String] = js.undefined,
                       var encoding: js.UndefOr[String] = js.undefined,
                       var fd: js.UndefOr[FileDescriptor] = js.undefined,
                       var mode: js.UndefOr[Int] = js.undefined,
                       var autoClose: js.UndefOr[Boolean] = js.undefined,
                       var start: js.UndefOr[Int] = js.undefined,
                       var end: js.UndefOr[Int] = js.undefined) extends js.Object

/**
  * File Input Options Companion
  * @author lawrence.daniels@gmail.com
  */
object FileInputOptions extends FlexibleOptions[FileInputOptions]