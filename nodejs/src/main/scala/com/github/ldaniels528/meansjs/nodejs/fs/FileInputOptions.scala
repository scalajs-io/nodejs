package com.github.ldaniels528.meansjs.nodejs.fs

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * File Input Options
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait FileInputOptions extends js.Object {
  var flags: js.UndefOr[String] = js.native
  var encoding: js.UndefOr[String] = js.native
  var fd: js.UndefOr[FileDescriptor] = js.native
  var mode: js.UndefOr[Int] = js.native
  var autoClose: js.UndefOr[Boolean] = js.native
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
    val options = makeNew[FileInputOptions]
    options.flags = flags
    options.encoding = encoding
    options.fd = fd
    options.mode = mode
    options.autoClose = autoClose
    options
  }

}