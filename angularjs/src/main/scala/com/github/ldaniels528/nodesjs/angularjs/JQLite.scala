package com.github.ldaniels528.nodesjs.angularjs

import com.github.ldaniels528.nodesjs.angularjs.core.Injector
import org.scalajs.dom._

import scala.scalajs.js

/**
 * JQuery Lite
 * @see [[https://docs.angularjs.org/api/ng/function/angular.element]]
 * @author lawrence.daniels@gmail.com
 */
@js.native
trait JQLite extends Element {

  /**
   * One or more space-separated classes to be added to the class attribute of each matched element.
   * @param className the given class name
   * @return the [[JQLite instance]]
   */
  def addClass(className: String): this.type

  /**
   * A function returning one or more space-separated class names to be added to the existing class name(s).
   * Receives the index position of the element in the set and the existing class name(s) as arguments.
   * Within the function, this refers to the current element in the set.
   * @param fn the given [[js.Function function]]
   * @return the [[JQLite instance]]
   * @see [[http://api.jquery.com/addClass/]]
   */
  def addClass(fn: js.Function2[Int, String, String]): this.type = js.native

  /**
   * A function returning one or more space-separated class names to be added to the existing class name(s).
   * Receives the index position of the element in the set and the existing class name(s) as arguments.
   * Within the function, this refers to the current element in the set.
   * @param fn the given [[js.Function function]]
   * @return the [[JQLite instance]]
   * @see [[http://api.jquery.com/addClass/]]
   */
  def addClass(fn: js.Function1[Int, String]): this.type = js.native

  /**
   * Insert content, specified by the parameter, after each element in the set of matched elements.
   * @param content the given HTML content
   * @return the [[JQLite instance]]
   */
  def after(content: String*): this.type = js.native

  /**
   * Insert content, specified by the parameter, to the end of each element in the set of matched elements.
   * @param content the given HTML content
   * @return the [[JQLite instance]]
   */
  def append(content: String*): this.type = js.native

  /**
   * Get the value of an attribute for the first element in the set of matched elements or set one or more
   * attributes for every matched element.
   * @param attributeName the given attribute name
   * @return the [[JQLite instance]]
   */
  def attr(attributeName: String): this.type = js.native

  /**
   * Attach a handler to an event for the elements.
   * @param eventType A string containing one or more DOM event types, such as "click" or "submit," or custom event names.
   * @param eventData An object containing data that will be passed to the event handler.
   * @param handler A function to execute each time the event is triggered.
   * @return the [[JQLite instance]]
   */
  def bind(eventType: String, eventData: js.Any, handler: js.Function1[Event, Unit]): this.type = js.native

  /**
   * Attach a handler to an event for the elements.
   * @param eventType A string containing one or more DOM event types, such as "click" or "submit," or custom event names.
   * @param eventData An object containing data that will be passed to the event handler.
   * @param preventBubble Setting the third argument to false will attach a function that prevents the default action
   *                      from occurring and stops the event from bubbling. The default is true.
   * @return the [[JQLite instance]]
   */
  def bind(eventType: String, eventData: js.Any = js.native, preventBubble: Boolean): this.type = js.native

  /**
   * Attach a handler to an event for the elements.
   * @param eventType A string containing one or more DOM event types, such as "click" or "submit," or custom event names.
   * @param eventData An object containing data that will be passed to the event handler.
   * @return the [[JQLite instance]]
   */
  def bind(eventType: String, eventData: js.Any): this.type = js.native

  /**
   * Attach a handler to an event for the elements.
   * @param events An object containing one or more DOM event types and functions to execute for them.
   * @return the [[JQLite instance]]
   */
  def bind(events: js.Object): this.type = js.native

  /**
   * Get the children of each element in the set of matched elements, optionally filtered by a selector.
   * @param selector A string containing a selector expression to match elements against.
   * @return the [[JQLite instance]]
   */
  def children(selector: String = js.native): this.type = js.native

  /**
   * Create a deep copy of the set of matched elements.
   * @param withDataAndEvents A Boolean indicating whether event handlers should be copied along with the elements.
   *                          As of jQuery 1.4, element data will be copied as well.
   * @return the [[JQLite instance]]
   */
  def clone(withDataAndEvents: Boolean = js.native): this.type = js.native

  /**
   * Get the children of each element in the set of matched elements, including text and comment nodes.
   * @return a [[JQLite JQuery instance]]
   */
  def contents(): JQLite = js.native

  /**
   * Get the value of a computed style property for the first element in the set of matched elements
   * or set one or more CSS properties for every matched element.
   * @return the [[JQLite instance]]
   */
  def css(): String = js.native

  /**
   * Get the computed style properties for the first element in the set of matched elements.
   * @param propertyName A CSS property.
   * @return the [[JQLite instance]]
   */
  def css(propertyName: String): String = js.native

  /**
   * Get the computed style properties for the first element in the set of matched elements.
   * @param propertyNames An array of one or more CSS properties.
   * @return the [[JQLite instance]]
   */
  def css(propertyNames: js.Array[String]): String = js.native

  /**
   * Store arbitrary data associated with the matched elements or return the value at the named data
   * store for the first element in the set of matched elements.
   * @param key A string naming the piece of data to set.
   * @param value The new data value; this can be any Javascript type except undefined.
   * @return a [[JQLite JQuery instance]]
   */
  def data(key: String, value: js.Any): JQLite = js.native

  /**
   * Store arbitrary data associated with the matched elements or return the value at the named data
   * store for the first element in the set of matched elements
   * @param obj An object of key-value pairs of data to update.
   * @return a [[JQLite JQuery instance]]
   */
  def data(obj: js.Object): JQLite = js.native

  /**
   * Remove the set of matched elements from the DOM (AngularJS 1.4).
   * @param selector A selector expression that filters the set of matched elements to be removed.
   * @return the [[JQLite instance]]
   */
  def detach(selector: js.Any = js.native): this.type = js.native

  /**
   * Remove all child nodes of the set of matched elements from the DOM (AngularJS 1.0).
   * @return the [[JQLite instance]]
   */
  def empty(): this.type = js.native

  /**
   * Reduce the set of matched elements to the one at the specified index (AngularJS 1.4).
   * @param index An integer indicating the position of the element, counting backwards from the last element in the set.
   * @return the [[JQLite instance]]
   */
  def eq(index: Int): this.type = js.native

  /**
   * Get the descendants of each element in the current set of matched elements,
   * filtered by a selector, jQuery object, or element.
   * @param selector A string containing a selector expression to match elements against.
   * @return the [[JQLite instance]]
   */
  def find(selector: String): this.type = js.native

  /**
   * Get the descendants of each element in the current set of matched elements,
   * filtered by a selector, jQuery object, or element.
   * @param element An element or a jQuery object to match elements against.
   * @return the [[JQLite instance]]
   */
  def find(element: Element): this.type = js.native

  /**
   * Get the descendants of each element in the current set of matched elements,
   * filtered by a selector, jQuery object, or element.
   * @param element An element or a jQuery object to match elements against.
   * @return the [[JQLite instance]]
   */
  def find(element: JQLite): this.type = js.native

  /**
   * Determine whether any of the matched elements are assigned the given class.
   * @param className The class name to search for.
   * @return true, if any of the matched elements are assigned the given class.
   */
  def hasClass(className: String): Boolean = js.native

  /**
   * Get the HTML contents of the first element in the set of matched elements.
   * @return the HTML contents
   */
  def html(): String = js.native

  /**
    * Get the HTML contents of the first element in the set of matched elements.
    * @param element the given element
    * @return the HTML contents
    */
  def html(element: js.Any): String = js.native

  /**
   * Get the immediately following sibling of each element in the set of matched elements.
   * If a selector is provided, it retrieves the next sibling only if it matches that selector.
   * @param selector A string containing a selector expression to match elements against.
   * @return the [[JQLite instance]]
   */
  def next(selector: String = js.native): this.type = js.native

  /**
   * Attach an event handler function for one or more events to the selected elements.
   * @param events One or more space-separated event types and optional namespaces, such as "click" or "keydown.myPlugin".
   * @param selector A selector string to filter the descendants of the selected elements that trigger the event.
   *                 If the selector is null or omitted, the event is always triggered when it reaches the selected element.
   * @param data Data to be passed to the handler in event.data when an event is triggered.
   * @param handler A function to execute when the event is triggered. The value false is also allowed as a shorthand
   *                for a function that simply does return false.
   * @return the [[JQLite instance]]
   */
  def on(events: String, selector: String = js.native, data: js.Any = js.native, handler: js.Function = js.native): this.type = js.native

  /**
   * Remove an event handler.
   * @param events One or more space-separated event types and optional namespaces, or just namespaces,
   *               such as "click", "keydown.myPlugin", or ".myPlugin".
   * @param selector A selector which should match the one originally passed to [[JQLite.on .on()]] when attaching event handlers.
   * @param handler A handler function previously attached for the event(s), or the special value false.
   * @return the [[JQLite instance]]
   */
  def off(events: String, selector: String = js.native, handler: js.Function1[Event, Unit] = js.native): this.type = js.native

  /**
   * Attach a handler to an event for the elements. The handler is executed at most once per element per event type.
   * @param events One or more space-separated event types and optional namespaces, such as "click" or "keydown.myPlugin".
   * @param data Data to be passed to the handler in event.data when an event is triggered.
   * @param handler A function to execute at the time the event is triggered.
   * @return the [[JQLite instance]]
   */
  def one(events: String, data: js.Any = js.native, handler: js.Function1[Event, Unit] = js.native): this.type = js.native

  /**
   * Get the parent of each element in the current set of matched elements, optionally filtered by a selector.
   * @param selector A string containing a selector expression to match elements against.
   * @return the [[JQLite instance]]
   */
  def parent(selector: String = js.native): this.type = js.native

  /**
   * Insert content, specified by the parameter, to the beginning of each element in the set of matched elements.
   * @param content One or more additional DOM elements, arrays of elements, HTML strings, or jQuery objects to
   *                insert at the beginning of each element in the set of matched elements.
   * @return the [[JQLite instance]]
   */
  def prepend(content: js.Any, content1: js.Any*): this.type = js.native

  /**
   * Insert content, specified by the parameter, to the beginning of each element in the set of matched elements.
   * @param fn A function that returns an HTML string, DOM element(s), or jQuery object to insert at the beginning
   *           of each element in the set of matched elements. Receives the index position of the element in the set
   *           and the old HTML value of the element as arguments. Within the function, this refers to the current
   *           element in the set.
   * @return the [[JQLite instance]]
   */
  def prepend(fn: js.Function): this.type = js.native

  /**
   * Get the value of a property for the first element in the set of matched elements (AngularJS 1.6).
   * @param propertyName The name of the property to get.
   * @return the property value
   */
  def prop[T <: js.Any](propertyName: String): T = js.native

  /**
   * Set one or more properties for the set of matched elements.
   * @param propertyName The name of the property to set.
   * @param value A value to set for the property.
   * @return the [[JQLite instance]]
   */
  def prop(propertyName: String, value: js.Any): this.type = js.native

  /**
   * Specify a function to execute when the DOM is fully loaded.
   * @param handler A function to execute after the DOM is ready.
   * @return the [[JQLite instance]]
   */
  def ready(handler: js.Function): this.type = js.native

  /**
   * Remove the set of matched elements from the DOM.
   * @param selector A selector expression that filters the set of matched elements to be removed.
   * @return the [[JQLite instance]]
   */
  def remove(selector: String): this.type = js.native

  /**
   * Remove an attribute from each element in the set of matched elements.
   * @param attributeName An attribute to remove; as of AngularJS 1.7, it can be a space-separated list of attributes.
   * @return the [[JQLite instance]]
   */
  def removeAttr(attributeName: String): this.type = js.native

  /**
   * Remove a single class, multiple classes, or all classes from each element in the set of matched elements.
   * @param className One or more space-separated classes to be removed from the class attribute of each matched element.
   * @return the [[JQLite instance]]
   */
  def removeClass(className: String = js.native): this.type = js.native

  /**
   * Remove a single class, multiple classes, or all classes from each element in the set of matched elements (AngularJS 1.4).
   * @param fn A function returning one or more space-separated class names to be removed. Receives the index position
   *           of the element in the set and the old class value as arguments.
   * @return the [[JQLite instance]]
   */
  def removeClass(fn: js.Function): this.type = js.native

  /**
   * Remove a previously-stored piece of data.
   * @return the [[JQLite instance]]
   */
  def removeData(): this.type = js.native

  /**
   * Remove a previously-stored piece of data.
   * @param name A string naming the piece of data to delete.
   * @return the [[JQLite instance]]
   */
  def removeData(name: String): this.type = js.native

  /**
   * Remove a previously-stored piece of data.
   * @param list An array or space-separated string naming the pieces of data to delete.
   * @return the [[JQLite instance]]
   */
  def removeData(list: js.Array[String] = js.native): this.type = js.native

  /**
   * Replace each element in the set of matched elements with the provided new content
   * and return the set of elements that was removed.
   * @param newContent The content to insert. May be an HTML string, DOM element, array of DOM elements, or jQuery object.
   * @return the [[JQLite instance]]
   */
  def replaceWith(newContent: js.Any): this.type = js.native

  /**
   * Replace each element in the set of matched elements with the provided new content
   * and return the set of elements that was removed.
   * @param fn A function that returns content with which to replace the set of matched elements.
   * @return the [[JQLite instance]]
   */
  def replaceWith(fn: js.Function): this.type = js.native

  /**
   * Get the combined text contents of each element in the set of matched elements, including their descendants.
   * @return the [[JQLite instance]]
   */
  def text(): String = js.native

  /**
   * Set the content of each element in the set of matched elements to the specified tex
   * @param text The text to set as the content of each matched element. When Number or Boolean is supplied,
   *             it will be converted to a String representation.
   * @return the [[JQLite instance]]
   */
  def text(text: js.Any): this.type = js.native

  /**
   * Set the content of each element in the set of matched elements to the specified tex
   * @param fn A function returning the text content to set. Receives the index position of the element
   *           in the set and the old text value as arguments.
   * @return the [[JQLite instance]]
   */
  def text(fn: js.Function): this.type = js.native

  /**
   * Add or remove one or more classes from each element in the set of matched elements,
   * depending on either the class's presence or the value of the state argument.
   * @param className One or more class names (separated by spaces) to be toggled for each element in the matched set.
   * @return the [[JQLite instance]]
   */
  def toggleClass(className: String): this.type = js.native

  /**
   * Add or remove one or more classes from each element in the set of matched elements,
   * depending on either the class's presence or the value of the state argument.
   * @param className One or more class names (separated by spaces) to be toggled for each element in the matched set.
   * @param state A Boolean (not just truthy/falsy) value to determine whether the class should be added or removed.
   * @return the [[JQLite instance]]
   */
  def toggleClass(className: String, state: Boolean): this.type = js.native

  /**
   * Add or remove one or more classes from each element in the set of matched elements,
   * depending on either the class's presence or the value of the state argument.
   * @param state A Boolean (not just truthy/falsy) value to determine whether the class should be added or removed.
   * @return the [[JQLite instance]]
   */
  def toggleClass(state: Boolean): this.type = js.native

  /**
   * Add or remove one or more classes from each element in the set of matched elements,
   * depending on either the class's presence or the value of the state argument.
   * @param fn A function that returns class names to be toggled in the class attribute of each element
   *           in the matched set. Receives the index position of the element in the set, the old class
   *           value, and the state as arguments.
   * @return the [[JQLite instance]]
   */
  def toggleClass(fn: js.Function): this.type = js.native

  /**
   *
   * @param fn A function that returns class names to be toggled in the class attribute of each element
   *           in the matched set. Receives the index position of the element in the set, the old class
   *           value, and the state as arguments.
   * @param state A Boolean (not just truthy/falsy) value to determine whether the class should be added or removed.
   * @return the [[JQLite instance]]
   */
  def toggleClass(fn: js.Function, state: Boolean): this.type = js.native

  /**
   * Execute all handlers attached to an element for an event.
   * @param eventType A string containing a JavaScript event type, such as click or submit.
   * @return an [[js.Object Object]]
   */
  def triggerHandler(eventType: String): js.Object = js.native

  /**
   * Execute all handlers attached to an element for an event.
   * @param eventType A string containing a JavaScript event type, such as click or submit.
   * @param extraParameters Additional parameters to pass along to the event handler.
   * @return an [[js.Object Object]]
   */
  def triggerHandler(eventType: String, extraParameters: js.Any): js.Object = js.native

  /**
   * Execute all handlers attached to an element for an event.
   * @param event A jQuery.Event object.
   * @return an [[js.Object Object]]
   */
  def triggerHandler(event: Event): js.Object = js.native

  /**
   * Execute all handlers attached to an element for an event.
   * @param event A jQuery.Event object.
   * @param extraParameters Additional parameters to pass along to the event handler.
   * @return an [[js.Object Object]]
   */
  def triggerHandler(event: Event, extraParameters: js.Any): js.Object = js.native

  /**
   * Remove a previously-attached event handler from the elements.
   * @return the [[JQLite instance]]
   */
  def unbind(): this.type = js.native

  /**
   * Remove a previously-attached event handler from the elements.
   * @param eventType A string containing a JavaScript event type, such as click or submit.
   * @return the [[JQLite instance]]
   */
  def unbind(eventType: String): this.type = js.native

  /**
   * Remove a previously-attached event handler from the elements.
   * @param eventType A string containing a JavaScript event type, such as click or submit.
   * @param returnFalse Unbinds the corresponding 'return false' function that was bound using .bind( eventType, false ).
   * @return the [[JQLite instance]]
   */
  def unbind(eventType: String, returnFalse: Boolean): this.type = js.native

  /**
   * Remove a previously-attached event handler from the elements.
   * @param eventType A string containing a JavaScript event type, such as click or submit.
   * @param handler The function that is to be no longer executed.
   * @return the [[JQLite instance]]
   */
  def unbind(eventType: String, handler: js.Function2[Int, String, String]): this.type = js.native

  /**
   * Remove a previously-attached event handler from the elements.
   * @param event A jQuery.Event object.
   * @return the [[JQLite instance]]
   */
  def unbind(event: Event): this.type = js.native

  /**
   * Get the current value of the first element in the set of matched elements or set the value of every matched element.
   * @return the [[js.Any value]]
   */
  def `val`(): this.type = js.native

  /**
   * Set the value of each element in the set of matched elements.
   * @param value A string of text, a number, or an array of strings corresponding to the value of
   *              each matched element to set as selected/checked.
   * @return the [[JQLite instance]]
   */
  def `val`(value: js.Any): this.type = js.native

  /**
   * Set the value of each element in the set of matched elements.
   * @param fn A function returning the value to set. this is the current element.
   *           Receives the index position of the element in the set and the old value as arguments.
   * @return the [[JQLite instance]]
   */
  def `val`(fn: js.Function2[Int, String, String]): this.type = js.native

  /**
   * Wrap an HTML structure around each element in the set of matched elements.
   * @param wrappingElement A selector, element, HTML string, or jQuery object specifying the structure to wrap
   *                        around the matched elements. When you pass a jQuery collection containing more than
   *                        one element, or a selector matching more than one element, the first element will be used.
   * @return the [[JQLite instance]]
   */
  def wrap(wrappingElement: js.Any): this.type = js.native

  /**
   * Wrap an HTML structure around each element in the set of matched elements.
   * @param fn A callback function returning the HTML content or jQuery object to wrap around the matched elements.
   *           Receives the index position of the element in the set as an argument. Within the function,
   *           this refers to the current element in the set.
   * @return the [[JQLite instance]]
   */
  def wrap(fn: js.Function): this.type = js.native

  ////////////////////////////////////////////////////////////////////////
  //  jQuery/jqLite Extras
  ////////////////////////////////////////////////////////////////////////

  /**
   * Retrieves the controller of the current element or its parent. By default retrieves controller associated
   * with the ngController directive. If name is provided as camelCase directive name, then the controller for
   * this directive will be retrieved
   * @param name the name of the controller
   * @return the [[js.Object controller]] instance
   */
  def controller[T <: js.Object](name: String = js.native): T = js.native

  /**
   * Retrieves the injector of the current element or its parent.
   * @return the [[Injector injector]]
   */
  def injector(): Injector = js.native

  /**
   * Retrieves the scope of the current element or its parent. Requires Debug Data to be enabled.
   * @return the [[Scope scope]]
   */
  def scope(): Scope = js.native

  /**
   * Retrieves an isolate scope if one is attached directly to the current element. This getter should be used
   * only on elements that contain a directive which starts a new isolate scope. Calling scope() on this element
   * always returns the original non-isolate scope. Requires Debug Data to be enabled.
   * @return the [[Scope scope]]
   */
  def isolateScope(): Scope = js.native

  /**
   * Same as data(), but walks up the DOM until a value is found or the top parent element is reached.
   * @param key the given key
   * @param value the given value
   * @return the [[JQLite instance]]
   */
  def inheritedData(key: String, value: js.Any): JQLite = js.native

  def inheritedData(obj: js.Object): JQLite = js.native

  def inheritedData[T <: js.Any](key: String): js.UndefOr[T] = js.native

  def inheritedData(): js.Any = js.native

}

