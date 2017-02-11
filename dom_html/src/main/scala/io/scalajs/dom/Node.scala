package io.scalajs.dom

import io.scalajs.dom.NodeTypes.NodeType
import io.scalajs.dom.collection.{NamedNodeMap, NodeList}

import scala.scalajs.js

/**
  * The Node interface is the primary data type for the Document Object Model (DOM).  It represents any single item
  * in the tree, such as an [[Element Element]], [[Attr Attr]], [[Document Document]] or [[Entity Entity]].
  * @author lawrence.daniels@gmail.com
  * @see http://reference.sitepoint.com/javascript/Node
  */
@js.native
trait Node extends js.Object {

  /**
    * Add a new node (and its subtree, if applicable) to the end of the list of children of this node.
    *
    * If the new child is already present in the DOM tree it is first removed (effectively moving it).
    * If the new child is a DocumentFragment node then the entire contents of the document fragment
    * are appended, but the fragment node itself is not (therefore using a document fragment is a good
    * way of building and attaching several nodes at once).
    * @param node The new node to be added to this node. If the new node has any children these are also
    *             added recursively, preserving the new node's sub-tree.
    * @return The node that was added
    */
  def appendChild(node: Node): Node = js.native

  /**
    * The attributes collection is an unordered list of all the effective attributes1 of an Element;
    * for other nodes this property is null.
    *
    * This collection is a NamedNodeMap, primarily intended to be accessed by name. It's also possible
    * to access the items by their index in the map, however the DOM does not specify what order they
    * will appear in (and this varies by browser, as noted in the Compatibility notes below).
    *
    * As with all named node maps, attributes is a live collection, which means that changes to the
    * collection it represents are immediately reflected in the node map (as opposed to it being a static snapshot).
    * This collection is read-only.
    */
  def attributes: NamedNodeMap[Attr] = js.native

  /**
    * The childNodes collection is an ordered list of all the direct child nodes of this node; if there are
    * no child nodes then this collection is empty (it has zero length). The childNodes collection is a
    * NodeList, in which the items are indexed numerically, and appear in source order.
    *
    * As with all node lists, childNodes is a live collection, which means that changes to the collection
    * it represents are immediately reflected in the node list (as opposed to it being a static snapshot).
    *
    * Attributes of an element are not considered child nodes, and therefore don’t appear in the childNodes collection2
    * This collection is read only.
    * @return an ordered list of all the direct child nodes of this node
    */
  def childNodes[T <: Node]: NodeList[T] = js.native

  /**
    * Creates a duplicate of this node, including all attributes and their values (including attributes
    * which are not explicitly defined but which have a default value in this document type). The duplicate
    * node has no parent (parentNode is null) until it's added to the document, for example using appendChild.
    *
    * If the deep argument is included and has the value true then the node's sub-tree (if any) will also be duplicated.
    *
    * Cloning a sub-tree that is readonly results in a sub-tree that can be modified (ie. the sub-tree of a cloned node
    * is always mutable, even if the original was immutable), with the exception that the children of a cloned
    * EntityReference are always readonly.
    *
    * Cloning an Element node also copies its attributes (including any default attributes), but does not copy its
    * text unless the deep argument is true.
    *
    * Cloning an Attr node directly (as opposed to attributes that belong to a cloned Element) creates a node for
    * which the specified property is true.
    *
    * Whether a Document, DocumentType, Entity or Notation node may be cloned is not defined by the DOM, and depends
    * on the implementation (see Compatibility notes below).
    * @param deep If true duplicate the node's sub-tree as well as the node itself. If false only copy
    *             the node (and its attributes, if it's an Element).
    * @return The duplicate node.
    */
  def cloneNode(deep: Boolean): this.type = js.native

  /**
    * The first node that is a direct child of this node (ie. this node is its parent and it appears at the
    * beginning of the childNodes collection), or null if there is no such node.
    * This property is readonly.
    * @return The first node that is a direct child of this node
    */
  def firstChild[T <: Node]: T = js.native

  /**
    * Returns whether an Element node has any attributes.
    * @return true if this node is an Element and has any effective attributes, otherwise false
    */
  def hasAttributes(): Boolean = js.native

  /**
    * Test whether a node has any child nodes; equivalent to evaluating whether the childNodes collection
    * has a length greater than zero.
    * @return true if this node has any children, otherwise false
    */
  def hasChildNodes(): Boolean = js.native

  /**
    * Insert a new node as a child of this node, directly before an existing child of this node, or at the
    * end of the list of children if no existing child is specified or it's null. If the new child is already
    * present in the DOM tree it is first removed (effectively moving it).
    * @param newNode       The new node to insert.
    * @param existingChild An existing child node that the new node should be inserted before.
    *                      If this argument is null, the new node is inserted at the end of this node's list of children.
    * @return the inserted node
    */
  def insertBefore(newNode: Node, existingChild: Node): Node = js.native

  /**
    * Test whether a specific feature of the DOM is implemented, and supported by this node.
    *
    * This method is essentially the same as hasFeature, except that it's concerned with whether a feature is supported
    * by a specific node, rather than whether it's implemented in general.
    * @param feature The name of the feature to test, using one of the values defined in the DOM 2 Conformance list.
    * @param version The DOM version to test. For DOM 2 this is always the value 2.0. If this argument is not specified,
    *                the method will return true if the feature is supported at any DOM level.
    * @return true if the feature is implemented and supported on this node, otherwise false
    */
  def isSupported(feature: String, version: String = js.native): Boolean = js.native

  /**
    * The last node that is a direct child of this node (ie. this node is its parent and it appears at the end
    * of the childNodes collection), or null if there is no such node.
    * This property is readonly.
    * @return The last node that is a direct child of this node
    */
  def lastChild: Node = js.native

  /**
    * The local name (ie. not including any namespace prefix) of a Element or Attr node; for other
    * nodes this property is null.
    *
    * DOM 1 methods such as getAttribute are not namespace aware, and identify nodes by their nodeName.
    * Namespace aware DOM 2 methods such as getAttributeNS identify nodes by a combination of their
    * namespaceURI and localName; the localName and prefix combined form a qualified name — a name
    * which comprises the namespace prefix then the local name, delimited with a colon.
    * This property is readonly.
    * @return The local name
    */
  def localName: String = js.native

  /**
    * The namespace URI of an Element or Attr node. For other nodes, or elements or attributes created with a
    * DOM 1 method that isn't namespace aware (such as createElement), or nodes with no namespace, this property is null.
    *
    * This should not be a computed value or lookup of the namespace an element should have, it should be the literal
    * value that it does have.
    *
    * An Element node can inherit its namespace from an ancestor. However Attr nodes do not inherit a namespace from
    * the element they're attached to — if an attribute does not have an explicitly defined namespace then it simply
    * has no namespace.
    * This property is readonly.
    * @return The namespace URI
    */
  def namespaceURI: String = js.native

  /**
    * The node immediately after this node (ie. both nodes have the same parent and are next to each other in
    * its childNodes collection), or null if there is no such node.
    * This property is readonly.
    * @return The node immediately after this node
    */
  def nextSibling: Node = js.native

  /**
    * The name of this node
    */
  def nodeName: String = js.native

  /**
    * A numeric code that represents the type of this node
    * +---------------------------+----+
    * | Element                   |  1 |
    * | Attr                      |  2 |
    * | Text                      |  3 |
    * | CDATASection              |  4 |
    * | EntityReference           |  5 |
    * | Entity                    |  6 |
    * | ProcessingInstruction	    |  7 |
    * | Comment                   |  8 |
    * | Document                  |  9 |
    * | DocumentType              | 10 |
    * | DocumentFragment          | 11 |
    * | Notation                  | 12 |
    * +---------------------------+----+
    * @return the numeric code
    * @see [[NodeTypes]]
    */
  def nodeType: NodeType = js.native

  /**
    * The value of this node
    */
  def nodeValue: js.Any = js.native

  /**
    * Puts this node's sub-tree in a state whereby only structural nodes separate Text nodes.
    *
    * When a document is first loaded there will be only one Text node for each block of text.
    * Operations such as splitText may divide blocks of text into multiple sibling Text nodes,
    * as may creating and adding new Text nodes, but such divisions will not persist between
    * sessions. The normalize method merges adjacent nodes to [re]create the load state of a
    * single Text node for each block of text.
    */
  def normalize(): Unit = js.native

  /**
    * The Document which contains this node; or null if this node is itself a Document, or a
    * DocumentType that is not associated with any document.
    * This property is read-only.
    */
  def ownerDocument: Document = js.native

  /**
    * The parent of this node; or null if it has no parent.
    *
    * Nodes which have just been created but not added to the document, or have just been removed
    * from the document, or are Attr, Document, DocumentFragment or Entity nodes, do not have a parent.
    * This property is readonly.
    */
  def parentNode: Node = js.native

  /**
    * The namespace prefix of this node; or null if this node has no namespace.
    *
    * Only namespaced elements and attributes have a prefix; for other nodes, or for
    * elements or attributes created with a non-namespace-aware method such as createElement,
    * the prefix property is null.
    *
    * Changing this value may also change the nodeName of this node (since the node name of a
    * namespaced node is a combination of of localName and prefix), as well as the tagName and
    * name properties of elements and attributes (respectively).
    *
    * Changing the prefix of an element or attribute that has a default value in this document
    * type does not cause a new default node to be created (ie. the prefix change might mean
    * that the default is no longer present, but a new default will not appear to replace it).
    * This property is read/write.
    */
  def prefix: String = js.native

  /**
    * The node immediately before this node (ie. both nodes have the same parent and are next
    * to each other in its childNodes collection), or null if there is no such node.
    * This property is readonly.
    */
  def previousSibling: Node = js.native

  /**
    * Removes a specified node from the children of this node.
    * @param oldNode The node to be removed.
    */
  def removeChild(oldNode: Node): Unit = js.native

  /**
    * Replace an existing child of this node with a new child node. If the new child is already present
    * in the DOM tree it is first removed (effectively moving it).
    * @param newChild      The node to be added.
    * @param existingChild The node to be removed and replaced.
    * @return The node that was removed
    */
  def replaceChild(newChild: Node, existingChild: Node): Node = js.native

}
