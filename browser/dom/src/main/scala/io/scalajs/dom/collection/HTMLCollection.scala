package io.scalajs.dom.collection

import io.scalajs.collection.JsCollection

import scala.scalajs.js
import scala.scalajs.js.annotation.JSBracketAccess

/**
  * The HTMLCollection interface represents a generic collection (array-like object similar to arguments)
  * of elements (in document order) and offers methods and properties for selecting from the list.
  * @see https://developer.mozilla.org/en-US/docs/Web/API/HTMLCollection
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait HTMLCollection[A] extends JsCollection[A] {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Returns the number of items in the collection.
    */
  override def length: Int = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Returns the specific node at the given zero-based index into the list. Returns null if the index is out of range.
    * @param index The position of the Node to be returned. Elements appear in an HTMLCollection in the same order
    *              in which they appear in the document source.
    * @return the specific node
    */
  @JSBracketAccess
  override def apply(index: Int): A = js.native

  /**
    * Returns the specific node whose ID or, as a fallback, name matches the string specified by name. Matching by name
    * is only done as a last resort, only in HTML, and only if the referenced element supports the name attribute.
    * Returns null if no node exists by the given name.
    * @param name the specified name of the node
    * @return the specific node
    */
  @JSBracketAccess
  def apply(name: String): A = js.native

  /**
    * Set the element at the given index.
    * @param index the position of the Node to be set.
    * @param value the value to set.
    */
  @JSBracketAccess
  def update(index: Int, value: A): Unit = js.native

  /**
    * Returns the specific node at the given zero-based index into the list. Returns null if the index is out of range.
    * @param index The position of the Node to be returned. Elements appear in an HTMLCollection in the same order
    *              in which they appear in the document source.
    * @return the specific node
    */
  def item(index: Int): A = js.native

  /**
    * Returns the specific node whose ID or, as a fallback, name matches the string specified by name. Matching by name
    * is only done as a last resort, only in HTML, and only if the referenced element supports the name attribute.
    * Returns null if no node exists by the given name.
    * @param name the specified name of the node
    * @return the specific node
    */
  def namedItem(name: String): A = js.native

}
