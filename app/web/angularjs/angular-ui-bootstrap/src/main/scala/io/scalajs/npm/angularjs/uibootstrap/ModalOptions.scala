package io.scalajs.npm.angularjs.uibootstrap

import io.scalajs.FlexibleOptions

import scala.scalajs.js

/**
  * Modal Options
  * @author lawrence.daniels@gmail.com
  */
class ModalOptions(var template: js.UndefOr[String] = js.undefined,
                   var templateUrl: js.UndefOr[String] = js.undefined,
                   var controller: js.UndefOr[String] = js.undefined,
                   var controllerAs: js.Any = js.undefined,
                   var scope: js.Any = js.undefined,
                   var size: js.UndefOr[String] = "lg",
                   var windowClass: js.UndefOr[String] = js.undefined,
                   var windowTemplateUrl: js.UndefOr[String] = js.undefined,
                   var animation: js.UndefOr[Boolean] = js.undefined,
                   var backdrop: js.UndefOr[Boolean] = js.undefined,
                   var backdropClass: js.UndefOr[String] = js.undefined,
                   var keyboard: js.UndefOr[Boolean] = js.undefined,
                   var resolve: js.Any = js.undefined)
  extends js.Object

/**
  * Modal Options Companion
  * @author lawrence.daniels@gmail.com
  */
object ModalOptions extends FlexibleOptions[ModalOptions]