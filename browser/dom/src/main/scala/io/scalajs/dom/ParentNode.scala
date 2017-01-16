package io.scalajs.dom

import io.scalajs.dom.collection.HTMLCollection

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * The ParentNode interface contains methods that are particular to Node objects that can have children.
  *
  * ParentNode is a raw interface and no object of this type can be created; it is implemented by
  * [[Element]], [[Document]], and [[DocumentFragment]] objects.
  * @see https://developer.mozilla.org/en-US/docs/Web/API/ParentNode
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ParentNode extends Node {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Returns a live [[HTMLCollection]] containing all objects of type [[Element]] that are children of this ParentNode.
    */
  def children: HTMLCollection[Element] = js.native

  /**
    * Returns the [[Element]] that is the first child of this ParentNode, or null if there is none.
    */
  def firstElementChild: Element = js.native

  /**
    * Returns the [[Element]] that is the last child of this ParentNode, or null if there is none.
    */
  def lastElementChild: Element = js.native

  /**
    * Returns an unsigned long giving the amount of children that the object has.
    */
  def childElementCount: UnsignedLong = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Inserts a set of Node objects or DOMString objects after the last child of the ParentNode.
    * DOMString objects are inserted as equivalent [[Text]] nodes.
    * @param nodes A set of Node or DOMString objects to insert.
    */
  def append(nodes: (Node | String)*): this.type = js.native

  /**
    * Inserts a set of Node objects or DOMString objects before the first child of the ParentNode.
    * DOMString objects are inserted as equivalent [[Text]] nodes.
    * @param nodes A set of Node or DOMString objects to insert.
    */
  def prepend(nodes: (Node | String)*): this.type = js.native

}
