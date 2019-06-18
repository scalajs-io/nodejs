package io.scalajs.dom.html.pixijs

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * A DisplayObjectContainer represents a collection of display objects.
  * It is the base class of all display objects that act as a container for other objects.
  * @see http://phaser.io/docs/2.6.2/PIXI.DisplayObjectContainer.html
  */
@js.native
//@JSGlobal("PIXI.DisplayObjectContainer")
trait DisplayObjectContainer extends DisplayObject {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Returns the array of children of this container.
    * @return the array of children of this container.
    */
  def children: js.Array[DisplayObject] = js.native

  /**
    * The height of the displayObjectContainer, setting this will actually modify
    * the scale to achieve the value set
    */
  var height: Double = js.native

  /**
    * If ignoreChildInput is false it will allow this objects children to be considered
    * as valid for Input events.
    *
    * If this property is true then the children will not be considered as valid for Input events.
    *
    * Note that this property isn't recursive: only immediate children are influenced,
    * it doesn't scan further down.
    */
  var ignoreChildInput: Boolean = js.native

  /**
    * The width of the displayObjectContainer, setting this will actually modify the
    * scale to achieve the value set
    */
  var width: Double = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Adds a child to the container.
    * @param child The DisplayObject to add to the container
    * @return The child that was added.
    */
  def addChild(child: DisplayObject): DisplayObject = js.native

  /**
    * Adds a child to the container at a specified index. If the index is out of bounds an error will be thrown
    * @param child The child to add
    * @param index The index to place the child in
    * @return The child that was added.
    */
  def addChildAt(child: DisplayObject, index: Int): DisplayObject = js.native

  /**
    * Determines whether the specified display object is a child of the DisplayObjectContainer
    * instance or the instance itself.
    * @param child the child to check the existence of
    * @return true if this container contains the given child
    */
  def contains(child: DisplayObject): Boolean = js.native

  /**
    * Retrieves the global bounds of the displayObjectContainer as a rectangle.
    * The bounds calculation takes all visible children into consideration.
    * @param targetCoordinateSpace Returns a rectangle that defines the area of the
    *                              display object relative to the coordinate system
    *                              of the targetCoordinateSpace object.
    * @return The rectangular bounding area
    */
  def getBounds(targetCoordinateSpace: PIXI.DisplayObject | PIXI.Matrix = js.native): Rectangle = js.native

  /**
    * Returns the child at the specified index
    * @param index the specified index
    * @return The child at the given index, if any.
    */
  def getChildAt(index: Int): DisplayObject = js.native

  /**
    * Returns the index position of a child DisplayObject instance
    * @param child The DisplayObject instance to identify
    * @return The index position of the child display object to identify
    */
  def getChildIndex(child: DisplayObject): Int = js.native

  /**
    * Retrieves the non-global local bounds of the displayObjectContainer as a rectangle
    * without any transformations. The calculation takes all visible children into consideration.
    * @return The rectangular bounding area
    */
  def getLocalBounds(): Rectangle = js.native

  /**
    * Removes a child from the container.
    * @param child The DisplayObject to remove
    * @return The child that was removed.
    */
  def removeChild(child: DisplayObject): DisplayObject = js.native

  /**
    * Removes a child from the specified index position.
    * @param index The index to get the child from
    * @return The child that was removed.
    */
  def removeChildAt(index: Int): DisplayObject = js.native

  /**
    * Removes all children from this container that are within the begin and end indexes.
    * @param beginIndex The beginning position. Default value is 0.
    * @param endIndex   The ending position. Default value is size of the container.
    */
  def removeChildren(beginIndex: Int, endIndex: Int): Unit = js.native

  /**
    * Changes the position of an existing child in the display object container
    * @param child The child DisplayObject instance for which you want to change the index number
    * @param index The resulting index number for the child display object
    */
  def setChildIndex(child: DisplayObject, index: Int): Unit = js.native

  /**
    * Swaps the position of 2 Display Objects within this container.
    * @param child  child 1 of 2
    * @param child2 child 2 of 2
    */
  def swapChildren(child: DisplayObject, child2: DisplayObject): Unit = js.native


}
