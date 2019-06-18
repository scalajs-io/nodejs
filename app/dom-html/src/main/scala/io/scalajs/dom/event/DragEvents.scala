package io.scalajs.dom.event

import scala.scalajs.js

/**
  * Drag Events
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait DragEvents extends js.Object {

  /**
    * The event occurs when an element is being dragged
    */
  def ondrag(callback: js.Function): Unit = js.native

  /**
    * The event occurs when the user has finished dragging an element
    */
  def ondragend(callback: js.Function): Unit = js.native

  /**
    * The event occurs when the dragged element enters the drop target
    */
  def ondragenter(callback: js.Function): Unit = js.native

  /**
    * The event occurs when the dragged element leaves the drop target
    */
  def ondragleave(callback: js.Function): Unit = js.native

  /**
    * The event occurs when the dragged element is over the drop target
    */
  def ondragover(callback: js.Function): Unit = js.native

  /**
    * The event occurs when the user starts to drag an element
    */
  def ondragstart(callback: js.Function): Unit = js.native

  /**
    * The event occurs when the dragged element is dropped on the drop target
    */
  def ondrop(callback: js.Function): Unit = js.native

}
