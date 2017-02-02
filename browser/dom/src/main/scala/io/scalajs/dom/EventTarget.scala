package io.scalajs.dom

import io.scalajs.RawOptions

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * EventTarget is an interface implemented by objects that can receive events and may have listeners for them.
  *
  * Element, document, and window are the most common event targets, but other objects can be event targets too,
  * for example XMLHttpRequest, AudioNode, AudioContext, and others.
  *
  * Many event targets (including elements, documents, and windows) also support setting event handlers via on...
  * properties and attributes.
  * @see https://developer.mozilla.org/en-US/docs/Web/API/EventTarget
  */
@js.native
trait EventTarget extends js.Object {

  /**
    * Register an event handler of a specific event type on the EventTarget.
    * @param `type`   A string representing the event type to listen for.
    * @param listener The object that receives a notification (an object that implements the Event interface) when
    *                 an event of the specified type occurs. This must be an object implementing the EventListener
    *                 interface, or simply a JavaScript function.
    */
  def addEventListener(`type`: String, listener: js.Function): Unit = js.native

  /**
    * Register an event handler of a specific event type on the EventTarget.
    * @param `type`   A string representing the event type to listen for.
    * @param listener The object that receives a notification (an object that implements the Event interface) when
    *                 an event of the specified type occurs. This must be an object implementing the EventListener
    *                 interface, or simply a JavaScript function.
    * @param options  An options object that specifies characteristics about the event listener.
    */
  def addEventListener(`type`: String, listener: js.Function, options: EventTargetOptions | RawOptions): Unit =
    js.native

  /**
    * Register an event handler of a specific event type on the EventTarget.
    * @param `type`     A string representing the event type to listen for.
    * @param listener   The object that receives a notification (an object that implements the Event interface) when
    *                   an event of the specified type occurs. This must be an object implementing the EventListener
    *                   interface, or simply a JavaScript function.
    * @param useCapture A Boolean that indicates that events of this type will be dispatched to the registered listener
    *                   before being dispatched to any EventTarget beneath it in the DOM tree. Events that are bubbling
    *                   upward through the tree will not trigger a listener designated to use capture. Event bubbling
    *                   and capturing are two ways of propagating events that occur in an element that is nested within
    *                   another element, when both elements have registered a handle for that event. The event
    *                   propagation mode determines the order in which elements receive the event.
    *                   See DOM Level 3 Events and JavaScript Event order for a detailed explanation.
    *                   If not specified, useCapture defaults to false.
    */
  def addEventListener(`type`: String, listener: js.Function, useCapture: Boolean): Unit = js.native

  /**
    * Removes an event listener from the EventTarget.
    * @param `type`   A string representing the event type to remove.
    * @param listener The EventListener function to remove from the event target.
    * @param options  An options object that specifies characteristics about the event listener.
    */
  def removeEventListener(`type`: String, listener: js.Function, options: EventTargetOptions | RawOptions): Unit =
    js.native

  /**
    * Removes an event listener from the EventTarget.
    * @param `type`     A string representing the event type to remove.
    * @param listener   The EventListener function to remove from the event target.
    * @param useCapture Specifies whether the EventListener to be removed is registered as a capturing listener or not.
    *                   If this parameter is absent, a default value of false is assumed.
    *                   If a listener is registered twice, one with capture and one without, remove each one separately.
    *                   Removal of a capturing listener does not affect a non-capturing version of the same listener,
    *                   and vice versa.
    */
  def removeEventListener(`type`: String, listener: js.Function, useCapture: Boolean): Unit = js.native

  /**
    * Dispatch an event to this EventTarget.
    * @param event event is the Event object to be dispatched.
    * @return false if event is cancelable and at least one of the event handlers which handled this event
    *         called Event.preventDefault(). Otherwise it returns true.
    */
  def dispatchEvent(event: Event): Boolean = js.native

}
