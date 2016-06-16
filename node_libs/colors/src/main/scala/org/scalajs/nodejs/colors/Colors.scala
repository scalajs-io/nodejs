package org.scalajs.nodejs.colors

import org.scalajs.nodejs.{NodeModule, NodeRequire}

import scala.scalajs.js

/**
  * colors - get colors in your node.js console
  * @version 1.1.2
  * @see https://www.npmjs.com/package/colors
  */
@js.native
trait Colors extends NodeModule {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  def enabled: Boolean = js.native

  def styles: js.Dictionary[js.Array[js.Any]] = js.native

  def supportsColor: Boolean = js.native

  def themes: js.Dictionary[js.Object] = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  def apply(text: String): this.type = js.native

  def setTheme: js.Function1[js.Any, Colors] = js.native

  def strip: js.Function1[String, String] = js.native

  def stripColors: js.Function1[String, String] = js.native

  def stylize: js.Function2[String, Style, String] = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Background Colors
  /////////////////////////////////////////////////////////////////////////////////

  def bgBlack: this.type = js.native

  def bgBlue: this.type = js.native

  def bgCyan: this.type = js.native

  def bgGreen: this.type = js.native

  def bgMagenta: this.type = js.native

  def bgRed: this.type = js.native

  def bgWhite: this.type = js.native

  def bgYellow: this.type = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Foreground Colors
  /////////////////////////////////////////////////////////////////////////////////

  def black: this.type = js.native

  def blue: this.type = js.native

  def cyan: this.type = js.native

  def gray: this.type = js.native

  def green: this.type = js.native

  def grey: this.type = js.native

  def magenta: this.type = js.native

  def red: this.type = js.native

  def white: this.type = js.native

  def yellow: this.type = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Styles
  /////////////////////////////////////////////////////////////////////////////////

  def bold: this.type = js.native

  def dim: this.type = js.native

  def hidden: this.type = js.native

  def inverse: this.type = js.native

  def italic: this.type = js.native

  def reset: this.type = js.native

  def strikethrough: this.type = js.native

  def underline: this.type = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Styles (Extras)
  /////////////////////////////////////////////////////////////////////////////////

  def america: this.type = js.native

  def rainbow: this.type = js.native

  def random: this.type = js.native

  def trap: this.type = js.native

  def zalgo: this.type = js.native

  def zebra: this.type = js.native

}

/**
  * Colors Companion
  * @author lawrence.daniels@gmail.com
  */
object Colors {

  /**
    * Convenience method for retrieving the colors module
    * @param require the implicit [[NodeRequire require function]]
    * @return the Colors instance
    */
  def apply()(implicit require: NodeRequire) = require[Colors]("colors")

}