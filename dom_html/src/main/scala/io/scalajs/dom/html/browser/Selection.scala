package io.scalajs.dom.html.browser

import io.scalajs.dom
import io.scalajs.dom.Node

import scala.scalajs.js

/**
  * A Selection object represents the range of text selected by the user or the current position of the caret.
  * To obtain a Selection object for examination or modification, call window.getSelection().
  *
  * A user may make a selection from left to right (in document order) or right to left (reverse of document order).
  * The anchor is where the user began the selection and the focus is where the user ends the selection. If you make
  * a selection with a desktop mouse, the anchor is placed where you pressed the mouse button and the focus is placed
  * where you released the mouse button. Anchor and focus should not be confused with the start and end positions of
  * a selection, since anchor can be placed before the focus or vice versa, depending on the direction you made your selection.
  * @author lawrence.daniels@gmail.com
  * @see https://developer.mozilla.org/en-US/docs/Web/API/Selection
  */
@js.native
class Selection extends js.Object {

  ///////////////////////////////////////////////////////////////
  //    Properties
  ///////////////////////////////////////////////////////////////

  /**
    * Read only: Returns the Node in which the selection begins.
    */
  def anchorNode: Node = js.native

  /**
    * Read only: Returns a number representing the offset of the selection's anchor within the anchorNode.
    * If anchorNode is a text node, this is the number of characters within anchorNode preceding the anchor.
    * If anchorNode is an element, this is the number of child nodes of the anchorNode preceding the anchor.
    */
  def anchorOffset: Int = js.native

  /**
    * Read only: Returns the Node in which the selection ends.
    */
  def focusNode: Node = js.native

  /**
    * Read only: Returns a number representing the offset of the selection's anchor within the focusNode.
    * If focusNode is a text node, this is the number of characters within focusNode preceding the focus.
    * If focusNode is an element, this is the number of child nodes of the focusNode preceding the focus.
    */
  def focusOffset: Int = js.native

  /**
    * Read only: Returns a Boolean indicating whether the selection's start and end points are at the same position.
    */
  def isCollapsed: Boolean = js.native

  /**
    * Read only: Returns the number of ranges in the selection.
    */
  def rangeCount: Int = js.native

  ///////////////////////////////////////////////////////////////
  //    Methods
  ///////////////////////////////////////////////////////////////

  /**
    * Returns a Range object representing one of the ranges currently selected.
    */
  def getRangeAt(index: Int): dom.Range = js.native

  /**
    * Collapses the current selection to a single point.
    * @param parentNode The caret location will be within this node.
    * @param offset     The offset in parentNode to which the selection will be collapsed.
    */
  def collapse(parentNode: Node, offset: Int): Unit = js.native

  /**
    * Moves the focus of the selection to a specified point.
    * @param parentNode The node within which the focus will be moved.
    * @param offset     The offset position within parentNode where the focus will be moved to.
    */
  def extend(parentNode: Node, offset: Int): Unit = js.native

  /**
    * Changes the current selection.
    * @param alter       The type of change to apply. Specify "move" to move the current cursor position
    *                    or "extend" to extend the current selection.
    * @param direction   The direction in which to adjust the current selection. You can specify "forward"
    *                    or "backward" to adjust in the appropriate direction based on the language at the
    *                    selection point. If you want to adjust in a specific direction, you can specify "left" or "right".
    * @param granularity The distance to adjust the current selection or cursor position. You can move by
    *                    "character", "word", "sentence", "line", "paragraph", "lineboundary", "sentenceboundary",
    *                    "paragraphboundary", or "documentboundary".
    */
  def modify(alter: String, direction: String, granularity: String): Unit = js.native

  /**
    * Collapses the selection to the start of the first range in the selection.
    */
  def collapseToStart(): Unit = js.native

  /**
    * Collapses the selection to the end of the last range in the selection.
    */
  def collapseToEnd(): Unit = js.native

  /**
    * Adds all the children of the specified node to the selection.
    */
  def selectAllChildren(): Unit = js.native

  /**
    * A Range object that will be added to the selection.
    */
  def addRange(range: dom.Range): Unit = js.native

  /**
    * Removes a range from the selection.
    */
  def removeRange(range: dom.Range): Unit = js.native

  /**
    * Removes all ranges from the selection.
    */
  def removeAllRanges(): Unit = js.native

  /**
    * Deletes the selection's content from the document.
    */
  def deleteFromDocument(): Unit = js.native

  /**
    * Indicates if a certain node is part of the selection.
    * @param aNode            The node that is being looked for whether it is part of the selection
    * @param aPartlyContained When true, containsNode() returns true when a part of the node is part of the selection.
    *                         When false, containsNode() only returns true when the entire node is part of the selection.
    */
  def containsNode(aNode: Node, aPartlyContained: Boolean = js.native): Boolean = js.native

}
