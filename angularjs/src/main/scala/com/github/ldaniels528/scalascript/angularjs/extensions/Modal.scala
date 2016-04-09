package com.github.ldaniels528.nodesjs.angularjs.extensions

import com.github.ldaniels528.nodesjs.angularjs.Controller
import com.github.ldaniels528.nodesjs.angularjs.core.QPromise

import scala.scalajs.js

/**
 * AngularJS Modal Service ($modal)
 * @author lawrence.daniels@gmail.com
 * @see http://angular-ui.github.io/bootstrap/#/modal
 */
@js.native
trait Modal extends js.Object {

  /**
   * Creates and opens a new modal dialog instance
   * @param options the given [[ModalOptions Modal Options]]
   * @tparam T the return type
   * @return a new [[ModalInstance Modal Instance]]
   */
  def open[T](options: ModalOptions): ModalInstance[T] = js.native

}

/**
 * AngularJS Modal Instance ($modalInstance)
 * @author lawrence.daniels@gmail.com
 */
@js.native
trait ModalInstance[T] extends js.Object {

  def close(): Unit = js.native

  def close(result: T): Unit = js.native

  def dismiss(reason: js.Any): Unit = js.native

  def result: QPromise[T] = js.native

  def opened: QPromise[js.Any] = js.native

}

/**
 * Modal Options
 * @author lawrence.daniels@gmail.com
 */
@js.native
trait ModalOptions extends js.Object {
  var template: String = js.native
  var templateUrl: String = js.native
  var controller: String = js.native
  var controllerAs: js.Any = js.native
  var scope: Any = js.native
  var size: String = js.native
  var windowClass: String = js.native
  var windowTemplateUrl: String = js.native
  var animation: Boolean = js.native
  var backdrop: Boolean = js.native
  var backdropClass: String = js.native
  var keyboard: Boolean = js.native
  var resolve: js.Dictionary[js.Any] = js.native

}

/**
 * Modal Options Singleton
 * @author lawrence.daniels@gmail.com
 */
object ModalOptions {

  def apply[T <: Controller](template: String = null,
                             templateUrl: String = null,
                             controller: String = null,
                             controllerClass: Class[T] = null,
                             controllerAs: js.Any = null,
                             scope: Any = null,
                             size: String = "lg",
                             windowClass: String = null,
                             windowTemplateUrl: String = null,
                             animation: Boolean = true,
                             backdrop: Boolean = true,
                             backdropClass: String = null,
                             keyboard: Boolean = false,
                             resolve: js.Dictionary[js.Any] = js.Dictionary.empty): ModalOptions = {
    val options = new js.Object().asInstanceOf[ModalOptions]
    Option(template).foreach(options.template = _)
    Option(templateUrl).foreach(options.templateUrl = _)
    Option(controller).foreach(options.controller = _)
    Option(controllerClass).foreach(c => options.controller = c.getSimpleName)
    Option(scope).foreach(options.scope = _)
    Option(size).foreach(options.size = _)
    Option(windowClass).foreach(options.windowClass = _)
    Option(windowTemplateUrl).foreach(options.windowTemplateUrl = _)
    Option(animation).foreach(options.animation = _)
    Option(backdrop).foreach(options.backdrop = _)
    Option(backdropClass).foreach(options.backdropClass = _)
    Option(keyboard).foreach(options.keyboard = _)
    Option(resolve).foreach(options.resolve = _)
    options
  }

}

