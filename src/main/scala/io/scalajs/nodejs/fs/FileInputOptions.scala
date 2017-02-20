package io.scalajs.nodejs.fs

import io.scalajs.nodejs.FileDescriptor

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * File Input Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class FileInputOptions(val flags: js.UndefOr[String] = js.undefined,
                       val encoding: js.UndefOr[String] = js.undefined,
                       val fd: js.UndefOr[FileDescriptor] = js.undefined,
                       val mode: js.UndefOr[Int] = js.undefined,
                       val autoClose: js.UndefOr[Boolean] = js.undefined,
                       val start: js.UndefOr[Int] = js.undefined,
                       val end: js.UndefOr[Int] = js.undefined)
  extends js.Object
