package com.github.ldaniels528.meansjs.nodejs.tty

import com.github.ldaniels528.meansjs.nodejs.FileDescriptor

import scala.scalajs.js


/**
  * Write Stream class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait WriteStreamClass extends js.Object {

  def apply(fd: FileDescriptor): WriteStream = js.native

}
