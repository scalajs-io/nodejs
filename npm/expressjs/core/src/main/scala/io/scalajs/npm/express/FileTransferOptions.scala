package io.scalajs.npm.express

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * File Transfer Options
  * @param maxAge       Sets the max-age property of the Cache-Control header in milliseconds or a string in ms format (default: 0)
  * @param root         Root directory for relative filenames.
  * @param lastModified Sets the Last-Modified header to the last modified date of the file on the OS. Set false to
  *                     disable it.	Enabled	4.9.0+
  * @param headers      Object containing HTTP headers to serve with the file.
  * @param dotfiles     Option for serving dotfiles. Possible values are “allow”, “deny”, “ignore”.	“ignore”
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class FileTransferOptions(var maxAge: js.UndefOr[Int] = js.undefined,
                          var root: js.UndefOr[String] = js.undefined,
                          var lastModified: js.UndefOr[js.Date] = js.undefined,
                          var headers: js.UndefOr[js.Any] = js.undefined,
                          var dotfiles: js.UndefOr[js.Array[String]] = js.undefined) extends js.Object

