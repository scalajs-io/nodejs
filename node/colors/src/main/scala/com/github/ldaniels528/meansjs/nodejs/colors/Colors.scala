package com.github.ldaniels528.meansjs.nodejs.colors

import com.github.ldaniels528.meansjs.nodejs.NodeModule

import scala.scalajs.js

/**
  * Colors
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Colors extends NodeModule {

  /////////////////////////////////////////////////////////////////////////////////
  //      Colors (Pre-defined)
  /////////////////////////////////////////////////////////////////////////////////

  def black: this.type = js.native

  def black(text: String): this.type = js.native

  def blue: this.type = js.native

  def blue(text: String): this.type = js.native

  def cyan: this.type = js.native

  def cyan(text: String): this.type = js.native

  def gray: this.type = js.native

  def gray(text: String): this.type = js.native

  def green: this.type = js.native

  def green(text: String): this.type = js.native

  def grey: this.type = js.native

  def grey(text: String): this.type = js.native

  def magenta: this.type = js.native

  def magenta(text: String): this.type = js.native

  def red: this.type = js.native

  def red(text: String): this.type = js.native

  def white: this.type = js.native

  def white(text: String): this.type = js.native

  def yellow: this.type = js.native

  def yellow(text: String): this.type = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Styles (Custom)
  /////////////////////////////////////////////////////////////////////////////////

  def inverse: this.type = js.native

  def inverse(text: String): this.type = js.native

  def rainbow: this.type = js.native

  def rainbow(text: String): this.type = js.native

  def trap: this.type = js.native

  def trap(text: String): this.type = js.native

  def underline: this.type = js.native

  def underline(text: String): this.type = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Themes (Pre-defined)
  /////////////////////////////////////////////////////////////////////////////////

  def setTheme(options: js.Dictionary[js.Any]): this.type = js.native

}

/**
  * Colors Companion
  * @author lawrence.daniels@gmail.com
  */
object Colors {

  /**
    * Color Style
    * @author lawrence.daniels@gmail.com
    */
  @js.native
  trait Style extends js.Object {

    def value: js.Function1[js.Any, js.Any] = js.native

  }

  /**
    * Colors Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class ColorExtensions(val text: String) extends AnyVal {

    /////////////////////////////////////////////////////////////////////////////////
    //      Colors (Pre-defined)
    /////////////////////////////////////////////////////////////////////////////////

    @inline def black(implicit colors: Colors) = colors.black(text)

    @inline def blue(implicit colors: Colors) = colors.blue(text)

    @inline def cyan(implicit colors: Colors) = colors.cyan(text)

    @inline def gray(implicit colors: Colors) = colors.gray(text)

    @inline def green(implicit colors: Colors) = colors.green(text)

    @inline def grey(implicit colors: Colors) = colors.grey(text)

    @inline def magenta(implicit colors: Colors) = colors.magenta(text)

    @inline def red(implicit colors: Colors) = colors.red(text)

    @inline def white(implicit colors: Colors) = colors.white(text)

    @inline def yellow(implicit colors: Colors) = colors.white(text)

    /////////////////////////////////////////////////////////////////////////////////
    //      Styles (Custom)
    /////////////////////////////////////////////////////////////////////////////////

    @inline
    def using(id: => String)(implicit colors: Colors) = {
      val style = js.Object.getOwnPropertyDescriptor(colors, id).asInstanceOf[js.UndefOr[Style]]
      style.map(_.value(id).asInstanceOf[colors.type])
    }

    @inline def =/>(id: String)(implicit colors: Colors) = using(id)

    /////////////////////////////////////////////////////////////////////////////////
    //      Themes  (Pre-defined)
    /////////////////////////////////////////////////////////////////////////////////

    @inline def inverse(implicit colors: Colors) = colors.inverse(text)

    @inline def rainbow(implicit colors: Colors) = colors.rainbow(text)

    @inline def trap(implicit colors: Colors) = colors.trap(text)

    @inline def underline(implicit colors: Colors) = colors.underline(text)

  }

}