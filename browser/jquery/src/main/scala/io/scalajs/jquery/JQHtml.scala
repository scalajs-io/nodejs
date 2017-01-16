package io.scalajs.jquery

import io.scalajs.dom.Element

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * jQuery DOM/HTML Functions
  * @author lawrence.daniels@gmail.com
  * @see http://www.w3schools.com/jquery/jquery_ref_html.asp
  */
@js.native
trait JQHtml extends js.Object {

  /**
    * Inserts content after the selected elements
    * @param content the specified content
    */
  def after(content: js.Any): this.type = js.native

  /**
    * Inserts content at the end of the selected elements
    * @param content the specified content
    */
  def append(content: js.Any): this.type = js.native

  /**
    * The jQuery attr() method is used to get attribute values.
    * @param name the name of the attribute to get
    * @return the attribute values.
    */
  def attr(name: String | js.Any): String = js.native

  /**
    * The jQuery attr() method is also used to set/change attribute values.
    * @param name the name of the attribute to set
    */
  def attr(name: String, value: String | Int): this.type = js.native

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
    * TODO
    * @return
    */
  def checked: Boolean = js.native

  /**
    * Removes the child elements from the selected element
    */
  def empty(): this.type = js.native

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
    * Inserts content at the beginning of the selected elements
    * @param content the specified content
    */
  def prepend(content: js.Any): this.type = js.native

  /**
    * TODO
    * @param name
    * @return
    */
  def prop(name: String): Boolean = js.native

  def prop(name: String, value: js.Any): this.type = js.native

  /**
    * Removes the selected element (and its child elements)
    */
  def remove(): this.type = js.native

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
