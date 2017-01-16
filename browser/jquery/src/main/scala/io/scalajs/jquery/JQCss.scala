package io.scalajs.jquery

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * jQuery CSS Functions
  * @author lawrence.daniels@gmail.com
  * @see http://api.jquery.com/category/css/
  * @see http://www.w3schools.com/jquery/jquery_ref_html.asp
  */
@js.native
trait JQCss extends js.Object {

  /**
    * Adds one or more classes to the selected elements
    * @param className One or more space-separated classes to be added to the class attribute of each matched element.
    */
  def addClass(className: String | js.Function2[Int, String, String]): this.type = js.native

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
    * Get the current coordinates of the first element in the set of matched elements, relative to the document.
    * @return the current coordinates of the first element in the set of matched elements
    */
  def offset(): Coordinates = js.native

  /**
    * Set the current coordinates of every element in the set of matched elements, relative to the document.
    * @param coordinates An object containing the properties top and left, which are numbers indicating the
    *                    new top and left coordinates for the elements.
    */
  def offset(coordinates: Coordinates | js.Function | js.Any): this.type = js.native

  def outerHeight(): Integer = js.native

  def outerHeight(value: String | Double | js.Function): this.type = js.native

  def outerWidth(): Integer = js.native

  def outerWidth(value: String | Double | js.Function): this.type = js.native

  /**
    * Get the current coordinates of the first element in the set of matched elements, relative to the offset parent.
    * @return the current coordinates of the first element in the set of matched elements
    */
  def position(): Coordinates = js.native

  /**
    * Removes one or more classes from the selected elements
    */
  def removeClass(className: String | js.Function): this.type = js.native

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
    * @param state A boolean value to determine whether the class should be added or removed.
    */
  def toggleClass(className: String, state: Boolean | js.Function): this.type = js.native

  /**
    * Returns the width of an element (excludes padding, border and margin).
    * @return the width of an element
    */
  def width(): Integer = js.native

  /**
    * Sets the width of an element (excludes padding, border and margin).
    * @param value the desired width of an element
    */
  def width(value: String | Double): this.type = js.native

}
