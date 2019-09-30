package io.scalajs.nodejs.net

import io.scalajs.nodejs.FileDescriptor

import scala.scalajs.js

/**
  * Socket Options
  *
  * @param fd fd allows you to specify the existing file descriptor of socket. Set readable and/or writable to true to allow
  *           reads and/or writes on this socket (NOTE: Works only when fd is passed). About allowHalfOpen, refer to createServer()
  *           and 'end' event.
  * @param allowHalfOpen
  * @param readable
  * @param writable
  */
class SocketOptions(val fd: js.UndefOr[FileDescriptor] = js.undefined,
                    val allowHalfOpen: js.UndefOr[Boolean] = js.undefined,
                    val readable: js.UndefOr[Boolean] = js.undefined,
                    val writable: js.UndefOr[Boolean] = js.undefined)
    extends js.Object
