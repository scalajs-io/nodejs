package io.scalajs.nodejs.tty

import io.scalajs.nodejs.FileDescriptor

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * The tty module provides the tty.ReadStream and tty.WriteStream classes. In most cases, it will not be necessary
  * or possible to use this module directly.
  * @version 7.4.0
  * @see https://nodejs.org/api/tty.html
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait TTY extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * The tty.isatty() method returns true if the given fd is associated with a TTY and false if is not.
    * @param fd A numeric file descriptor
    * @since 0.5.8
    */
  def isatty(fd: FileDescriptor): Boolean = js.native

}

/**
  * TTY Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("tty", JSImport.Namespace)
object TTY extends TTY