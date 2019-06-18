package io.scalajs.dom.html.pixijs

import scala.scalajs.js

/**
  * The base class for all objects that are rendered on the screen. This is an abstract class and should not be used
  * on its own rather it should be extended.
  * @author lawrence.daniels@gmail.com
  */
@js.native
//@JSGlobal("PIXI.DisplayObject")
trait DisplayObject extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * The alpha value of the group container.
    */
  var alpha: Alpha = js.native

  /**
    *
    */
  var anchor: Point = js.native

  /**
    * The angle of rotation of the group container, in degrees.
    * This adjusts the group itself by modifying its local rotation transform.
    * This has no impact on the rotation/angle properties of the children, but it will update their worldTransform
    * and on-screen orientation and position.
    */
  def angle: Double = js.native

  /**
    * Set if this display object is cached as a bitmap. This basically takes a snap shot of the display object as it
    * is at that moment. It can provide a performance benefit for complex static displayObjects. To remove simply set
    * this property to 'null'
    */
  var cacheAsBitmap: Boolean = js.native

  /**
    *
    */
  var visible: Boolean = js.native

  /**
    * Current transform of the object based on world (parent) factors
    */
  def worldTransform: Matrix = js.native

  /**
    * Indicates if the sprite is globally visible.
    */
  def worldVisible: Boolean = js.native

  /**
    * The position of the displayObject on the x axis relative to the local coordinates of the parent.
    */
  def x: Double = js.native

  def x_=(x: Double): Unit = js.native

  /**
    * The position of the displayObject on the y axis relative to the local coordinates of the parent.
    */
  def y: Double = js.native

  def y_=(y: Double): Unit = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Base destroy method for generic display objects.
    */
  def destroy(): Unit = js.native

  /**
    * Set the parent Container of this DisplayObject.
    * @param container The Container to add this DisplayObject to.
    * @return The Container that this DisplayObject was added to.
    */
  def setParent(container: Container): Container = js.native

  /**
    * Calculates the global position of the display object.
    * @param position The world origin to calculate from.
    * @return A point object representing the position of this object.
    */
  def toGlobal(position: Point): Point = js.native

  /**
    * Calculates the local position of the display object relative to another point.
    * @param position The world origin to calculate from.
    * @param from     The DisplayObject to calculate the global position from.
    * @return A point object representing the position of this object.
    */
  def toLocal(position: Point, from: DisplayObject = null): Point = js.native

}