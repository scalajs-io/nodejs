package com.github.ldaniels528.meansjs.nodejs.fs

import com.github.ldaniels528.meansjs.nodejs.fs.Fs.FileDescriptor

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * File Input Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class FileInputOptions extends js.Object {
  var flags: js.UndefOr[String] = _
  var encoding: js.UndefOr[String] = _
  var fd: js.UndefOr[FileDescriptor] = _
  var mode: js.UndefOr[Int] = _
  var autoClose: js.UndefOr[Boolean] = _
}

/**
  * File Input Options Companion
  * @author lawrence.daniels@gmail.com
  */
object FileInputOptions {

  def apply(flags: js.UndefOr[String] = js.undefined,
            encoding: js.UndefOr[String] = js.undefined,
            fd: js.UndefOr[FileDescriptor] = js.undefined,
            mode: js.UndefOr[Int] = js.undefined,
            autoClose: js.UndefOr[Boolean] = js.undefined) = {
    val options = new FileInputOptions()
    options.flags = flags
    options.encoding = encoding
    options.fd = fd
    options.mode = mode
    options.autoClose = autoClose
    options
  }

}