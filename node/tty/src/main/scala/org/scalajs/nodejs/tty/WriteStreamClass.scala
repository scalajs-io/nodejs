package org.scalajs.nodejs.tty

import org.scalajs.nodejs.FileDescriptor

import scala.scalajs.js


/**
  * Write Stream class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait WriteStreamClass extends js.Object {

  def apply(fd: FileDescriptor): WriteStream = js.native

}
