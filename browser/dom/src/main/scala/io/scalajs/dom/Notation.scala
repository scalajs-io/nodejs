package io.scalajs.dom

import scala.scalajs.js

/**
  * The Notation interface inherits from Node, and represents a notation declared in the DTD. Notations are typically
  * used to declare the format of an unparsed entity; they can also be used for formal declaration of processing
  * instruction targets. The content of an unparsed entity does not have to be text, it can be other kinds of data,
  * such as an image.
  *
  * Notation nodes are read-only, and are not part of the DOM tree, hence they have no parent and cannot have children.
  */
@js.native
trait Notation extends Node {

  /**
    * The public identifier of an Entity, or null if no public identifier is specified.
    */
  def publicId: String = js.native

  /**
    * The system identifier of an Entity, or null if no system identifier is specified.
    */
  def systemId: String = js.native

}
