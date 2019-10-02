package io.scalajs.util

import io.scalajs.nodejs.Error

import scala.scalajs.js

object NodeJSConverters {
  implicit final class ErrorExtension(val error: Error) extends AnyVal {
    @inline
    def toException(): Exception = js.JavaScriptException(error.message)
  }
}
