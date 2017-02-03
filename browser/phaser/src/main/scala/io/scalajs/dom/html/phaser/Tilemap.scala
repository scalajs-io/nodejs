package io.scalajs.dom.html.phaser

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * Creates a new Phaser.Tilemap object. The map can either be populated with data from a Tiled JSON file or from a CSV file.
  *
  * Tiled is a free software package specifically for creating tile maps, and is available from http://www.mapeditor.org
  *
  * To do this pass the Cache key as the first parameter. When using Tiled data you need only provide the key.
  * When using CSV data you must provide the key and the tileWidth and tileHeight parameters.
  * If creating a blank tilemap to be populated later, you can either specify no parameters at
  * all and then use Tilemap.create or pass the map and tile dimensions here.
  *
  * Note that all Tilemaps use a base tile size to calculate dimensions from, but that a
  * TilemapLayer may have its own unique tile size that overrides it.
  *
  * A Tile map is rendered to the display using a TilemapLayer. It is not added to the display list directly itself.
  * A map may have multiple layers. You can perform operations on the map data such as copying,
  * pasting, filling and shuffling the tiles around.
  * @param game       Game reference to the currently running game.
  * @param key        The key of the tilemap data as stored in the Cache. If you're creating a blank map
  *                   either leave this parameter out or pass null.
  * @param tileWidth  The pixel width of a single map tile. If using CSV data you must specify this.
  *                   Not required if using Tiled map data.
  * @param tileHeight The pixel height of a single map tile. If using CSV data you must specify this.
  *                   Not required if using Tiled map data.
  * @param width      The width of the map in tiles. If this map is created from Tiled or CSV data
  *                   you don't need to specify this.
  * @param height     The height of the map in tiles. If this map is created from Tiled or CSV data
  *                   you don't need to specify this.
  * @see http://phaser.io/docs/2.6.2/Phaser.Tilemap.html
  */
@js.native
@JSName("Phaser.Tilemap")
class Tilemap(var game: Phaser.Game,
              var key: String = js.native,
              var tileWidth: Double = js.native,
              var tileHeight: Double = js.native,
              var width: Double = js.native,
              var height: Double = js.native) extends js.Object {

  /**
    * An array of tile indexes that collide.
    */
  var collideIndexes: js.Array[Int] = js.native

  /**
    * An array of collision data (polylines, etc).
    */
  var collision: js.Array[_] = js.native

  /**
    * The current layer.
    */
  var currentLayer: Int = js.native

  /**
    * Map data used for debug values only.
    */
  var debugMap: js.Array[_] = js.native

  /**
    * If set then console.log is used to dump out useful layer creation debug data.
    */
  var enableDebug: Boolean = js.native

}

/**
  * Tilemap Singleton
  */
@js.native
@JSName("Phaser.Tilemap")
object Tilemap extends js.Object {

  /**
    *
    */
  val CSV: Int = js.native

  /**
    *
    */
  val EAST: Int = js.native

  /**
    *
    */
  val NORTH: Int = js.native

  /**
    *
    */
  val SOUTH: Int = js.native

  /**
    *
    */
  val TILED_JSON: Int = js.native

  /**
    *
    */
  val WEST: Int = js.native

}