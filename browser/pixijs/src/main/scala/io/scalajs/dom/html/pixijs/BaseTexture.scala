package io.scalajs.dom.html.pixijs

import io.scalajs.dom.html.Image
import io.scalajs.dom.html.canvas.HTMLCanvasElement

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName
import scala.scalajs.js.|

/**
  * A texture stores the information that represents an image. All textures have a base texture.
  */
@js.native
@JSName("PIXI.BaseTexture")
class BaseTexture extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Set to true once the base texture has successfully loaded.
    * This is never true if the underlying source fails to load or has no texture data.
    */
  def hasLoaded: Boolean = js.native

  /**
    * The height of the base texture set when the image has loaded
    */
  def height: Double = js.native

  /**
    * TODO
    */
  var imageUrlstring: String = js.native

  /**
    * Set to true if the source is currently loading.
    * If an Image source is loading the 'loaded' or 'error' event will be dispatched when the operation ends.
    * An underyling source that is immediately-available bypasses loading entirely.
    */
  def isLoading: Boolean = js.native

  /**
    * Set this to true if a mipmap of this texture needs to be generated. This value needs to be set before the
    * texture is used Also the texture must be a power of two size to work.
    */
  var mipmap: Boolean = js.native

  /**
    * Controls if RGB channels should be pre-multiplied by Alpha (WebGL only)
    */
  var premultipliedAlpha: Boolean = js.native

  /**
    * Used to store the actual height of the source of this texture
    */
  def realHeight: Double = js.native

  /**
    * Used to store the actual width of the source of this texture
    */
  def realWidth: Double = js.native

  /**
    * The Resolution of the texture.
    */
  var resolution: Resolution = js.native

  /**
    * The scale mode to apply when scaling this texture
    * @see [[PIXI.SCALE_MODES]]
    */
  var scaleMode: Int = js.native

  /**
    * The image source that is used to create the texture.
    * @return an image or the canvas
    */
  def source: js.Any = js.native

  /**
    * The width of the base texture set when the image has loaded
    */
  def width: Double = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Destroys this base texture
    */
  def destroy(): Unit = js.native

  /**
    * Frees the texture from WebGL memory without destroying this texture object. This means you can still use the
    * texture later which will upload it to GPU memory again.
    */
  def dispose(): Unit = js.native

  /**
    * Load a source.
    * If the source is not-immediately-available, such as an image that needs to be downloaded, then the 'loaded'
    * or 'error' event will be dispatched in the future and hasLoaded will remain false after this call.
    * @param source the source object of the texture.
    */
  def loadSource(source: Image | HTMLCanvasElement): Unit = js.native

  /**
    * Updates the texture on all the webgl renderers, this also assumes the src has changed.
    */
  def update(): Unit = js.native

  /**
    * Changes the source image of the texture. The original source must be an Image element.
    * @param newSrc the path of the image
    */
  def updateSourceImage(newSrc: String): Unit = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Events
  /////////////////////////////////////////////////////////////////////////////////

  def on(event: String, callback: js.Function): this.type = js.native

}

/**
  * BaseTexture Singleton
  */
@js.native
@JSName("PIXI.BaseTexture")
object BaseTexture extends js.Object {

  /**
    * Helper function that creates a base texture from the given canvas element.
    * @param canvas    The canvas element source of the texture
    * @param scaleMode @see [[PIXI.SCALE_MODES]]
    * @return the base texture
    */
  def fromCanvas(canvas: HTMLCanvasElement, scaleMode: Int = PIXI.SCALE_MODES.DEFAULT): BaseTexture = js.native

  /**
    * Helper function that creates a base texture from the given image url. If the image is not in the base texture
    * cache it will be created and loaded.
    * @param imageUrl    The image url of the texture
    * @param crossorigin Should use anonymous CORS? Defaults to true if the URL is not a data-URI.
    * @param scaleMode   @see [[PIXI.SCALE_MODES]]
    * @return the base texture
    */
  def fromImage(imageUrl: String,
                crossorigin: Boolean = false,
                scaleMode: Int = PIXI.SCALE_MODES.DEFAULT): BaseTexture = js.native

}
