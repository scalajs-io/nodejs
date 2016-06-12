package com.github.ldaniels528.meansjs.nodejs.fs

import com.github.ldaniels528.meansjs.nodejs.FileDescriptor

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * File Input Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class FileInputOptions(var flags: js.UndefOr[String] = js.undefined,
                       var encoding: js.UndefOr[String] = js.undefined,
                       var fd: js.UndefOr[FileDescriptor] = js.undefined,
                       var mode: js.UndefOr[Int] = js.undefined,
                       var autoClose: js.UndefOr[Boolean] = js.undefined) extends js.Object