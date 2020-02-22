package io.scalajs.util

import io.scalajs.nodejs.Error

import scala.scalajs.js

object NodeJSConverters {
  @deprecated("Use io.scalajs.nodejs.ErrorExtensions", "v0.10.0")
  implicit final class ErrorExtensions(val error: Error) extends AnyVal {
    @inline
    def toException(): Exception = js.JavaScriptException(error.message)
  }
}
