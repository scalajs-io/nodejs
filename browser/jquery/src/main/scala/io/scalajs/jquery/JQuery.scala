package io.scalajs.jquery

import io.scalajs.dom.Node

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * JQuery
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait JQuery extends js.Object {

  /**
    * Hook directly into jQuery to override how particular CSS properties are retrieved or set,
    * normalize CSS property naming, or create custom properties.
    */
  var cssHooks: CssHooksOptions = js.native

  /**
    * An object containing all CSS properties that may be used without a unit. The .css() method uses
    * this object to see if it may append px to unitless values.
    */
  var cssNumber: CssNumberOptions = js.native

  /**
    * Retrieves the jQuery object for the given document
    * @param node the given [[Node node]]
    * @return the [[JQueryElement jQuery element]]
    */
  def apply(node: Node): JQueryElement = js.native

  /**
    * Retrieves the jQuery object for the given selector
    * @param selector A string containing a selector expression to match elements against.
    * @return the [[JQueryElement jQuery element]]
    */
  def apply(selector: Selector): JQueryElement = js.native

  /**
    * Get the HTML contents of the first element in the set of matched elements or set the HTML contents of
    * every matched element.
    */
  def html(): String = js.native

  /**
    * Get the HTML contents of the first element in the set of matched elements or set the HTML contents of
    * every matched element.
    * @param htmlString A string of HTML to set as the content of each matched element.
    */
  def html(htmlString: String): String = js.native

  /**
    * Get the HTML contents of the first element in the set of matched elements or set the HTML contents of
    * every matched element.
    * @param fn A function returning the HTML content to set. Receives the index position of the element in the set
    *           and the old HTML value as arguments. jQuery empties the element before calling the function; use
    *           the oldhtml argument to reference the previous content. Within the function, this refers to the
    *           current element in the set.
    */
  def html(fn: js.Function2[Int, String, String]): String = js.native

}

/**
  * JQuery Companion
  * @author lawrence.daniels@gmail.com
  */
object JQuery {

  @js.native
  @JSName("$")
  object $ extends JQuery

}