package io.scalajs.dom

import scala.scalajs.js

/**
  * The EntityReference interface inherits from Node, and represents an unexpanded entity reference (eg. amp).
  * EntityReference nodes may appear in the DOM when an entity reference appears in the source document, or
  * when inserting new entity references. Entity nodes themselves are readonly, so the EntityReference interface
  * is used to create or modify them.
  *
  * The DOM does not require an implementation to expand external entities, hence the replacement value of an
  * entity reference may not be available; if it is available it will appear in the childNodes collection of
  * the EntityReference.
  *
  * Conversely, an implementation may choose to expand all entities before building the DOM tree, in which case
  * there will be no EntityReference nodes in the document at all, only Entity nodes. In practise, this is what
  * happens in all tested browsers.
  *
  * An EntityReference node can have Element, ProcessingInstruction, Comment, Text, CDATASection and other
  * EntityReference nodes as children.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait EntityReference extends Node