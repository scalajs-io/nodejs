package io.scalajs.npm.angularjs

import scala.scalajs.js

/**
 * QProvider
 * @example $qProvider.errorOnUnhandledRejections(false)
 * @see [[https://docs.angularjs.org/api/ng/provider/$qProvider]]
 */
@js.native
trait QProvider extends js.Object {

  /**
   * Retrieves or overrides whether to generate an error when a rejected promise is not handled. This feature is enabled by default.
   * @param enabled Whether to generate an error when a rejected promise is not handled.
   * @return Current value when called without a new value or self for chaining otherwise.
   */
  def errorOnUnhandledRejections(enabled: Boolean = js.native): Boolean = js.native

}
