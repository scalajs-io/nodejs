package io.scalajs.npm.aws

import scala.scalajs.js

/**
  * Represents the Progress of a HTTP operation
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Progress extends js.Object {

  def loaded: Double = js.native

  def total: Double = js.native

}
