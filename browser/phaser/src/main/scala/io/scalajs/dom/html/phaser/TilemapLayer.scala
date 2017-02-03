package io.scalajs.dom.html.phaser

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSName, ScalaJSDefined}
import scala.scalajs.js.|

/**
  * A TilemapLayer is a Phaser.Image/Sprite that renders a specific TileLayer of a Tilemap.
  *
  * Since a TilemapLayer is a Sprite it can be moved around the display, added to other
  * groups or display objects, etc.
  *
  * By default TilemapLayers have fixedToCamera set to true. Changing this will break
  * Camera follow and scrolling behavior.
  * @param game    Game reference to the currently running game.
  * @param tilemap The tilemap to which this layer belongs.
  * @param index   The index of the TileLayer to render within the Tilemap.
  * @param width   Width of the renderable area of the layer (in pixels).
  * @param height  Height of the renderable area of the layer (in pixels).
  * @see http://phaser.io/docs/2.6.2/Phaser.TilemapLayer.html
  */
@js.native
@JSName("Phaser.TilemapLayer")
class TilemapLayer(game: Phaser.Game,
                   var tilemap: Phaser.Tilemap,
                   var index: Int,
                   width: Double,
                   height: Double) extends Phaser.Sprite {

  /**
    * Settings used for debugging and diagnostics.
    */
  var debugSettings: DebugSettings = js.native

}

/**
  * Settings used for debugging and diagnostics.
  * @param missingImageFill      A tile is rendered as a rectangle using the following fill if a valid
  *                              tileset/image cannot be found. A value of null prevents additional
  *                              rendering for tiles without a valid tileset image. This takes effect
  *                              even when debug rendering for the layer is not enabled.
  * @param debuggedTileOverfill  If a Tile has Tile#debug true then, after normal tile image rendering,
  *                              a rectangle with the following fill is drawn above/over it. This takes
  *                              effect even when debug rendering for the layer is not enabled.
  * @param forceFullRedraw       When debug rendering (debug is true), and this option is enabled,
  *                              a full redraw is forced and rendering optimization is suppressed.
  * @param debugAlpha            When debug rendering (debug is true), the tileset is initially rendered
  *                              with this alpha level. This can make the tile edges clearer.
  * @param facingEdgeStroke      When debug rendering (debug is true), this color/stroke is used to draw
  *                              "face" edges. A value of null disables coloring facing edges.
  * @param collidingTileOverfill When debug rendering (debug is true), this fill is used for tiles that are
  *                              collidable. A value of null disables applying the additional overfill.
  */
@ScalaJSDefined
class DebugSettings(var missingImageFill: js.UndefOr[String] = js.undefined,
                    var debuggedTileOverfill: js.UndefOr[String] = js.undefined,
                    var forceFullRedraw: js.UndefOr[Boolean] = js.undefined,
                    var debugAlpha: js.UndefOr[Double | Int] = js.undefined,
                    var facingEdgeStroke: js.UndefOr[String] = js.undefined,
                    var collidingTileOverfill: js.UndefOr[String] = js.undefined) extends js.Object