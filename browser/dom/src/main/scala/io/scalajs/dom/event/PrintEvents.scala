package io.scalajs.dom.event

import scala.scalajs.js

/**
  * Print Events
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait PrintEvents extends js.Object {

  /**
    * The event occurs when a page has started printing, or if the print dialogue box has been closed
    */
  def onafterprint(callback: js.Function): Unit = js.native

  /**
    * The event occurs when a page is about to be printed
    */
  def onbeforeprint(callback: js.Function): Unit = js.native

}
