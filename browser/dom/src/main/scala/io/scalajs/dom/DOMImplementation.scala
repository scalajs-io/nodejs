package io.scalajs.dom

import scala.scalajs.js

/**
  * The DOMImplementation interface provides methods for operations that are independent of
  * any specific document or instance of the DOM.
  *
  * DOMImplementation is not a node, hence it has no nodeName, nodeType or other properties of Node.
  */
@js.native
trait DOMImplementation extends js.Object {

  /**
    * Create an XML Document of the specified document type, including its root element.
    * @param namespace The namespaceURI of the document element.
    * @param name      The qualified name of the document element.
    * @param doctype   The type of document to be created, or null to not specify a document type.
    *                  If a document type is specified then its ownerDocument property is set to
    *                  the document being created.
    * @return a [[Document]]
    */
  def createDocument(namespace: String, name: String, doctype: String): Document = js.native

}
