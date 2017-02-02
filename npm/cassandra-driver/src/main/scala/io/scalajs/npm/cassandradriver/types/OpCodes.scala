package io.scalajs.npm.cassandradriver.types

import scala.scalajs.js

/**
  * OpCodes object
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait OpCodes extends js.Object {
  var error: Int         = js.native
  var startup: Int       = js.native
  var ready: Int         = js.native
  var authenticate: Int  = js.native
  var credentials: Int   = js.native
  var options: Int       = js.native
  var supported: Int     = js.native
  var query: Int         = js.native
  var result: Int        = js.native
  var prepare: Int       = js.native
  var execute: Int       = js.native
  var register: Int      = js.native
  var event: Int         = js.native
  var batch: Int         = js.native
  var authChallenge: Int = js.native
  var authResponse: Int  = js.native
  var authSuccess: Int   = js.native

  def isInRange: js.Function1[Int, Boolean] = js.native

}
