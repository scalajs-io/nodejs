package io.scalajs.nodejs.net

import io.scalajs.nodejs.FileDescriptor

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Socket Options
  * @param fd fd allows you to specify the existing file descriptor of socket. Set readable and/or writable to true to allow
  *           reads and/or writes on this socket (NOTE: Works only when fd is passed). About allowHalfOpen, refer to createServer()
  *           and 'end' event.
  * @param allowHalfOpen
  * @param readable
  * @param writable
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class SocketOptions(var fd: js.UndefOr[FileDescriptor] = js.undefined,
                    var allowHalfOpen: js.UndefOr[Boolean] = js.undefined,
                    var readable: js.UndefOr[Boolean] = js.undefined,
                    var writable: js.UndefOr[Boolean] = js.undefined) extends js.Object