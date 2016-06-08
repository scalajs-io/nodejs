package com.github.ldaniels528.meansjs.nodejs.net

import com.github.ldaniels528.meansjs.nodejs.FileDescriptor
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Socket Options
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait SocketOptions extends js.Object {

  /**
    * fd allows you to specify the existing file descriptor of socket. Set readable and/or writable to true to allow
    * reads and/or writes on this socket (NOTE: Works only when fd is passed). About allowHalfOpen, refer to createServer()
    * and 'end' event.
    */
  var fd: js.UndefOr[FileDescriptor] = js.native

  var allowHalfOpen: js.UndefOr[Boolean] = js.native

  var readable: js.UndefOr[Boolean] = js.native

  var writable: js.UndefOr[Boolean] = js.native
}

/**
  * Socket Options Companion
  * @author lawrence.daniels@gmail.com
  */
object SocketOptions {

  def apply(fd: js.UndefOr[FileDescriptor] = js.undefined,
            allowHalfOpen: js.UndefOr[Boolean] = js.undefined,
            readable: js.UndefOr[Boolean] = js.undefined,
            writable: js.UndefOr[Boolean] = js.undefined) = {
    val options = New[SocketOptions]
    options.fd = fd
    options.allowHalfOpen = allowHalfOpen
    options.readable = readable
    options.writable = writable
    options
  }

}

