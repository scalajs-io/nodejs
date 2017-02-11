package io.scalajs.dom.collection

import io.scalajs.collection.JsCollection
import io.scalajs.dom.Attr

import scala.scalajs.js
import scala.scalajs.js.annotation.JSBracketAccess

/**
  * The NamedNodeMap interface represents a collection of [[Attr]] objects. Objects inside a NamedNodeMap
  * are not in any particular order, unlike [[NodeList]], although they may be accessed by an index as
  * in an array.
  *
  * A NamedNodeMap object is live and will thus be auto-updated if changes are made to its contents
  * internally or elsewhere.
  * @see https://developer.mozilla.org/en-US/docs/Web/API/NamedNodeMap
  * @author lawrence.daniels@gmail.com
  */
@js.native
class NamedNodeMap[A] extends JsCollection[A] {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Returns the number of attribute nodes in a NamedNodeMap
    */
  override def length: Int = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Returns the element at the specified index
    * @param index the specified index
    * @return the [[A element]] at the specified index
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
    * Returns a specified attribute node from a NamedNodeMap
    */
  def getNamedItem(name: String): A = js.native

  /**
    * Returns a specified attribute node from a NamedNodeMap
    * @example document.documentElement.attributes.getNamedItemNS('http://www.w3.org/XML/1998/namespace', 'lang');
    */
  def getNamedItemNS(namespace: String, name: String): A = js.native

  /**
    * Returns the attribute node at a specified index in a NamedNodeMap
    */
  def item(index: Int): A = js.native

  /**
    * Removes a specified attribute node
    */
  def removeNamedItem(name: String): A = js.native

  /**
    * Removes a specified attribute node
    * @example attrs.removeNamedItemNS('http://www.w3.org/1999/xhtml', 'lang')
    */
  def removeNamedItemNS(namespace: String, name: String): A = js.native

  /**
    * Sets the specified attribute node (by name)
    */
  def setNamedItem(name: String): Unit = js.native

  /**
    * Sets the specified attribute node (by name)
    * @example document.setNamedItemNS('http://www.w3.org/XML/1998/namespace', 'lang')
    */
  def setNamedItemNS(namespace: String, name: String): Unit = js.native

}

/**
  * NamedNodeMap Companion
  * @author lawrence.daniels@gmail.com
  */
object NamedNodeMap {

  /**
    * NamedNodeMap Enrichment
    * @param collection the given [[NamedNodeMap]]
    */
  implicit class NamedNodeMapEnrichment[T](val collection: NamedNodeMap[T]) extends AnyVal {

    @inline
    def get(name: String): Option[T] = Option(collection(name))

  }

}