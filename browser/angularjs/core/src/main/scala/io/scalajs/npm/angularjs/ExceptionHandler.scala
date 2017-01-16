package io.scalajs.npm.angularjs

import scala.scalajs.js

/**
 * Exception Handler - Any uncaught exception in angular expressions is delegated to this service.
 * @see [[https://docs.angularjs.org/api/ng/service/\$exceptionHandler]]
 */
@js.native
trait ExceptionHandler extends js.Object {

  /**
   * Any uncaught exception in angular expressions is delegated to this service.
   * The default implementation simply delegates to \$log.error which logs it into the browser console.
   * @param exception Exception associated with the error.
   * @param cause optional information about the context in which the error was thrown.
   */
  def apply(exception: js.Any, cause: String = js.native): Unit = js.native

}
