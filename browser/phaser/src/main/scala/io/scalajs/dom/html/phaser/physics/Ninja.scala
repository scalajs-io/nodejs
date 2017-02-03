package io.scalajs.dom.html.phaser
package physics

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName
import scala.scalajs.js.|

/**
  * Ninja Physics. The Ninja Physics system was created in Flash by Metanet Software
  * and ported to JavaScript by Richard Davey.
  *
  * It allows for AABB and Circle to Tile collision. Tiles can be any of 34 different types,
  * including slopes, convex and concave shapes.
  * *
  * It does what it does very well, but is ripe for expansion and optimisation. Here are some
  * features that I'd love to see the community add:
  * <ul>
  * <li>AABB to AABB collision</li>
  * <li>AABB to Circle collision</li>
  * <li>AABB and Circle 'immovable' property support</li>
  * <li>n-way collision, so an AABB/Circle could pass through a tile from below and land upon it.</li>
  * <li>QuadTree or spatial grid for faster Body vs. Tile Group look-ups.</li>
  * <li>Optimise the internal vector math and reduce the quantity of temporary vars created.</li>
  * <li>Expand Gravity and Bounce to allow for separate x/y axis values.</li>
  * <li>Support Bodies linked to Sprites that don't have anchor set to 0.5</li>
  * </ul>
  * Feel free to attempt any of the above and submit a Pull Request with your code! Be sure
  * to include test cases proving they work.
  * @see http://phaser.io/docs/2.6.2/Phaser.Physics.Ninja.html
  */
@js.native
@JSName("Phaser.Physics.Ninja")
class Ninja(var game: Phaser.Game) extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * The bounds inside of which the physics world exists. Defaults to match the world bounds.
    */
  var bounds: Phaser.Rectangle = js.native

  /**
    * The World gravity setting.
    */
  var gravity: Double = js.native

  /**
    * Used by the QuadTree to set the maximum number of iteration levels.
    */
  var maxLevels: Int = js.native

  /**
    * Used by the QuadTree to set the maximum number of objects per quad.
    */
  var maxObjects: Int = js.native

  /**
    * The world QuadTree.
    */
  var quadTree: Phaser.QuadTree = js.native

  /**
    * Local reference to game.time.
    */
  var time: Phaser.Time = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    *
    * @param map
    * @param layer
    */
  def clearTilemapLayerBodies(map: Phaser.Tilemap, layer: Double | String | Phaser.TilemapLayer): Unit = js.native

}
