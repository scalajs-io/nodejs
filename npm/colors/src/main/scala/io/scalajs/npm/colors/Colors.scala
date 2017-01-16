package io.scalajs.npm.colors

import io.scalajs.nodejs.NodeOptions

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * colors - get colors in your node.js console
  * @version 1.1.2
  * @see https://www.npmjs.com/package/colors
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("colors", JSImport.Namespace)
object Colors extends Colors

/**
  * Colors type definition
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Colors extends js.Object {

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

  def setTheme(theme: NodeOptions): Colors = js.native

  def strip(text: String): String = js.native

  def stripColors(text: String): String = js.native

  def stylize(text: String, style: Style): String = js.native

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
