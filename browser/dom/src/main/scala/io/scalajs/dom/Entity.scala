package io.scalajs.dom

import scala.scalajs.js

/**
  * The Entity interface inherits from Node, and represents an expanded entity, ie. the entity itself (eg. &),
  * not the entity reference (eg. amp); entity references are controlled by the [[EntityReference]] interface.
  *
  * The DOM does not require an implementation to expand external entities, hence the replacement value of an
  * entity reference may not be available; if it is available it will appear in the childNodes collection of
  * the [[EntityReference]].
  *
  * Conversely, an implementation may choose to expand all entities before building the DOM tree, in which case
  * there will be no [[EntityReference]] nodes in the document at all, only [[Entity]] nodes.
  *
  * Entity nodes and their descendents are read-only, and can only be modified at the [[EntityReference]] level.
  *
  * An Entity node can have [[Element]], [[ProcessingInstruction]], [[Comment]], [[Text]], [[CDATASection]]
  * and [[EntityReference]] nodes as children.
  * @author lawrence.daniels@gmail.com
  * @see http://reference.sitepoint.com/javascript/Entity
  */
@js.native
trait Entity extends Node {

  /**
    * Entity (the value after NDATA in the Notation definition); or null for an unparsed entity.
    */
  def notationName: String = js.native

  /**
    * The public identifier of an Entity, or null if no public identifier is specified.
    */
  def publicId: String = js.native

  /**
    * The system identifier of an Entity, or null if no system identifier is specified.
    */
  def systemId: String = js.native

}
