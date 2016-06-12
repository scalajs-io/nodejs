package com.github.ldaniels528.meansjs.nodejs.dns

import com.github.ldaniels528.meansjs.nodejs.errors

import scala.scalajs.js

/**
  * Represents a DNS Error
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait DnsError extends errors.Error {

  def code: String = js.native

  def errno: String = js.native

  def syscall: String = js.native

  def hostname: String = js.native

}