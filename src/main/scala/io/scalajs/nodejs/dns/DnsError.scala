package io.scalajs.nodejs.dns

import io.scalajs.nodejs.Error

import scala.scalajs.js

/**
  * Represents a DNS Error
  * @author lawrence.daniels@gmail.com
  */
@js.native
class DnsError(message: String = "") extends Error(message)