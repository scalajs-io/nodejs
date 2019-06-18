package io.scalajs.dom.html.pixijs

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal
import scala.scalajs.js.|

/**
  * A Container represents a collection of display objects.
  * It is the base class of all display objects that act as a container for other objects.
  */
@js.native
@JSGlobal("PIXI.Container")
class Container extends DisplayObject {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * The opacity of the object.
    */
  var alphanumber: Double = js.native

  /**
    * The array of children of this container.
    */
  def children: js.Array[DisplayObject] = js.native

  /**
    * The area the filter is applied to. This is used as more of an optimisation rather than figuring out the
    * dimensions of the displayObject each frame you can set this rectangle.
    */
  var filterArea: Rectangle = js.native

  /**
    * Sets the filters for the displayObject.
    * IMPORTANT: This is a webGL only feature and will be ignored by the canvas renderer. To remove filters simply
    * set this property to 'null'
    */
  var filters: js.Array[AbstractFilter] = js.native

  /**
    * The height of the Container, setting this will actually modify the scale to achieve the value set.
    */
  var height: Double = js.native

  /**
    * Sets a mask for the displayObject. A mask is an object that limits the visibility of an object to the shape of
    * the mask applied to it. In PIXI a regular mask must be a PIXI.Graphics or a PIXI.Sprite object. This allows for
    * much faster masking in canvas as it utilises shape clipping. To remove a mask, set this property to null.
    */
  var mask: Graphics | Sprite = js.native

  /**
    * The display object container that contains this display object.
    */
  def parent: Container = js.native

  /**
    * The pivot point of the displayObject that it rotates around
    */
  var pivot: Point = js.native

  /**
    * The coordinate of the object relative to the local coordinates of the parent.
    */
  var position: Point = js.native

  /**
    * Can this object be rendered, if false the object will not be drawn but the updateTransform methods will still be called.
    */
  var renderable: Boolean = js.native

  /**
    * The rotation of the object in radians.
    */
  var rotation: Double = js.native

  /**
    * The scale factor of the object.
    */
  var scale: Point = js.native

  /**
    * The width of the Container, setting this will actually modify the scale to achieve the value set.
    */
  var width: Double = js.native

  /**
    * The multiplied alpha of the displayObject.
    */
  def worldAlpha: Alpha = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Adds a child to the container.
    * @param child The DisplayObject to add to the container.
    * @return The child that was added.
    */
  def addChild(child: DisplayObject): DisplayObject = js.native

  /**
    * Adds a child to the container at a specified index. If the index is out of bounds an error will be thrown
    * @param child The DisplayObject to add to the container.
    * @param index The index to place the child in
    * @return The child that was added.
    */
  def addChildAt(child: DisplayObject, index: Int): DisplayObject = js.native

  /**
    * Destroys the container
    * @param destroyChildren optional: if set to true, all the children will have their destroy method called as well
    */
  def destroy(destroyChildren: Boolean): Unit = js.native

}
