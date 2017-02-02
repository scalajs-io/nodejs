package io.scalajs.npm.cassandradriver.types

import scala.scalajs.js

/**
  * Response Error Codes object
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ResponseErrorCodes extends js.Object {
  var serverError: Int          = js.native
  var protocolError: Int        = js.native
  var badCredentials: Int       = js.native
  var unavailableException: Int = js.native
  var overloaded: Int           = js.native
  var isBootstrapping: Int      = js.native
  var truncateError: Int        = js.native
  var writeTimeout: Int         = js.native
  var readTimeout: Int          = js.native
  var readFailure: Int          = js.native
  var functionFailure: Int      = js.native
  var writeFailure: Int         = js.native
  var syntaxError: Int          = js.native
  var unauthorized: Int         = js.native
  var invalid: Int              = js.native
  var configError: Int          = js.native
  var alreadyExists: Int        = js.native
  var unprepared: Int           = js.native
}
