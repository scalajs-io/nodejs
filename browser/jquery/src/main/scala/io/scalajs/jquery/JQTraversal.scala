package io.scalajs.jquery

import io.scalajs.dom.html.css.CSSSelector
import io.scalajs.dom.{Element, Node}

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * jQuery traversing, which means "move through", are used to "find" (or select) HTML elements based
  * on their relation to other elements. Start with one selection and move through that selection until
  * you reach the elements you desire.
  *
  * The image below illustrates a family tree. With jQuery traversing, you can easily move up (ancestors),
  * down (descendants) and sideways (siblings) in the family tree, starting from the selected (current) element.
  * This movement is called traversing - or moving through - the DOM.
  * @author lawrence.daniels@gmail.com
  * @see http://api.jquery.com/category/traversing/tree-traversal/
  * @see http://www.w3schools.com/jquery/jquery_ref_traversing.asp
  */
@js.native
trait JQTraversal extends js.Object {

  /**
    * The add() method adds elements to an existing group of elements.
    * @param element Required. Specifies a selector expression, a jQuery object, one or more elements
    *                or an HTML snippet to be added to an existing group of elements
    * @param context Optional. Specifies the point in the document at which the selector expression
    *                should begin matching
    * @return self reference
    */

  def add(element: Element | Selector | CSSSelector | js.Any, context: Element | js.Any = js.native): this.type = js.native

  /**
    * Add the previous set of elements on the stack to the current set, optionally filtered by a selector.
    * @param selector A string containing a selector expression to match the current set of elements against.
    * @return self reference
    */
  def addBack(selector: Selector = js.native): this.type = js.native

  /**
    * Get the children of each element in the set of matched elements, optionally filtered by a selector.
    * @param selector A string containing a selector expression to match elements against.
    * @return self reference
    */
  def children(selector: Selector = js.native): this.type = js.native

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
    * Get the closest ancestor element that is positioned.
    * @return self reference
    */
  def offsetParent(): this.type = js.native

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

  /** *
    * Get the siblings of each element in the set of matched elements, optionally filtered by a selector.
    * @param selector A string containing a selector expression to match elements against.
    * @return self reference
    */
  def siblings(selector: Selector = js.native): this.type = js.native

}
