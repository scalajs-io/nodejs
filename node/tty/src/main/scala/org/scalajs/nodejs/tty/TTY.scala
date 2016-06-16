package org.scalajs.nodejs.tty

import org.scalajs.nodejs.{FileDescriptor, NodeRequire}

import scala.scalajs.js

/**
  * The tty module provides the tty.ReadStream and tty.WriteStream classes. In most cases, it will not be necessary
  * or possible to use this module directly.
  */
@js.native
trait TTY extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Classes
  /////////////////////////////////////////////////////////////////////////////////

  def ReadStream: ReadStreamClass = js.native

  def WriteStream: WriteStreamClass = js.native

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
  * TTY Companion
  * @author lawrence.daniels@gmail.com
  */
object TTY {

  /**
    * Convenience method for retrieving the tty module
    * @param require the implicit [[NodeRequire require function]]
    * @return the TTY instance
    */
  def apply()(implicit require: NodeRequire) = require[TTY]("tty")

}
