package com.github.ldaniels528.meansjs.nodejs.fs

import com.github.ldaniels528.meansjs.nodejs.fs.Fs.FileDescriptor

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * File Input Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class FileOutputOptions extends js.Object {
  var flags: js.UndefOr[String] = _
  var defaultEncoding: js.UndefOr[String] = _
  var fd: js.UndefOr[FileDescriptor] = _
  var mode: js.UndefOr[Int] = _
  var autoClose: js.UndefOr[Boolean] = _
}

/**
  * File Input Options Companion
  * @author lawrence.daniels@gmail.com
  */
object FileOutputOptions {

  def apply(flags: js.UndefOr[String] = js.undefined,
            defaultEncoding: js.UndefOr[String] = js.undefined,
            fd: js.UndefOr[FileDescriptor] = js.undefined,
            mode: js.UndefOr[Int] = js.undefined,
            autoClose: js.UndefOr[Boolean] = js.undefined) = {
    val options = new FileOutputOptions()
    options.flags = flags
    options.defaultEncoding = defaultEncoding
    options.fd = fd
    options.mode = mode
    options.autoClose = autoClose
    options
  }

}