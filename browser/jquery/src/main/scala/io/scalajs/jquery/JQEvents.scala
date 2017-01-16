package io.scalajs.jquery

import io.scalajs.dom.Event

import scala.scalajs.js

/**
  * jQuery Events Functions
  * @author lawrence.daniels@gmail.com
  * @see http://www.w3schools.com/jquery/jquery_ref_events.asp
  */
@js.native
trait JQEvents extends js.Object {

  /**
    * The bind() method attaches one or more event handlers for selected elements, and specifies a function to
    * run when the event occurs.
    * @param event    Required. Specifies one or more events to attach to the elements.
    *                 Multiple event values are separated by space. Must be a valid event.
    * @param data     Optional. Specifies additional data to pass along to the function
    * @param function Required. Specifies the function to run when the event occurs
    * @param map      Specifies an event map ({event:function, event:function, ...})
    *                 containing one or more events to attach to the elements, and
    *                 functions to run when the event occurs
    */
  def bind(event: String, data: js.Any = js.native, function: js.Function, map: js.Any = js.native): this.type = js.native

  /**
    * Bind an event handler to the "blur" JavaScript event, or trigger that event on an element.
    * @param handler A function to execute each time the event is triggered.
    */
  def blur(handler: js.Function1[Event, Any] = js.native): this.type = js.native

  /**
    * Bind an event handler to the "blur" JavaScript event, or trigger that event on an element.
    * @param eventData An object containing data that will be passed to the event handler.
    * @param handler   A function to execute each time the event is triggered.
    */
  def blur(eventData: js.Any, handler: js.Function1[Event, Any]): this.type = js.native

  /**
    * Bind an event handler to the "change" JavaScript event, or trigger that event on an element.
    * @param callback A function to execute each time the event is triggered.
    */
  def change(callback: js.Function1[Event, Any] = js.native): this.type = js.native

  /**
    * The click event occurs when an element is clicked.
    * The click() method triggers the click event, or attaches a function to run when a click event occurs.
    * @param callback the callback/handler function
    */
  def click(callback: js.Function1[Event, Any] = js.native): this.type = js.native

  /**
    * Remove event handlers previously attached using .live() from the elements.
    */
  def die(): this.type = js.native

  /**
    * Remove event handlers previously attached using .live() from the elements.
    * @param eventType A string containing a JavaScript event type, such as click or keydown.
    * @param handler   The function that is no longer to be executed.
    */
  def die(eventType: String, handler: js.Function1[Event, Any] = js.native): this.type = js.native

  /**
    * A plain object of one or more event types, such as click or keydown and their corresponding functions
    * that are no longer to be executed.
    */
  def die(events: js.Any): this.type = js.native

  /**
    * Specify a function to execute when the DOM is fully loaded.
    * @param callback A function to execute after the DOM is ready.
    */
  def ready(callback: js.Function): this.type = js.native

}