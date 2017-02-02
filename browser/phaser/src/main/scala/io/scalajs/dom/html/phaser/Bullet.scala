package io.scalajs.dom.html.phaser

import io.scalajs.JsNumber
import io.scalajs.dom.html.pixijs

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName
import scala.scalajs.js.|

/**
  * Create a new Bullet object. Bullets are used by the Phaser.Weapon class, and are normal Sprites,
  * with a few extra properties in the data object to handle Weapon specific features.
  * @param game  A reference to the currently running game.
  * @param x     The x coordinate (in world space) to position the Particle at.
  * @param y     The y coordinate (in world space) to position the Particle at.
  * @param key   This is the image or texture used by the Particle during rendering. It can be a string which
  *              is a reference to the Cache entry, or an instance of a RenderTexture or PIXI.Texture.
  * @param frame If this Particle is using part of a sprite sheet or texture atlas you can specify the exact
  *              frame to use by giving a string or numeric index.
  * @see http://phaser.io/docs/2.6.2/Phaser.Bullet.html
  */
@js.native
@JSName("Phaser.Bullet")
class Bullet(game: Phaser.Game,
             x: Double,
             y: Double,
             key: String | Phaser.RenderTexture | Phaser.BitmapData | pixijs.Texture,
             frame: JsNumber | String) extends Phaser.Sprite {



}