package io.scalajs.dom

import io.scalajs.dom.collection.NodeList

import scala.scalajs.js

/**
  * The DocumentFragment interface inherits from Node, and is a lightweight version of the [[Document]] interface,
  * intended for temporary storage of DOM structures. For example, it can be used as a temporary canvas for
  * building a group of nodes, or to store a group of nodes while moving it from one part of a document to another.
  *
  * Many node manipulation methods can take a document fragment as their argument (for example, appendChild), and this
  * results in the fragment's entire sub-tree being appended, but not the DocumentFragment itself — a document fragment
  * is a virtual construct, and never actually appears in a document.
  *
  * A DocumentFragment node can have [[Element]], [[ProcessingInstruction]], [[Comment]], [[Text]],
  * [[CDATASection]] and [[EntityReference]] nodes as children.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait DocumentFragment extends ParentNode {

  /**
    * Returns the first Element node within the DocumentFragment, in document order, that matches the specified ID.
    */
  def getElementById(id: String): Element = js.native

  /**
    * Returns the first Element node within the DocumentFragment, in document order, that matches the specified selectors.
    */
  def querySelector(selector: String): Element = js.native

  /**
    * Returns a NodeList of all the Element nodes within the DocumentFragment that match the specified selectors.
    */
  def querySelectorAll(selector: String): NodeList[Element] = js.native

}
