package org.scalajs.nodejs.fs

import org.scalajs.nodejs.errors

import scala.scalajs.js

/**
  * File I/O Error
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait FileIOError extends errors.Error {

  def code: String = js.native

  def errno: String = js.native

  def syscall: String = js.native

}
