package com.github.ldaniels528.meansjs.nodejs.express

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * File Transfer Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class FileTransferOptions extends js.Object {
  /** Sets the max-age property of the Cache-Control header in milliseconds or a string in ms format	(default: 0) */
  var maxAge: js.UndefOr[Int] = _

  /** Root directory for relative filenames. */
  var root: js.UndefOr[String] = _

  /** Sets the Last-Modified header to the last modified date of the file on the OS. Set false to disable it.	Enabled	4.9.0+ */
  var lastModified: js.UndefOr[js.Date] = _

  /** Object containing HTTP headers to serve with the file. */
  var headers: js.UndefOr[js.Any] = _

  /** Option for serving dotfiles. Possible values are “allow”, “deny”, “ignore”.	“ignore” */
  var dotfiles: js.UndefOr[js.Array[String]] = _
}

/**
  * File Transfer Options Companion
  * @author lawrence.daniels@gmail.com
  */
object FileTransferOptions {

  def apply(maxAge: js.UndefOr[Int] = js.undefined,
            root: js.UndefOr[String] = js.undefined,
            lastModified: js.UndefOr[js.Date] = js.undefined,
            headers: js.UndefOr[js.Any] = js.undefined,
            dotfiles: js.UndefOr[js.Array[String]] = js.undefined) = {
    val options = new FileTransferOptions()
    options.maxAge = maxAge
    options.root = root
    options.lastModified = lastModified
    options.headers = headers
    options.dotfiles = dotfiles
    options
  }

}
