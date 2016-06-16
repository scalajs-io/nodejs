package org.scalajs.angularjs.uibootstrap

import org.scalajs.angularjs.Controller

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Modal Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class ModalOptions(var template: js.UndefOr[String] = js.undefined,
                   var templateUrl: js.UndefOr[String] = js.undefined,
                   var controller: js.UndefOr[String] = js.undefined,
                   var controllerClass: js.UndefOr[Class[_ <: Controller]] = js.undefined,
                   var controllerAs: js.Any = js.undefined,
                   var scope: js.Any = js.undefined,
                   var size: js.UndefOr[String] = "lg",
                   var windowClass: js.UndefOr[String] = js.undefined,
                   var windowTemplateUrl: js.UndefOr[String] = js.undefined,
                   var animation: js.UndefOr[Boolean] = js.undefined,
                   var backdrop: js.UndefOr[Boolean] = js.undefined,
                   var backdropClass: js.UndefOr[String] = js.undefined,
                   var keyboard: js.UndefOr[Boolean] = js.undefined) extends js.Object