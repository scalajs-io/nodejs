package io.scalajs.dom

import scala.scalajs.js

/**
  * The Text interface inherits from CharacterData, and represents the text content
  * (referred to as character data) inside an [[Element]] or [[Attr]] node.
  *
  * When a document is first loaded there will be only one Text node for each block of text.
  * Operations such as splitText may divide blocks of text into multiple sibling Text nodes,
  * as may creating and adding new Text nodes, but such divisions will not persist between
  * sessions. The normalize method merges adjacent nodes to [re]create the load state of a
  * single Text node for each block of text.
  *
  * A Text node cannot have children.
  * @author lawrence.daniels@gmail.com
  */
@js.native
class Text extends CharacterData {

  /**
    * Break a Text node into two nodes, at the specified character offset.
    *
    * A new node will be created as the nextSibling of the first, containing everything
    * from the offset point up to the end of the string; the original node will now
    * contain just the text before the offset.
    * @param offset The character offset at which to split this node.
    * @return The newly created text node
    */
  def splitText(offset: Int): Text = js.native

}
