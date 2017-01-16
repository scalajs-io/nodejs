package io.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * The Range interface represents a fragment of a document that can contain nodes and parts of text nodes.
  *
  * A range can be created using the createRange() method of the Document object. Range objects can also be
  * retrieved by using the getRangeAt() method of the Selection object or the caretRangeAtPoint() method
  * of the Document object.
  * @see https://developer.mozilla.org/en-US/docs/Web/API/Range
  * @author lawrence.daniels@gmail.com
  */
@js.native
class Range() extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Returns a Boolean indicating whether the range's start and end points are at the same position.
    */
  def collapsed: Boolean = js.native

  /**
    * Returns the deepest Node that contains the startContainer and endContainer nodes.
    */
  def commonAncestorContainer: Node = js.native

  /**
    * Returns the Node within which the Range ends.
    */
  def endContainer: Node = js.native

  /**
    * Returns a number representing where in the endContainer the Range ends.
    */
  def endOffset: Int = js.native

  /**
    * Returns the Node within which the Range starts.
    */
  def startContainer: Node = js.native

  /**
    * Returns a number representing where in the startContainer the Range starts.
    */
  def startOffset: Int = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Sets the start position of a Range.
    * @param startNode   The [[Node]] where the Range should start.
    * @param startOffset An integer greater than or equal to zero representing the offset
    *                    for the start of the Range from the start of startNode.
    */
  def setStart(startNode: Node, startOffset: Int): Unit = js.native

  /**
    * Sets the end position of a Range.
    * @param endNode   The [[Node]] where the Range should end.
    * @param endOffset An integer greater than or equal to zero representing the offset for
    *                  the end of the Range from the start of endNode.
    */
  def setEnd(endNode: Node, endOffset: Int): Unit = js.native

  /**
    * Sets the start position of a Range relative to another Node.
    * @param referenceNode The Node before which the Range should start.
    */
  def setStartBefore(referenceNode: Node): Unit = js.native

  /**
    * Sets the start position of a Range relative to another Node.
    * @param referenceNode The Node to start the Range after.
    */
  def setStartAfter(referenceNode: Node): Unit = js.native

  /**
    * Sets the end position of a Range relative to another Node.
    * @param referenceNode The Node to end the Range before.
    */
  def setEndBefore(referenceNode: Node): Unit = js.native

  /**
    * Sets the end position of a Range relative to another Node.
    * @param referenceNode The Node to end the Range after.
    */
  def setEndAfter(referenceNode: Node): Unit = js.native

  /**
    * Sets the Range to contain the Node and its contents.
    * @param referenceNode The Node to select within a Range.
    */
  def selectNode(referenceNode: Node): Unit = js.native

  /**
    * Sets the Range to contain the contents of a Node.
    * @param referenceNode The Node whose contents will be selected within a Range.
    */
  def selectNodeContents(referenceNode: Node): Unit = js.native

  /**
    * Collapses the Range to one of its boundary points.
    * @param toStart Optional: A boolean value: true collapses the Range to its start, false to its end.
    *                If omitted, it defaults to false
    */
  def collapse(toStart: Boolean = js.native): Unit = js.native

  /**
    * Returns a DocumentFragment copying the nodes of a Range.
    */
  def cloneContents(): DocumentFragment = js.native

  /**
    * Removes the contents of a Range from the Document.
    */
  def deleteContents(): Unit = js.native

  /**
    * Moves contents of a Range from the document tree into a DocumentFragment.
    */
  def extractContents(): DocumentFragment = js.native

  /**
    * Insert a Node at the start of a Range.
    * @param newNode The Node to insert at the start of the range.
    */
  def insertNode(newNode: Node): Unit = js.native

  /**
    * Moves content of a Range into a new Node.
    */
  def surroundContents(newNode: Node): Unit = js.native

  /**
    * Compares the boundary points of the Range with another Range.
    * @param how         A constant describing the comparison method:
    * @param sourceRange A Range to compare boundary points with the range.
    * @return A number, -1, 0, or 1, indicating whether the corresponding boundary-point of the
    *         Range is respectively before, equal to, or after the corresponding boundary-point of sourceRange.
    */
  def compareBoundaryPoints(how: RangeType, sourceRange: Range): Int = js.native

  /**
    * Returns a Range object with boundary points identical to the cloned Range.
    */
  def cloneRange(): Range = js.native

  /**
    * Releases the Range from use to improve performance.
    */
  def detach(): Unit = js.native

}

/**
  * Range Companion
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSName("Range")
object Range extends js.Object {

  /**
    * compares the end boundary-point of sourceRange to the end boundary-point of Range.
    */
  def END_TO_END: RangeType = js.native

  /**
    * compares the end boundary-point of sourceRange to the start boundary-point of Range.
    */
  def END_TO_START: RangeType = js.native

  /**
    * compares the start boundary-point of sourceRange to the end boundary-point of Range.
    */
  def START_TO_END: RangeType = js.native

  /**
    * compares the start boundary-point of sourceRange to the start boundary-point of Range.
    */
  def START_TO_START: RangeType = js.native

}
