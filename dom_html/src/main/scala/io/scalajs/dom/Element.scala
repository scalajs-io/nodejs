package io.scalajs.dom

import io.scalajs.dom.collection.HTMLCollection

import scala.scalajs.js

/**
  * The Element interface inherits from Node, and represents a single element in an HTML or XML document.
  *
  * An Element node may have other Element, Text, Comment, ProcessingInstruction, CDATASection or EntityReference
  * nodes as children.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Element extends ParentNode {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * The qualified name of an Element node, including any namespace prefix.
    *
    * In HTML this is returned in all uppercase regardless of the case used in the document;
    * in XML the case used in the document is preserved.
    *
    * In all cases, the tagName of an element is exactly the same as its nodeName.
    * This property is readonly.
    */
  def tagName: String = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Get the value of an attribute with the specified name.
    *
    * This method is for working with non-namespaced attributes; to get a namespaced attribute,
    * use the DOM 2 getAttributeNS method instead.
    * @param name The name of the attribute to retrieve.
    * @return The attribute value; if the attribute is not defined this method should return an empty string,
    *         however most browsers return null
    */
  def getAttribute(name: String): String = js.native

  /**
    * Get an Attr node with the specified name.
    *
    * The value of this node can then be retrieved with the value property of Attr, or the more general
    * nodeValue property of Node.
    *
    * This method is for working with non-namespaced attribute nodes; to get a namespaced attribute node,
    * use the DOM 2 getAttributeNodeNS method instead.
    * @param name The nodeName of the attribute node to retrieve.
    * @return The attribute node; or null if the specified attribute is not defined.
    */
  def getAttributeNode(name: String): Attr = js.native

  /**
    * Get an Attr node with the specified localName and namespaceURI.
    *
    * The value of this node can then be retrieved with the value property of Attr, or the more
    * general nodeValue property of Node.
    *
    * Unlike Element nodes, Attr nodes do not inherit a namespace from the element they're
    * attached to — if an attribute does not have an explicitly defined namespace then it simply
    * has no namespace. See Attr for more details.
    * @param namespace The namespaceURI of the attribute node to retrieve. A value of null means no namespace.
    * @param name      The localName of the attribute node to retrieve.
    * @return The attribute node; or null if the specified attribute is not defined.
    */
  def getAttributeNodeNS(namespace: String, name: String): Attr = js.native

  /**
    * Get the value of an attribute with the specified name and namespace URI.
    *
    * Unlike Element nodes, Attr nodes do not inherit a namespace from the element they're
    * attached to — if an attribute does not have an explicitly defined namespace then it simply
    * has no namespace. See Attr for more details.
    * @param namespace The namespaceURI of the attribute to retrieve. A value of null means no namespace.
    * @param name      The localName of the attribute to retrieve.
    * @return
    */
  def getAttributeNS(namespace: String, name: String): Attr = js.native

  /**
    * Get an ordered list of all elements with a given tag name, that are descendants of this
    * document or element, in the linear order in which they appear in the DOM tree.
    *
    * The returned collection is a HTMLCollection — an ordered collection of nodes, indexed numerically
    * starting from zero. If there are no matching elements then it's a collection with zero members.
    * @param name The tagName of the elements to match. The value * matches all elements.
    * @return A HTMLCollection containing all the matched elements; if no elements are found this will be a l
    *         ist with zero members.
    */
  def getElementsByTagName[T <: Element](name: String): HTMLCollection[T] = js.native

  /**
    * Get an ordered list of all elements with a given local name and namespace URI, that are descendents
    * of this document or element, in the linear order in which they appear in the DOM tree.
    *
    * The returned collection is a HTMLCollection — an ordered collection of nodes, indexed numerically starting
    * from zero. If there are no matching elements then it's a collection with zero members.
    * @param namespace The namespaceURI of the elements to match. A value of null means no namespace.
    *                  The value * matches elements in all namespaces, including elements in no namespace.
    * @param name      The localName of the elements to match. The value * matches all elements.
    * @return A HTMLCollection containing all the matched elements; if no elements are found this will be a
    *         list with zero members.
    */
  def getElementsByTagNameNS[T <: Element](namespace: String, name: String): HTMLCollection[T] = js.native

  /**
    * Whether this element has an attribute with the specified name, or has a specific default value
    * for that attribute in this document type.
    * @param name The name of the attribute to look for.
    * @return Returns true if an attribute with the specified name is defined for this element, or has a
    *         specific default value in this document type, otherwise false
    */
  def hasAttribute(name: String): Boolean = js.native

  /**
    * Whether this element has an attribute with the specified local name and namespace URI, or has a
    * specific default value for that attribute in this document type.
    *
    * Unlike Element nodes, Attr nodes do not inherit a namespace from the element they're attached
    * to — if an attribute does not have an explicitly defined namespace then it simply has no namespace.
    * @param namespace The namespaceURI of the attribute to look for. A value of null means no namespace.
    * @param name      The localName of the attribute to look for.
    * @return Returns true if an attribute with the specified local name and namespace URI is defined
    *         for this element, or has a specific default value in this document type, otherwise false
    */
  def hasAttribute(namespace: String, name: String): Boolean = js.native

  /**
    * Remove an attribute with the specified name.
    *
    * If the attribute has a specific default value in this document type, removing the attribute should replace
    * it with the default value (as well as its corresponding namespaceURI, localName and prefix if applicable).
    *
    * This method removes non-namespaced attributes; to remove a namespaced attribute, use the DOM 2 removeAttributeNS
    * method instead.
    * @param name The name of the attribute to remove.
    */
  def removeAttribute(name: String): Unit = js.native

  /**
    * Remove a specified attribute node (a reference to which can be retrieved with getAttributeNode
    * or getAttributeNodeNS). This method is essentially the same as removeAttribute, except that its
    * argument is the attribute node itself, rather than the attribute's name.
    *
    * If the attribute has a specific default value in this document type, a new node should be created
    * with the default value (and the same namespaceURI, localName and prefix if applicable).
    * @param attr The attribute node to remove.
    * @return The attribute node that was removed
    */
  def removeAttributeNode(attr: Attr): Attr = js.native

  /**
    * Remove an attribute with the specified name and namespace URI.
    *
    * If the attribute has a specific default value in this document type, removing the attribute should
    * replace it with the default value, having the same namespaceURI, localName and prefix.
    *
    * Unlike Element nodes, Attr nodes do not inherit a namespace from the element they're attached to —
    * if an attribute does not have an explicitly defined namespace then it simply has no namespace.
    * See Attr for more details.
    * @param namespace The namespaceURI of the attribute to remove. A value of null means no namespace.
    * @param name      The localName of the attribute to remove.
    */
  def removeAttributeNS(namespace: String, name: String): Unit = js.native

  /**
    * Set a new attribute with the specified name and value to this element.
    * If an attribute already exists with the specified name, its value is replaced.
    *
    * When setting a value, the value is not parsed, so any entity references or other markup will be
    * treated as literal text. To create an attribute containing entities the specification suggests
    * to create an Attr node with appropriate Text and EntityReference nodes as children, then add it
    * to an element using setAttributeNode, however in practise this rarely works (see Attr for details).
    *
    * This method is for working with non-namespaced attributes; to add a namespaced attribute, use the DOM 2
    * setAttributeNS method instead.
    * @param name  The name of the attribute to create or alter.
    * @param value The string value for the attribute.
    */
  def setAttribute(name: String, value: js.Any): Unit = js.native

  /**
    * Add an Attr node to this Element.
    * If an attribute already exists with the specified nodeName, the existing node is replaced with the new one.
    *
    * This method is for working with non-namespaced attribute nodes; to add a namespaced attribute node,
    * use the DOM 2 setAttributeNodeNS method instead.
    * @param attr The attribute node to add.
    * @return If the new attribute replaces an existing attribute, the previously existing attribute node is returned;
    *         otherwise null is returned.
    */
  def setAttributeNode(attr: Attr): Attr = js.native

  /**
    * Add a namespaced attribute node to this element.
    * If an attribute already exists with the specified local name and namespace URI, the existing node is replaced.
    *
    * The usage and behavior of this method is identical to setAttributeNode except that the local name
    * and namespace URI are both taken into account when determining whether an existing attribute should
    * be replaced, rather than just the name.
    *
    * Unlike Element nodes, Attr nodes do not inherit a namespace from the element they're attached
    * to — if an attribute does not have an explicitly defined namespace then it simply has no namespace (see Attr for details).
    * @param attr The attribute node to add. The node can subsequently be retrieved using its localName and namespaceURI.
    * @return If the new attribute replaces an existing attribute with the same local name and namespace URI,
    *         the previously existing attribute node is returned ; otherwise null is returned.
    */
  def setAttributeNodeNS(attr: Attr): Attr = js.native

  /**
    * Set a new attribute with the specified local name, namespace URI and value to this element.
    * If an attribute already exists with the same local name and namespace URI, its value is replaced
    * and its prefix changed to the prefix part of the specified qualified name1.
    *
    * When setting a value, the value is not parsed, so any entity references or other markup will be treated
    * as literal text. To create an attribute containing entities the specification suggests to create an
    * Attr node with appropriate Text and EntityReference nodes as children, then add it to an element using
    * setAttributeNode, however in practise this rarely works (see Attr for details).
    *
    * Unlike Element nodes, Attr nodes do not inherit a namespace from the element they're attached to — if an
    * attribute does not have an explicitly defined namespace then it simply has no namespace (see Attr for details).
    * @param namespace The namespaceURI of the attribute to create or alter. A value of null means no namespace.
    * @param name      The qualified name of the attribute to create or alter.
    * @param value     The string value for the attribute.
    */
  def setAttributeNS(namespace: String, name: String, value: js.Any): Unit = js.native

}
