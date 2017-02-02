package io.scalajs.jquery

import io.scalajs.JsNumber
import io.scalajs.dom.html.HTMLElement
import io.scalajs.dom.html.css.CSSSelector
import io.scalajs.dom.{Element, Event, Node}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSBracketAccess
import scala.scalajs.js.|

/**
  * JQuery Element
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait JQueryElement extends HTMLElement {

  ///////////////////////////////////////////////////////////////
  //    Properties
  ///////////////////////////////////////////////////////////////

  /**
    * TODO
    * @return
    */
  def checked: Boolean = js.native

  ///////////////////////////////////////////////////////////////
  //    Special Methods
  ///////////////////////////////////////////////////////////////

  /**
    * Retrieves the [[HTMLElement element]] at the given index
    * @param index the given index
    * @return the [[HTMLElement element]] or <tt>null</tt> if not found
    */
  @JSBracketAccess
  def apply(index: Int): this.type = js.native

  ///////////////////////////////////////////////////////////////
  //    Methods
  ///////////////////////////////////////////////////////////////

  /**
    * The add() method adds elements to an existing group of elements.
    * @param element Required. Specifies a selector expression, a jQuery object, one or more elements
    *                or an HTML snippet to be added to an existing group of elements
    * @param context Optional. Specifies the point in the document at which the selector expression
    *                should begin matching
    * @return self reference
    */
  def add(element: Element | Selector | CSSSelector | js.Any, context: Element | js.Any = js.native): this.type =
    js.native

  /**
    * Add the previous set of elements on the stack to the current set, optionally filtered by a selector.
    * @param selector A string containing a selector expression to match the current set of elements against.
    * @return self reference
    */
  def addBack(selector: Selector = js.native): this.type = js.native

  /**
    * Adds one or more classes to the selected elements
    * @param className One or more space-separated classes to be added to the class attribute of each matched element.
    */
  def addClass(className: String | js.Function2[Int, String, String]): this.type = js.native

  /**
    * Inserts content after the selected elements
    * @param content the specified content
    */
  def after(content: js.Any): this.type = js.native

  /**
    * The jQuery animate() method is used to create custom animations.
    * @param params   the given animation options / parameters
    * @param speed    The optional speed parameter can take the following values: "slow", "fast", or milliseconds.
    * @param callback The optional callback parameter is a function to be executed after toggle() completes.
    */
  def animate(params: AnimateOptions | js.Any,
              speed: String | JsNumber = js.native,
              callback: js.Function): this.type = js.native

  /**
    * Insert content, specified by the parameter, to the end of each element in the set of matched elements.
    * @param content the given HTML content
    */
  def append(content: String*): this.type = js.native

  /**
    * Inserts content at the end of the selected elements
    * @param content the specified content
    */
  def append(content: js.Any): this.type = js.native

  /**
    * Insert every element in the set of matched elements to the end of the target.
    * @param target A selector, element, HTML string, array of elements, or jQuery object; the matched set of
    *               elements will be inserted at the end of the element(s) specified by this parameter.
    */
  def appendTo(target: String | Element | js.Array[_ <: Element]): this.type = js.native

  /**
    * The jQuery attr() method is used to get attribute values.
    * @param name the name of the attribute to get
    * @return the attribute values.
    */
  def attr(name: String | js.Any): String = js.native

  /**
    * Get the value of an attribute for the first element in the set of matched elements or set one or more
    * attributes for every matched element.
    * @param attributeName the given attribute name
    */
  def attr(attributeName: String): this.type = js.native

  /**
    * The jQuery attr() method is also used to set/change attribute values.
    * @param name the name of the attribute to set
    */
  def attr(name: String, value: String | JsNumber): this.type = js.native

  /**
    * The jQuery attr() method is also used to set/change attribute values.
    * @param name the name of the attribute to set
    */
  def attr(name: String, function: js.Function2[Int, String, String]): this.type = js.native

  /**
    * Inserts content before the selected elements
    * @param content the specified content
    */
  def before(content: js.Any): this.type = js.native

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
  def bind(event: String, data: js.Any = js.native, function: js.Function, map: js.Any = js.native): this.type =
    js.native

  /**
    * Attach a handler to an event for the elements.
    * @param event         A string containing one or more DOM event types, such as "click" or "submit," or custom event names.
    * @param data          An object containing data that will be passed to the event handler.
    * @param preventBubble Setting the third argument to false will attach a function that prevents the default action
    *                      from occurring and stops the event from bubbling. The default is true.
    */
  def bind(event: String, data: js.Any, preventBubble: Boolean): this.type = js.native

  /**
    * Attach a handler to an event for the elements.
    * @param event A string containing one or more DOM event types, such as "click" or "submit," or custom event names.
    * @param data  An object containing data that will be passed to the event handler.
    */
  def bind(event: String, data: js.Any): this.type = js.native

  /**
    * Attach a handler to an event for the elements.
    * @param event         A string containing one or more DOM event types, such as "click" or "submit," or custom event names.
    * @param preventBubble Setting the third argument to false will attach a function that prevents the default action
    *                      from occurring and stops the event from bubbling. The default is true.
    */
  def bind(event: String, preventBubble: Boolean): this.type = js.native

  /**
    * Attach a handler to an event for the elements.
    * @param events An object containing one or more DOM event types and functions to execute for them.
    */
  def bind(events: js.Dictionary[js.Function]): this.type = js.native

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
    * Get the children of each element in the set of matched elements, optionally filtered by a selector.
    * @param selector A string containing a selector expression to match elements against.
    * @return self reference
    */
  def children(selector: Selector = js.native): this.type = js.native

  /**
    * Remove from the queue all items that have not yet been run.
    * @param queueName A string containing the name of the queue. Defaults to fx, the standard effects queue.
    */
  def clearQueue(queueName: String = js.native): this.type = js.native

  /**
    * The click event occurs when an element is clicked.
    * The click() method triggers the click event, or attaches a function to run when a click event occurs.
    * @param callback the callback/handler function
    */
  def click(callback: js.Function1[Event, Any] = js.native): this.type = js.native

  /**
    * Create a deep copy of the set of matched elements.
    * @param withDataAndEvents A Boolean indicating whether event handlers should be copied along with the elements.
    *                          As of jQuery 1.4, element data will be copied as well.
    */
  def clone(withDataAndEvents: Boolean = js.native): this.type = js.native

  /**
    * For each element in the set, get the first element that matches the selector by testing the element itself
    * and traversing up through its ancestors in the DOM tree.
    * @param selector A string containing a selector expression to match elements against
    * @param context  An element to match elements against.
    * @return self reference
    */
  def closest(selector: Selector, context: Element | js.Any = js.native): this.type = js.native

  /**
    * For each element in the set, get the first element that matches the selector by testing the element itself
    * and traversing up through its ancestors in the DOM tree.
    * @param element An element to match elements against.
    * @return self reference
    */
  def closest(element: Element): this.type = js.native

  /**
    * Get the children of each element in the set of matched elements, including text and comment nodes.
    */
  def contents(): this.type = js.native

  /**
    * Get the value of a computed style property for the first element in the set of matched elements
    * or set one or more CSS properties for every matched element.
    * @return the CSS style
    */
  def css(): String = js.native

  /**
    * Get the computed style properties for the first element in the set of matched elements.
    * @param propertyName A CSS property name.
    * @return the style property value
    */
  def css(propertyName: String): String = js.native

  /**
    * Get the computed style properties for the first element in the set of matched elements.
    * @param propertyNames An array of one or more CSS properties.
    * @return
    */
  def css(propertyNames: js.Array[String]): String = js.native

  /**
    * Sets or returns the style attribute
    * @param propertyName A CSS property name.
    * @param value        A value to set for the property.
    */
  def css(propertyName: String, value: String | Double): this.type = js.native

  /**
    * Store arbitrary data associated with the matched elements or return the value at the named data
    * store for the first element in the set of matched elements.
    * @param key   A string naming the piece of data to set.
    * @param value The new data value; this can be any Javascript type except undefined.
    */
  def data(key: String, value: js.Any): this.type = js.native

  /**
    * Store arbitrary data associated with the matched elements or return the value at the named data
    * store for the first element in the set of matched elements
    * @param obj An object of key-value pairs of data to update.
    */
  def data(obj: js.Object): this.type = js.native

  /**
    * Execute the next function on the queue for the matched elements.
    * @param queueName A string containing the name of the queue. Defaults to fx, the standard effects queue.
    */
  def dequeue(queueName: String = js.native): this.type = js.native

  /**
    * Remove the set of matched elements from the DOM (AngularJS 1.4).
    * @param selector A selector expression that filters the set of matched elements to be removed.
    */
  def detach(selector: js.Any = js.native): this.type = js.native

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
    * Removes the child elements from the selected element
    */
  def empty(): this.type = js.native

  /**
    * Reduce the set of matched elements to the one at the specified index (AngularJS 1.4).
    * @param index An integer indicating the position of the element, counting backwards from the last element in the set.
    */
  def eq(index: Int): this.type = js.native

  /**
    * The jQuery fadeIn() method is used to fade in a hidden element.
    * @param speed    The optional speed parameter can take the following values: "slow", "fast", or milliseconds.
    * @param callback The optional callback parameter is a function to be executed after toggle() completes.
    */
  def fadeIn(speed: String | Int = js.native, callback: js.Function = js.native): this.type = js.native

  /**
    * The jQuery fadeOut() method is used to fade out a visible element.
    * @param speed    The optional speed parameter can take the following values: "slow", "fast", or milliseconds.
    * @param callback The optional callback parameter is a function to be executed after toggle() completes.
    */
  def fadeOut(speed: String | Int = js.native, callback: js.Function = js.native): this.type = js.native

  /**
    * The jQuery fadeToggle() method toggles between the fadeIn() and fadeOut() methods.
    * @param speed    The optional speed parameter can take the following values: "slow", "fast", or milliseconds.
    * @param callback The optional callback parameter is a function to be executed after toggle() completes.
    */
  def fadeToggle(speed: String | Int = js.native, callback: js.Function = js.native): this.type = js.native

  /**
    * Get the descendants of each element in the current set of matched elements, filtered by a selector,
    * [[JQueryElement jQuery object]], or [[Element element]].
    * @param selector A string containing a selector expression to match elements against.
    * @return self reference
    */
  def find(selector: Selector): this.type = js.native

  /**
    * Get the descendants of each element in the current set of matched elements, filtered by a selector,
    * [[JQueryElement jQuery object]], or [[Element element]].
    * @param element An element or a jQuery object to match elements against.
    * @return self reference
    */
  def find(element: Element): this.type = js.native

  /**
    * Determine whether any of the matched elements are assigned the given class.
    * @param className The class name to search for.
    * @return true, if any of the matched elements are assigned the given class.
    */
  def hasClass(className: String): Boolean = js.native

  /**
    * Get the current computed height for the first element in the set of matched elements or
    * set the height of every matched element.
    * @return the height of an element
    */
  def height(): Integer = js.native

  /**
    * Sets the height of an element (excludes padding, border and margin).
    * @param value the given string, numeric or function value
    */
  def height(value: String | Double | js.Function): this.type = js.native

  /**
    * Shows an invisible HTML element
    * @param speed    The optional speed parameter can take the following values: "slow", "fast", or milliseconds.
    * @param callback The optional callback parameter is a function to be executed after toggle() completes.
    */
  def hide(speed: String | Int = js.native, callback: js.Function = js.native): this.type = js.native

  /**
    * Sets or returns the content of selected elements (including HTML markup)
    * @return the element
    */
  def html(): Element = js.native

  /**
    * Sets or returns the content of selected elements (including HTML markup)
    * @param element the element or value
    */
  def html(element: String | Element | js.Any): this.type = js.native

  /**
    * Get the current computed inner height (including padding but not border) for the first element
    * in the set of matched elements or set the inner height of every matched element.
    * @return the computed inner height
    */
  def innerHeight(): Integer = js.native

  /**
    * Set the CSS inner height of each element in the set of matched elements.
    * @param value the given string, numeric or function value
    */
  def innerHeight(value: String | Double | js.Function): this.type = js.native

  /**
    * Get the current computed inner width (including padding but not border) for the first element
    * in the set of matched elements or set the inner width of every matched element.
    * @return the computed inner width
    */
  def innerWidth(): Integer = js.native

  /**
    * Set the CSS inner width of each element in the set of matched elements.
    * @param value the given string, numeric or function value
    */
  def innerWidth(value: String | Double | js.Function): this.type = js.native

  /**
    * Check the current matched set of elements against a selector, element, or jQuery object and return true
    * if at least one of these elements matches the given arguments.
    * @param selector A string containing a selector expression to match elements against.
    * @return true if at least one of these elements matches the given arguments.
    */
  def is(selector: Selector): Boolean = js.native

  /**
    * Check the current matched set of elements against a selector, element, or jQuery object and return true
    * if at least one of these elements matches the given arguments.
    * @param function A function used as a test for every element in the set. It accepts two arguments, index,
    *                 which is the element's index in the jQuery collection, and element, which is the DOM element.
    *                 Within the function, this refers to the current DOM element.
    * @return true if at least one of these elements matches the given arguments.
    */
  def is(function: js.Function): Boolean = js.native

  /**
    * Get the immediately following sibling of each element in the set of matched elements. If a selector is provided,
    * it retrieves the next sibling only if it matches that selector.
    * @param selector A string containing a selector expression to match elements against.
    * @return self reference
    */
  def next(selector: Selector = js.native): this.type = js.native

  /**
    * Get all following siblings of each element in the set of matched elements, optionally filtered by a selector.
    * @param selector A string containing a selector expression to match elements against.
    * @return self reference
    */
  def nextAll(selector: Selector = js.native): this.type = js.native

  /**
    * Get all following siblings of each element up to but not including the element matched by the selector,
    * DOM node, or jQuery object passed.
    * @param selector A string containing a selector expression to indicate where to stop matching following sibling elements.
    * @param filter   A string containing a selector expression to match elements against.
    * @return self reference
    */
  def nextUntil(selector: Selector | Node = js.native, filter: String = js.native): this.type = js.native

  /**
    * Remove an event handler.
    * @param events   One or more space-separated event types and optional namespaces, or just namespaces,
    *                 such as "click", "keydown.myPlugin", or ".myPlugin".
    * @param selector A selector which should match the one originally passed to [[JQueryElement.on .on()]] when attaching event handlers.
    * @param handler  A handler function previously attached for the event(s), or the special value false.
    */
  def off(events: String, selector: String = js.native, handler: js.Function1[Event, Unit] = js.native): this.type =
    js.native

  /**
    * Get the current coordinates of the first element in the set of matched elements, relative to the document.
    * @return the current coordinates of the first element in the set of matched elements
    */
  def offset(): Coordinates = js.native

  /**
    * Set the current coordinates of every element in the set of matched elements, relative to the document.
    * @param coordinates An object containing the properties top and left, which are numbers indicating the
    *                    new top and left coordinates for the elements.
    */
  def offset(coordinates: Coordinates | js.Function | js.Object): this.type = js.native

  /**
    * Get the closest ancestor element that is positioned.
    * @return self reference
    */
  def offsetParent(): this.type = js.native

  /**
    * Attach an event handler function for one or more events to the selected elements.
    * @param events   One or more space-separated event types and optional namespaces, such as "click" or "keydown.myPlugin".
    * @param selector A selector string to filter the descendants of the selected elements that trigger the event.
    *                 If the selector is null or omitted, the event is always triggered when it reaches the selected element.
    * @param data     Data to be passed to the handler in event.data when an event is triggered.
    * @param handler  A function to execute when the event is triggered. The value false is also allowed as a shorthand
    *                 for a function that simply does return false.
    */
  def on(events: String,
         selector: String = js.native,
         data: js.Any = js.native,
         handler: js.Function = js.native): this.type = js.native

  /**
    * Attach a handler to an event for the elements. The handler is executed at most once per element per event type.
    * @param events  One or more space-separated event types and optional namespaces, such as "click" or "keydown.myPlugin".
    * @param data    Data to be passed to the handler in event.data when an event is triggered.
    * @param handler A function to execute at the time the event is triggered.
    */
  def one(events: String, data: js.Any = js.native, handler: js.Function1[Event, Unit] = js.native): this.type =
    js.native

  def outerHeight(): Integer = js.native

  def outerHeight(value: String | Double | js.Function): this.type = js.native

  def outerWidth(): Integer = js.native

  def outerWidth(value: String | Double | js.Function): this.type = js.native

  /**
    * Get the parent of each element in the current set of matched elements, optionally filtered by a selector.
    * @param selector A string containing a selector expression to match elements against.
    * @return self reference
    */
  def parent(selector: Selector = js.native): this.type = js.native

  /**
    * Get the ancestors of each element in the current set of matched elements, optionally filtered by a selector.
    * @param selector A string containing a selector expression to match elements against.
    * @return self reference
    */
  def parents(selector: Selector = js.native): this.type = js.native

  /**
    * Get the ancestors of each element in the current set of matched elements, up to but not including the
    * element matched by the selector, DOM node, or jQuery object.
    * @param selector Get the ancestors of each element in the current set of matched elements, up to but
    *                 not including the element matched by the selector, DOM node, or jQuery object.
    * @param filter   A string containing a selector expression to match elements against.
    * @return self reference
    */
  def parentsUntil(selector: Selector | Node = js.native, filter: String = js.native): this.type = js.native

  /**
    * Get the current coordinates of the first element in the set of matched elements, relative to the offset parent.
    * @return the current coordinates of the first element in the set of matched elements
    */
  def position(): Coordinates = js.native

  /**
    * Insert content, specified by the parameter, to the beginning of each element in the set of matched elements.
    * @param content One or more additional DOM elements, arrays of elements, HTML strings, or jQuery objects to
    *                insert at the beginning of each element in the set of matched elements.
    */
  def prepend(content: js.Any, content1: js.Any*): this.type = js.native

  /**
    * Insert content, specified by the parameter, to the beginning of each element in the set of matched elements.
    * @param fn A function that returns an HTML string, DOM element(s), or jQuery object to insert at the beginning
    *           of each element in the set of matched elements. Receives the index position of the element in the set
    *           and the old HTML value of the element as arguments. Within the function, this refers to the current
    *           element in the set.
    */
  def prepend(fn: js.Function): this.type = js.native

  /**
    * Inserts content at the beginning of the selected elements
    * @param content the specified content
    */
  def prepend(content: js.Any): this.type = js.native

  /**
    * Get the immediately preceding sibling of each element in the set of matched elements. If a selector is provided,
    * it retrieves the previous sibling only if it matches that selector.
    * @param selector A string containing a selector expression to match elements against.
    * @return self reference
    */
  def prev(selector: Selector = js.native): this.type = js.native

  /**
    * Get all preceding siblings of each element in the set of matched elements, optionally filtered by a selector.
    * @param selector A string containing a selector expression to match elements against.
    * @return self reference
    */
  def prevAll(selector: Selector = js.native): this.type = js.native

  /**
    * Get all preceding siblings of each element up to but not including the element matched by the selector,
    * DOM node, or jQuery object.
    * @param selector Get all preceding siblings of each element up to but not including the element matched
    *                 by the selector, DOM node, or jQuery object.
    * @return self reference
    */
  def prevUntil(selector: Selector | Node = js.native, filter: String = js.native): this.type = js.native

  /**
    * Get the value of a property for the first element in the set of matched elements (AngularJS 1.6).
    * @param propertyName The name of the property to get.
    * @return the property value
    */
  def prop[T <: js.Any](propertyName: String): T = js.native

  /**
    * Get the value of a property for the first element in the set of matched elements.
    * @param name The name of the property to get.
    */
  def prop(name: String): Boolean = js.native

  /**
    * Set one or more properties for the set of matched elements.
    * @param name The name of the property to set.
    * @param fn   A function returning the value to set. Receives the index position of the element in the set
    *             and the old property value as arguments. Within the function, the keyword this refers to the
    *             current element.
    */
  def prop(name: String, fn: js.Function2[Int, js.Any, Any]): this.type = js.native

  /**
    * Set one or more properties for the set of matched elements.
    * @param name  The name of the property to set.
    * @param value A value to set for the property.
    */
  def prop(name: String, value: js.Any): this.type = js.native

  /**
    * Show or manipulate the queue of functions to be executed on the matched elements.
    * @param queueName A string containing the name of the queue. Defaults to fx, the standard effects queue.
    */
  def queue(queueName: String = js.native): this.type = js.native

  /**
    * Specify a function to execute when the DOM is fully loaded.
    * @param callback A function to execute after the DOM is ready.
    */
  def ready(callback: js.Function): this.type = js.native

  /**
    * Remove the set of matched elements from the DOM.
    * @param selector A selector expression that filters the set of matched elements to be removed.
    */
  def remove(selector: Selector = js.native): this.type = js.native

  /**
    * Remove an attribute from each element in the set of matched elements.
    * @param attributeName An attribute to remove; as of AngularJS 1.7, it can be a space-separated list of attributes.
    */
  def removeAttr(attributeName: String): this.type = js.native

  /**
    * Remove a single class, multiple classes, or all classes from each element in the set of matched elements.
    * @param className One or more space-separated classes to be removed from the class attribute of each matched element.
    */
  def removeClass(className: String = js.native): this.type = js.native

  /**
    * Remove a single class, multiple classes, or all classes from each element in the set of matched elements (AngularJS 1.4).
    * @param fn A function returning one or more space-separated class names to be removed. Receives the index position
    *           of the element in the set and the old class value as arguments.
    */
  def removeClass(fn: js.Function): this.type = js.native

  /**
    * Remove a previously-stored piece of data.
    */
  def removeData(): this.type = js.native

  /**
    * Remove a previously-stored piece of data.
    * @param name A string naming the piece of data to delete.
    */
  def removeData(name: String): this.type = js.native

  /**
    * Remove a previously-stored piece of data.
    * @param list An array or space-separated string naming the pieces of data to delete.
    */
  def removeData(list: js.Array[String] = js.native): this.type = js.native

  /**
    * Replace each element in the set of matched elements with the provided new content
    * and return the set of elements that was removed.
    * @param newContent The content to insert. May be an HTML string, DOM element, array of DOM elements, or jQuery object.
    */
  def replaceWith(newContent: String | Element | js.Array[Element]): this.type = js.native

  /**
    * Replace each element in the set of matched elements with the provided new content
    * and return the set of elements that was removed.
    * @param fn A function that returns content with which to replace the set of matched elements.
    */
  def replaceWith(fn: js.Function): this.type = js.native

  /**
    * Get the current horizontal position of the scroll bar for the first element in the set of matched elements
    * or set the horizontal position of the scroll bar for every matched element.
    */
  def scrollLeft(): Integer = js.native

  /**
    * The horizontal scroll position is the same as the number of pixels that are hidden from view above the
    * scrollable area. Setting the scrollLeft positions the horizontal scroll of each matched element.
    * @param value An integer indicating the new position to set the scroll bar to.
    */
  def scrollLeft(value: Double): this.type = js.native

  /**
    * Get the current vertical position of the scroll bar for the first element in the set of matched elements or
    * set the vertical position of the scroll bar for every matched element.
    * @return the current vertical position of the scroll bar
    */
  def scrollTop(): Integer = js.native

  /**
    * Set the current vertical position of the scroll bar for each of the set of matched elements.
    * @param value A number indicating the new position to set the scroll bar to.
    */
  def scrollTop(value: Double): this.type = js.native

  /**
    * Hides a visible HTML element
    * @param speed    The optional speed parameter can take the following values: "slow", "fast", or milliseconds.
    * @param callback The optional callback parameter is a function to be executed after toggle() completes.
    */
  def show(speed: String | Int = js.native, callback: js.Function = js.native): this.type = js.native

  /**
    * Get the siblings of each element in the set of matched elements, optionally filtered by a selector.
    * @param selector A string containing a selector expression to match elements against.
    * @return self reference
    */
  def siblings(selector: Selector = js.native): this.type = js.native

  /**
    * The jQuery slideDown() method is used to slide down an element.
    * @param speed    The optional speed parameter can take the following values: "slow", "fast", or milliseconds.
    * @param callback The optional callback parameter is a function to be executed after toggle() completes.
    */
  def slideDown(speed: String | Int = js.native, callback: js.Function = js.native): this.type = js.native

  /**
    * The jQuery slideUp() method is used to slide up an element.
    * @param speed    The optional speed parameter can take the following values: "slow", "fast", or milliseconds.
    * @param callback The optional callback parameter is a function to be executed after toggle() completes.
    */
  def slideUp(speed: String | Int = js.native, callback: js.Function = js.native): this.type = js.native

  /**
    * The jQuery slideToggle() method toggles between the slideDown() and slideUp() methods.
    * @param speed    The optional speed parameter can take the following values: "slow", "fast", or milliseconds.
    * @param callback The optional callback parameter is a function to be executed after toggle() completes.
    */
  def slideToggle(speed: String | Int = js.native, callback: js.Function = js.native): this.type = js.native

  /**
    * Sets or returns the text content of selected elements
    * @return the value attribute of the selected elements.
    */
  def text(): String = js.native

  /**
    * Sets or returns the text content of selected elements
    * @param value the value attribute
    */
  def text(value: String | js.Any): this.type = js.native

  /**
    * Toggles between the hide() and show() methods.
    * @param speed    The optional speed parameter can take the following values: "slow", "fast", or milliseconds.
    * @param callback The optional callback parameter is a function to be executed after toggle() completes.
    */
  def toggle(speed: String | Int = js.native, callback: js.Function = js.native): this.type = js.native

  /**
    * Add or remove one or more classes from each element in the set of matched elements, depending on either the
    * class's presence or the value of the state argument.
    * @param className One or more class names (separated by spaces) to be toggled for each element in the matched set.
    */
  def toggleClass(className: String): this.type = js.native

  /**
    * Add or remove one or more classes from each element in the set of matched elements, depending on either the
    * class's presence or the value of the state argument.
    * @param handler the handler function
    */
  def toggleClass(handler: js.Function): this.type = js.native

  /**
    * Add or remove one or more classes from each element in the set of matched elements, depending on either the
    * class's presence or the value of the state argument.
    * @param className One or more class names (separated by spaces) to be toggled for each element in the matched set.
    * @param state     A boolean value to determine whether the class should be added or removed.
    */
  def toggleClass(className: String, state: Boolean | js.Function): this.type = js.native

  /**
    * Execute all handlers attached to an element for an event.
    * @param eventType       A string containing a JavaScript event type, such as click or submit; or an [[Event event]] object
    * @param extraParameters Additional parameters to pass along to the event handler.
    * @return an [[js.Object Object]]
    */
  def triggerHandler(eventType: String | Event, extraParameters: js.Any = js.native): js.Object = js.native

  /**
    * Remove a previously-attached event handler from the elements.
    */
  def unbind(): this.type = js.native

  /**
    * Remove a previously-attached event handler from the elements.
    * @param eventType A string containing a JavaScript event type, such as click or submit.
    */
  def unbind(eventType: String): this.type = js.native

  /**
    * Remove a previously-attached event handler from the elements.
    * @param eventType   A string containing a JavaScript event type, such as click or submit.
    * @param returnFalse Unbinds the corresponding 'return false' function that was bound using .bind( eventType, false ).
    */
  def unbind(eventType: String, returnFalse: Boolean): this.type = js.native

  /**
    * Remove a previously-attached event handler from the elements.
    * @param eventType A string containing a JavaScript event type, such as click or submit.
    * @param handler   The function that is to be no longer executed.
    */
  def unbind(eventType: String, handler: js.Function2[Int, String, String]): this.type = js.native

  /**
    * Remove a previously-attached event handler from the elements.
    * @param event A jQuery.Event object.
    */
  def unbind(event: Event): this.type = js.native

  /**
    * The val() method returns or sets the value attribute of the selected elements.
    * @return the value attribute of the selected elements.
    */
  def `val`(): js.Any = js.native

  /**
    * The val() method returns or sets the value attribute of the selected elements.
    * @param value the value attribute
    */
  def `val`(value: js.Any): this.type = js.native

  /**
    * Returns the width of an element (excludes padding, border and margin).
    * @return the width of an element
    */
  def width(): Integer = js.native

  /**
    * Sets the width of an element (excludes padding, border and margin).
    * @param value the desired width of an element
    */
  def width(value: String | JsNumber): this.type = js.native

  /**
    * Wrap an HTML structure around each element in the set of matched elements.
    * @param wrappingElement A selector, element, HTML string, or jQuery object specifying the structure
    *                        to wrap around the matched elements. When you pass a jQuery collection containing
    *                        more than one element, or a selector matching more than one element, the first
    *                        element will be used.
    */
  def wrap(wrappingElement: Selector | Element): this.type = js.native

  /**
    * Wrap an HTML structure around each element in the set of matched elements.
    * @param function A callback function returning the HTML content or jQuery object to wrap around the matched
    *                 elements. Receives the index position of the element in the set as an argument. Within the
    *                 function, this refers to the current element in the set.
    */
  def wrap(function: js.Function): this.type = js.native

}
