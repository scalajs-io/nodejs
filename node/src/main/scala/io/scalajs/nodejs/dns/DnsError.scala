package io.scalajs.nodejs.dns

import io.scalajs.nodejs.Error

import scala.scalajs.js

/**
  * Represents a DNS Error
  * @author lawrence.daniels@gmail.com
  */
@js.native
class DnsError(message: String = "") extends Error(message) {

  def code: String = js.native

  def errno: String = js.native

  def syscall: String = js.native

  def hostname: String = js.native

}