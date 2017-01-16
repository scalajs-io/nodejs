package io.scalajs.dom


import io.scalajs.dom.collection.NamedNodeMap

import scala.scalajs.js

/**
  * The DocumentType interface inherits from Node, and provides access to the attributes of a Document Type Declaration (DTD).
  *
  * Every Document has a doctype property, which is a read-only instance of this interface where available, otherwise null.
  * It should only return an object for an XML document that has a Document Type Declaration; for HTML documents,
  * or XML documents without a DTD, it should be null.
  *
  * A DocumentType node cannot have children.
  * @see https://developer.mozilla.org/en-US/docs/Web/API/DocumentType
  * @see http://reference.sitepoint.com/javascript/DocumentType/notations
  */
@js.native
class DocumentType extends Node {

  /**
    * The name of an Attr or DocumentType.
    */
  def name: String = js.native

  /**
    * The entities collection is a is an unordered list of the general entities declared in the DTD.
    * Both external and internal entities should be included; duplicates should be discarded.
    *
    * This collection is a NamedNodeMap, primarily intended to be accessed by name. It's also possible to access
    * the items by their index in the map, however the DOM does not specify what order they will appear.
    *
    * As with all named node maps, entities is a live collection, which means that changes to the collection it
    * represents are immediately reflected in the node map (as opposed to it being a static snapshot).
    *
    * Each member of this collection is an Entity node, and is readonly.
    */
  def entities[T <: Entity]: NamedNodeMap[T] = js.native

  /**
    * A string containing the text of a DTD's internal subset.
    */
  def internalSubset: String = js.native

  /**
    * The notations collection is an unordered list of every Notation declared in the DTD. Notations are used for
    * declaring the format of an unparsed entity, or the target of a processing instruction.
    *
    * This collection is a NamedNodeMap, primarily intended to be accessed by name. It's also possible to access the
    * items by their index in the map, however the DOM does not specify what order they will appear.
    *
    * As with all named node maps, notations[] is a live collection, which means that changes to the collection it
    * represents are immediately reflected in the node map (as opposed to it being a static snapshot).
    * *
    * Each member of this collection is a Notation node, and is readonly.
    */
  def notations[T <: Notation]: NamedNodeMap[T] = js.native

  /**
    * The public identifier of an Entity, or null if no public identifier is specified.
    */
  def publicId: String = js.native

  /**
    * The system identifier of an Entity, or null if no system identifier is specified.
    */
  def systemId: String = js.native

}
