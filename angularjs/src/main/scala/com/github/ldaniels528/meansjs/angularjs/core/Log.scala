package com.github.ldaniels528.meansjs.angularjs.core

import scala.scalajs.js

/**
 * AngularJS Log Service - Simple service for logging. Default implementation safely writes the message
 * into the browser's console (if present).
 * @see [[https://docs.angularjs.org/api/ng/service/\$log]]
 */
@js.native
trait Log extends js.Object {

  /**
   * Write a debug message
   * @param message the given message
   */
  def debug(message: js.Any): Unit = js.native

  /**
   * Write an error message
   * @param message the given message
   */
  def error(message: js.Any): Unit = js.native

  /**
   * Write an information message
   * @param message the given message
   */
  def info(message: js.Any): Unit = js.native

  /**
   * Write a log message
   * @param message the given message
   */
  def log(message: js.Any): Unit = js.native

  /**
   * Write a warning message
   * @param message the given message
   */
  def warn(message: js.Any): Unit = js.native

}

/**
 * AngularJS Log Provider - Use the \$logProvider to configure how the application logs messages
 */
@js.native
trait LogProvider extends Provider[Log] {

  /**
   * Enable or disable debug level messages
   * @param flag the given enable/disable flag
   * @return current value if used as getter or itself (chaining) if used as setter
   */
  def debugEnabled(flag: Boolean = js.native): Boolean = js.native

}