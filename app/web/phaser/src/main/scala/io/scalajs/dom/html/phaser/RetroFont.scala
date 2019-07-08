package io.scalajs.dom.html.phaser

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * A Retro Font is similar to a BitmapFont, in that it uses a texture to render the text. However unlike a
  * BitmapFont every character in a RetroFont is the same size. This makes it similar to a sprite sheet.
  * You typically find font sheets like this from old 8/16-bit games and demos.
  * @param game            Current game instance.
  * @param key             The font set graphic set as stored in the Game.Cache.
  * @param characterWidth  The width of each character in the font set.
  * @param characterHeight The height of each character in the font set.
  * @param chars           The characters used in the font set, in display order. You can use the TEXT_SET consts for
  *                        common font set arrangements.
  * @param charsPerRow     The number of characters per row in the font set. If not given charsPerRow will be the
  *                        image width / characterWidth.
  * @param xSpacing        If the characters in the font set have horizontal spacing between them set the required amount here.
  * @param ySpacing        If the characters in the font set have vertical spacing between them set the required amount here.
  * @param xOffset         If the font set doesn't start at the top left of the given image, specify the X coordinate offset here.
  * @param yOffset         If the font set doesn't start at the top left of the given image, specify the Y coordinate offset here.
  * @see [[https://phaser.io/docs/2.6.2/Phaser.RetroFont.html]]
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSGlobal("Phaser.RetroFont")
class RetroFont(game: Phaser.Game,
                key: String,
                characterWidth: Double,
                characterHeight: Double,
                chars: String,
                charsPerRow: Int,
                xSpacing: Double,
                ySpacing: Double,
                xOffset: Double,
                yOffset: Double) extends RenderTexture
