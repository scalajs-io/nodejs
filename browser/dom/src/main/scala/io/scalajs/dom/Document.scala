package io.scalajs.dom

import io.scalajs.dom.collection.HTMLCollection
import io.scalajs.dom.event._
import io.scalajs.dom.html._
import io.scalajs.dom.html.css.CSSSelector

import scala.scalajs.js

/**
  * The Document interface represents any web page loaded in the browser and serves as an entry point into the
  * web page's content, which is the DOM tree. The DOM tree includes elements such as <body> and <table>, among
  * many others. It provides functionality global to the document, like how to obtain the page's URL and create
  * new elements in the document.
  * @see https://developer.mozilla.org/en-US/docs/Web/API/Document
  * @see http://www.w3schools.com/jsref/dom_obj_document.asp
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Document extends ParentNode
  with AnimationEvents with ClipboardEvents with DragEvents with FormEvents
  with FrameObjectEvents with KeyboardEvents with MiscEvents with PrintEvents
  with ServerSentEvents with TouchEvents {

  /**
    * The event occurs when an error occurs while loading an external file
    */
  override def onerror(callback: js.Function): Unit = js.native

  /**
    * The event occurs when a message is received through the event source
    */
  override def onmessage(callback: js.Function): Unit = js.native

  /**
    * Returns the currently focused element in the document
    * @return the currently focused element in the document
    */
  def activeElement: Element = js.native

  /**
    * Attaches an event handler to the document
    * @param event    the event
    * @param callback the callback [[js.Function function]]
    */
  def addEventListener(event: String, callback: js.Function): Unit = js.native

  /**
    * Adopts a node from another document
    */
  def adoptNode(element: Element): Unit = js.native

  /**
    * Returns a collection of all <a> elements in the document that have a name attribute
    * @return a collection of all <a> elements in the document that have a name attribute
    */
  def anchors: HTMLCollection[HTMLAnchorElement] = js.native

  /**
    * Returns a collection of all <applet> elements in the document
    * @return a collection of all <applet> elements in the document
    */
  def applets: HTMLCollection[HTMLAppletElement] = js.native

  /**
    * Returns the absolute base URI of a document
    * @return the absolute base URI of a document
    */
  def baseURI: String = js.native

  /**
    * Sets or returns the document's body (the <body> element)
    * @return the document's body
    */
  var body: HTMLBodyElement = js.native

  /**
    * Closes the output stream previously opened with [[Document#open()]]
    */
  def close(): Unit = js.native

  /**
    * Returns all name/value pairs of cookies in the document
    * @return all name/value pairs of cookies in the document
    */
  var cookie: String = js.native

  /**
    * Creates an attribute node
    */
  def createAttribute(name: String): Unit = js.native

  /**
    * Creates a Comment node with the specified text
    */
  def createComment(text: String): Comment = js.native

  /**
    * Creates an empty DocumentFragment node
    */
  def createDocumentFragment(): DocumentFragment = js.native

  /**
    * Creates an Element node
    * @param `type` the element type
    * @return a new [[Element element]]
    */
  def createElement[T <: Element](`type`: String): T = js.native

  /**
    * The EntityReference interface inherits from Node, and represents an unexpanded entity
    * reference (eg. amp). EntityReference nodes may appear in the DOM when an entity reference
    * appears in the source document, or when inserting new entity references. Entity nodes
    * themselves are readonly, so the EntityReference interface is used to create or modify them.
    *
    * The DOM does not require an implementation to expand external entities, hence the replacement
    * value of an entity reference may not be available; if it is available it will appear in the
    * childNodes collection of the EntityReference.
    *
    * Conversely, an implementation may choose to expand all entities before building the DOM tree,
    * in which case there will be no EntityReference nodes in the document at all, only Entity nodes.
    * In practise, this is what happens in all tested browsers.
    *
    * An EntityReference node can have [[Element]], [[ProcessingInstruction]], [[Comment]], [[Text]], [[CDATASection]]
    * and other [[EntityReference]] nodes as children.
    * @param name the name of the entity
    * @return an [[EntityReference]]
    */
  def createEntityReference(name: String): EntityReference = js.native

  /**
    * Creates a Text node
    * @param text the given text
    * @return a new [[Element text node]]
    */
  def createTextNode(text: String): Element = js.native

  /**
    * Returns the Document Type Declaration associated with the document
    * @return the Document Type Declaration associated with the document
    */
  def doctype: DocumentType = js.native

  /**
    * Returns the Document Element of the document (the <html> element)
    * @return the Document Element of the document (the <html> element)
    */
  def documentElement: HTMLElement = js.native

  /**
    * Returns the mode used by the browser to render the document
    * @return the mode used by the browser to render the document
    */
  def documentMode: String = js.native

  /**
    * Sets or returns the location of the document
    */
  var documentURI: String = js.native

  /**
    * Returns the domain name of the server that loaded the document
    * @return the domain name of the server that loaded the document
    */
  def domain: String = js.native

  /**
    * Obsolete. Returns the DOM configuration of the document
    * @return the DOM configuration of the document
    */
  def domConfig: String = js.native

  /**
    * Returns a collection of all <embed> elements the document
    * @return a collection of all <embed> elements the document
    */
  def embeds: HTMLCollection[HTMLEmbedElement] = js.native

  /**
    * Returns a collection of all <form> elements in the document
    * @return a collection of all <form> elements in the document
    */
  def forms: HTMLCollection[HTMLFormElement] = js.native

  /**
    * Returns the element that has the ID attribute with the specified value
    * @param id the ID attribute
    * @return the element that has the ID attribute
    */
  def getElementById[T <: Element](id: String): T = js.native

  /**
    * Returns a HTMLCollection containing all elements with the specified class name
    * @param className the specified class name
    * @return a HTMLCollection of elements
    */
  def getElementsByClassName(className: String): HTMLCollection[Element] = js.native

  /**
    * Returns a HTMLCollection containing all elements with a specified name
    * @param name the specified name
    * @return a HTMLCollection of elements
    */
  def getElementsByName(name: String): HTMLCollection[Element] = js.native

  /**
    * Returns a HTMLCollection containing all elements with the specified tag name
    * @param tagName the specified tag name
    * @return a HTMLCollection of elements
    */
  def getElementsByTagName(tagName: String): HTMLCollection[Element] = js.native

  /**
    * Returns a Boolean value indicating whether the document has focus
    * @return a Boolean value indicating whether the document has focus
    */
  def hasFocus(): Boolean = js.native

  /**
    * Returns the <head> element of the document
    * @return the <head> element of the document
    */
  def head: HTMLHeadElement = js.native

  /**
    * Returns a collection of all <img> elements in the document
    * @return a collection of all <img> elements in the document
    */
  def images: HTMLCollection[Image] = js.native

  /**
    * The implementation property returns the DOMimplementation object that handles this document,
    * as a [[DocumentImplementation]] object.
    */
  def implementation: DocumentImplementation = js.native

  /**
    * Imports a node from another document
    * @param node Required. The node from another document. Can be of any node type
    * @param deep Required. If set to false, only the node itself is imported, if set to true,
    *             all child nodes (descendants) are also imported
    * @return A Node object, representing the imported node
    */
  def importNode(node: Element, deep: Boolean): Element = js.native

  /**
    * Returns the encoding, character set, used for the document
    * @return the encoding, character set, used for the document
    */
  def inputEncoding: String = js.native

  /**
    * Returns the date and time the document was last modified
    * @return the date and time the document was last modified
    */
  def lastModified: Double = js.native

  /**
    * Returns a collection of all <a> and <area> elements in the document that have a href attribute
    * @return a collection of all <a> and <area> elements in the document that have a href attribute
    */
  def links: HTMLCollection[HTMLAnchorElement] = js.native

  /**
    * Removes empty Text nodes, and joins adjacent nodes
    */
  override def normalize(): Unit = js.native

  /**
    * Removes empty Text nodes, and joins adjacent nodes
    */
  def normalizeDocument(): Unit = js.native

  /**
    * Opens an HTML output stream to collect output from document.write()
    */
  def open(): Unit = js.native

  /**
    * Returns the first element that matches a specified CSS selector(s) in the document
    * @param name the first element that matches a specified CSS selector(s) in the document
    */
  def querySelector(name: String): CSSSelector = js.native

  /**
    * Returns a static HTMLCollection containing all elements that matches a specified CSS selector(s) in the document
    * @return a static HTMLCollection containing all elements that matches a specified CSS selector(s) in the document
    */
  def querySelectorAll(): HTMLCollection[CSSSelector] = js.native

  /**
    * Returns the (loading) status of the document
    * @return the (loading) status of the document
    *         One of five values:
    *         uninitialized - Has not started loading yet
    *         loading - Is loading
    *         loaded - Has been loaded
    *         interactive - Has loaded enough and the user can interact with it
    *         complete - Fully loaded
    */
  def readyState: String = js.native

  /**
    * Returns the URL of the document that loaded the current document
    * @return the URL of the document that loaded the current document
    */
  def referrer: String = js.native

  /**
    * Removes an event handler from the document (that has been attached with the addEventListener() method)
    * @param event      Required. A String that specifies the name of the event to remove.
    * @param function   Required. Specifies the function to remove.
    * @param useCapture Optional. A Boolean value that specifies the event phase to remove the event handler from.
    *                   Possible values:
    *                   true - Removes the event handler from the capturing phase
    *                   false - Default. Removes the event handler from the bubbling phase
    */
  def removeEventListener(event: String, function: js.Function, useCapture: Boolean = false): Unit = js.native

  /**
    * Renames the specified node.
    * @param node         Node object	Required. The node object you want to rename
    * @param namespaceURI String	Required, but can be set to null if you do not want to specify the namespace URI of the node
    * @param nodename     String	Required, the new nodename
    * @return A Node object, representing the renamed node
    */
  def renameNode(node: Node, namespaceURI: String, nodename: String): Node = js.native

  /**
    * Returns a collection of <script> elements in the document
    * @return a collection of <script> elements in the document
    */
  def scripts: HTMLCollection[ScriptElement] = js.native

  /**
    * Sets or returns whether error-checking is enforced or not
    */
  var strictErrorChecking: Boolean = js.native

  /**
    * Sets or returns the title of the document
    */
  var title: String = js.native

  /**
    * Returns the full URL of the HTML document
    * @return the full URL of the HTML document
    */
  def URL: String = js.native

  /**
    * Writes HTML expressions or JavaScript code to a document
    */
  def write(expr: js.Any*): Unit = js.native

  /**
    * Same as write(), but adds a newline character after each statement
    */
  def writeln(expr: js.Any*): Unit = js.native

}
