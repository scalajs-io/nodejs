package io.scalajs.dom.html.phaser

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * Phaser has one single cache in which it stores all assets.
  *
  * The cache is split up into sections, such as images, sounds, video, json, etc. All assets are stored using
  * a unique string-based key as their identifier. Assets stored in different areas of the cache can have the
  * same key, for example 'playerWalking' could be used as the key for both a sprite sheet and an audio file,
  * because they are unique data types.
  *
  * The cache is automatically populated by the Phaser.Loader. When you use the loader to pull in external assets
  * such as images they are automatically placed into their respective cache. Most common Game Objects, such as
  * Sprites and Videos automatically query the cache to extract the assets they need on instantiation.
  *
  * You can access the cache from within a State via this.cache. From here you can call any public method it has,
  * including adding new entries to it, deleting them or querying them.
  *
  * Understand that almost without exception when you get an item from the cache it will return a reference to the
  * item stored in the cache, not a copy of it. Therefore if you retrieve an item and then modify it, the original
  * object in the cache will also be updated, even if you don't put it back into the cache again.
  *
  * By default when you change State the cache is not cleared, although there is an option to clear it should
  * your game require it. In a typical game set-up the cache is populated once after the main game has loaded and
  * then used as an asset store.
  * @see https://phaser.io/docs/2.6.2/Phaser.Cache.html
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSName("Phaser.Cache")
class Cache(var game: Phaser.Game) extends js.Object {}

@js.native
@JSName("Phaser.Cache")
object Cache extends js.Object {
  val BINARY: Int     = js.native
  val BITMAPDATA: Int = js.native
  val BITMAPFONT: Int = js.native
  val CANVAS: Int     = js.native

}
