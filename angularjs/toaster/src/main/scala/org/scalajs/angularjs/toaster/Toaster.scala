package org.scalajs.angularjs.toaster

import scala.concurrent.duration.FiniteDuration
import scala.scalajs.js

/**
 * AngularJS Toaster
 * @author lawrence.daniels@gmail.com
 * @see https://github.com/jirikavi/AngularJS-Toaster
 */
@js.native
trait Toaster extends js.Object {

  def pop(`type`: js.Any = js.native,
          title: js.Any,
          message: js.Any = js.native,
          delay: Long = js.native,
          format: js.Any = js.native): Unit = js.native

}

/**
 * AngularJS Toaster Singleton
 * @author lawrence.daniels@gmail.com
 */
object Toaster {
  val INFO = "info"
  val DANGER = "danger"
  val ERROR = "error"
  val SUCCESS = "success"
  val WARNING = "warning"

  /**
   * Toaster Enhancements
   * @param toaster the given Toaster service instance
   */
  final implicit class ToasterEnhancements(val toaster: Toaster) extends AnyVal {

    @inline
    def info(title: js.Any, message: js.Any = null) = toaster.pop(`type` = INFO, title, message)

    @inline
    def info(title: js.Any, message: js.Any, delay: Long, format: js.Any) = toaster.pop(`type` = INFO, title, message, delay, format)

    @inline
    def info(title: js.Any, message: js.Any, delay: FiniteDuration, format: js.Any) = pop(`type` = INFO, title, message, delay, format)

    @inline
    def danger(title: js.Any, message: js.Any = null) = toaster.pop(`type` = DANGER, title, message)

    @inline
    def error(title: js.Any, message: js.Any = null) = toaster.pop(`type` = ERROR, title, message)

    @inline
    def pop(`type`: js.Any, title: js.Any, message: js.Any, delay: FiniteDuration, format: js.Any): Unit = toaster.pop(`type`, title, message, delay.toMillis.toInt, format)

    @inline
    def success(title: js.Any, message: js.Any = null) = toaster.pop(`type` = SUCCESS, title, message)

    @inline
    def success(title: js.Any, message: js.Any, delay: Long, format: js.Any) = toaster.pop(`type` = SUCCESS, title, message, delay, format)

    @inline
    def success(title: js.Any, message: js.Any, delay: FiniteDuration, format: js.Any) = pop(`type` = SUCCESS, title, message, delay, format)

    @inline
    def warning(title: js.Any, message: js.Any = null) = toaster.pop(`type` = WARNING, title, message)

    @inline
    def warning(title: js.Any, message: js.Any, delay: Long, format: js.Any) = toaster.pop(`type` = WARNING, title, message, delay, format)

    @inline
    def warning(title: js.Any, message: js.Any, delay: FiniteDuration, format: js.Any) = pop(`type` = WARNING, title, message, delay, format)

  }

}