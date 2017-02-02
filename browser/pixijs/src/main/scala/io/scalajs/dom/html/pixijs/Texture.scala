package io.scalajs.dom.html.pixijs

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * A texture stores the information that represents an image or part of an image. It cannot be added to the display
  * list directly. Instead use it as the texture for a Sprite. If no frame is provided then the whole image is used.
  * @param baseTexture The base texture source to create the texture from
  * @param frame       The rectangle frame of the texture to show
  * @param crop        The area of original texture
  * @param trim        Trimmed texture rectangle
  * @param rotate      indicates whether the texture should be rotated by 90 degrees ( used by texture packer )
  */
@js.native
@JSName("Texture")
class Texture(var baseTexture: BaseTexture,
              var frame: Rectangle = js.native,
              var crop: Rectangle = js.native,
              var trim: Rectangle = js.native,
              var rotate: Rectangle = js.native)
    extends BaseTexture

/**
  * Texture Singleton
  */
@js.native
@JSName("Texture")
object Texture extends js.Object {

  /**
    * An empty texture, used often to not have to create multiple empty textures.
    */
  val EMPTY: js.Any = js.native

}
