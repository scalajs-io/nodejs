package io.scalajs.dom

import scala.scalajs.js

/**
  * The Attr interface inherits from Node and represents a single attribute of an Element node.
  *
  * However the Attr interface is a special case in terms of inheritance — attribute nodes are not child nodes of
  * the element they belong to, and have no parent or sibling nodes, so although inherited Node properties such as
  * parentNode and nextSibling are available, they always return null. Attributes are considered by the DOM to be
  * properties of elements, rather than objects in their own right.
  * @author lawrence.daniels@gmail.com
  */
@js.native
class Attr extends Node {

  /**
    * The name of an Attr. This is the name part of a name="value" pair.
    *
    * For a namespaced attribute, the name property returns a qualified name1.
    * This property is read-only.
    */
  def name: String = js.native

  /**
    * The Element node that an Attr node is attached to; or null if it's not attached (for example, if it's been
    * created with createAttribute but not yet added to an element).
    * This property is read-only.
    * @return
    */
  def ownerElement: Element = js.native

  /**
    * Whether an Attr node has an explicit value, ie. a value that the author explicitly defined, rather than a default.
    *
    * If the ownerElement property of this attribute is null, as for example it would be for an attribute that's been
    * created but not yet added to an element, then specified is also true.
    * This property is readonly.
    */
  def specified: Boolean = js.native

  /**
    * The value of an Attr node.
    *
    * When retrieving, this is a parsed string (ie. entities have been expanded) containing the value of the attribute.
    * When setting, the specification states that a Text node should be created containing the specified string
    * (which is unparsed, so even if it contains characters that an interpretor would recognize as markup, these are
    * treated as literal text). However in practise this is usually not the case, and a DOMString value is created
    * instead; please see Attr for more details.
    * The value of an Attr node is exactly the same as its nodeValue.
    */
  var value: js.Any = js.native

}
