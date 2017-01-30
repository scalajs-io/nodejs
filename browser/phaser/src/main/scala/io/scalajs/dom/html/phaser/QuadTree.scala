package io.scalajs.dom.html.phaser

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName
import scala.scalajs.js.|

/**
  * A QuadTree implementation. The original code was a conversion of the Java code posted to GameDevTuts.
  * However I've tweaked it massively to add node indexing, removed lots of temp. var creation and significantly
  * increased performance as a result.
  * @param x          The top left coordinate of the quadtree.
  * @param y          The top left coordinate of the quadtree.
  * @param width      The width of the quadtree in pixels.
  * @param height     The height of the quadtree in pixels.
  * @param maxObjects The maximum number of objects per node.
  * @param maxLevels  The maximum number of levels to iterate to.
  * @param level      Which level is this?
  * @version 2.6.2
  * @see http://phaser.io/docs/2.6.2/Phaser.QuadTree.html
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSName("Phaser.QuadTree")
class QuadTree(var x: Double,
               var y: Double,
               var width: Double,
               var height: Double,
               var maxObjects: Int = js.native,
               var maxLevels: Int = js.native,
               var level: Int = js.native) extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Object that contains the quadtree bounds.
    */
  var bounds: js.Any = js.native

  /**
    * Array of associated child nodes.
    */
  var nodes: js.Array[_] = js.native

  /**
    * Array of quadtree children.
    */
  var objects: js.Array[_] = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Clear the quadtree.
    */
  def clear(): Unit = js.native

  /**
    * Determine which node the object belongs to.
    * @param rect The bounds in which to check.
    * @return index - Index of the subnode (0-3), or -1 if rect cannot completely fit within a subnode and is
    *         part of the parent node.
    */
  def getIndex(rect: Phaser.Rectangle): Int = js.native

  /**
    * Insert the object into the node. If the node exceeds the capacity, it will split and add all objects to
    * their corresponding subnodes.
    * @param body The Body object to insert into the quadtree. Can be any object so long as it exposes x, y, right
    *             and bottom properties.
    */
  def insert(body: Phaser.Physics.Arcade.Body): Unit = js.native

  /**
    * Populates this quadtree with the children of the given Group. In order to be added the child must exist
    * and have a body property.
    * @param group The Group to add to the quadtree.
    */
  def populate[T](group: Phaser.Group[T]): Unit = js.native

  /**
    * Handler for the populate method.
    * @param sprite The Sprite to check.
    */
  def populateHandler(sprite: Phaser.Sprite): Unit = js.native

  /**
    * Resets the QuadTree.
    * @param x          The top left coordinate of the quadtree.
    * @param y          The top left coordinate of the quadtree.
    * @param width      The width of the quadtree in pixels.
    * @param height     The height of the quadtree in pixels.
    * @param maxObjects The maximum number of objects per node.
    * @param maxLevels  The maximum number of levels to iterate to.
    * @param level      Which level is this?
    */
  def reset(x: Double, y: Double, width: Double, height: Double, maxObjects: Int = js.native, maxLevels: Int = js.native, level: Int = js.native): Unit = js.native

  /**
    * Return all objects that could collide with the given Sprite or Rectangle.
    * @param source The source object to check the QuadTree against. Either a Sprite or Rectangle.
    * @return Array with all detected objects.
    */
  def retrieve[T](source: Phaser.Sprite | Phaser.Rectangle): js.Array[T] = js.native

  /**
    * Split the node into 4 subnodes
    */
  def split(): Unit = js.native

}
