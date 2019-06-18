package io.scalajs.npm.chalk

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * chalk - Terminal string styling done right. Much color.
  * @see https://www.npmjs.com/package/chalk
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Chalk extends js.Object {

  def apply(text: js.Any*): String = js.native

  def bgBlack: this.type = js.native

  def bgBlue: this.type = js.native

  def bgCyan: this.type = js.native

  def bgGray: this.type = js.native

  def bgGreen: this.type = js.native

  def bgRed: this.type = js.native

  def bgMagenta: this.type = js.native

  def bgWhite: this.type = js.native

  def bgYellow: this.type = js.native

  def black: this.type = js.native

  def blue: this.type = js.native

  def bold: this.type = js.native

  def cyan: this.type = js.native

  def dim: this.type = js.native

  def gray: this.type = js.native

  def green: this.type = js.native

  def inverse: this.type = js.native

  def italic: this.type = js.native

  def magenta: this.type = js.native

  def red: this.type = js.native

  def reset: this.type = js.native

  def strikethrough: this.type = js.native

  def underline: this.type = js.native

  def white: this.type = js.native

  def yellow: this.type = js.native

}

/**
  * Chalk Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("chalk", JSImport.Namespace)
object Chalk extends Chalk
