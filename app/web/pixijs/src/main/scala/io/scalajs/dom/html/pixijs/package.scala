package io.scalajs.dom.html

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * pixijs package object
  * @author lawrence.daniels@gmail.com
  */
package object pixijs {

  type Alpha = Double

  type BlendMode = Int

  type Color = Int

  type GraphicalShape = Circle | Ellipse | Polygon | Rectangle

  type LineWidth = Int

  type Padding = Int

  type Resolution = Int

  /**
    * BaseTexture Events
    * @param texture the given [[BaseTexture texture]]
    */
  final implicit class BaseTextureEvents(val texture: BaseTexture) extends AnyVal {

    /**
      * Fired when a not-immediately-available source fails to load.
      * @param callback the event handler
      */
    def onError(callback: js.Function): texture.type = texture.on("error", callback)

    /**
      * Fired when a not-immediately-available source finishes loading.
      * @param callback the event handler
      */
    def onLoaded(callback: js.Function): texture.type = texture.on("loaded", callback)

  }

}
