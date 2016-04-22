package com.github.ldaniels528.meansjs.nodejs.fs

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * File Input Options
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait FileOutputOptions extends js.Object {
  var flags: js.UndefOr[String] = js.native
  var defaultEncoding: js.UndefOr[String] = js.native
  var fd: js.UndefOr[FileDescriptor] = js.native
  var mode: js.UndefOr[Int] = js.native
  var autoClose: js.UndefOr[Boolean] = js.native
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
    val options = makeNew[FileOutputOptions]
    options.flags = flags
    options.defaultEncoding = defaultEncoding
    options.fd = fd
    options.mode = mode
    options.autoClose = autoClose
    options
  }

}