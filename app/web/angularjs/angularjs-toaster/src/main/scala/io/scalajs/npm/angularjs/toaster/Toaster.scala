package io.scalajs.npm.angularjs.toaster

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * AngularJS Toaster
  * @author lawrence.daniels@gmail.com
  * @see https://www.npmjs.com/package/angularjs-toaster
  * @see https://github.com/jirikavi/AngularJS-Toaster
  */
@JSGlobal
@js.native
class Toaster extends js.Object {

  /**
    * Closes the toast
    * @param instance the [[ToasterInstance toaster instance]]
    */
  def clear(instance: ToasterInstance): Unit = js.native

  /**
    * Closes the toast
    * @param toasterId the id of the toast container you would like to target
    * @param toastId   the id of the toast you would like to close
    */
  def clear(toasterId: js.Any, toastId: String): Unit = js.native

  def pop(options: ToasterOptions): ToasterInstance = js.native

  def pop(`type`: String = js.native,
          title: String,
          body: String = js.native,
          timeout: Long = js.native,
          showCloseButton: Boolean = js.native): ToasterInstance = js.native

}

class ToasterOptions(var `type`: js.UndefOr[String] = js.undefined,
                     var title: js.UndefOr[String] = js.undefined,
                     var body: js.UndefOr[String] = js.undefined,
                     var timeout: js.UndefOr[Long] = js.undefined,
                     var showCloseButton: js.UndefOr[Boolean] = js.undefined,
                     var closeHtml: js.UndefOr[String] = js.undefined) extends js.Object
