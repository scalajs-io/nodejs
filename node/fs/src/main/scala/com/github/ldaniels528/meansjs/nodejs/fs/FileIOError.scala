package com.github.ldaniels528.meansjs.nodejs.fs

import com.github.ldaniels528.meansjs.nodejs.errors

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
