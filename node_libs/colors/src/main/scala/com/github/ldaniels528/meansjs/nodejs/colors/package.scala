package com.github.ldaniels528.meansjs.nodejs

import scala.scalajs.js
import scala.scalajs.js.JSConverters._

/**
  * Colors package object
  * @author lawrence.daniels@gmail.com
  */
package object colors {

  /**
    * Colors Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class ColorExtensions(val colors: Colors) extends AnyVal {

    def get(styleName: String) = colors.asInstanceOf[js.Dictionary[Style]].get(styleName).orUndefined

  }

  /**
    * Style Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class StyleExtensions(val text: String) extends AnyVal {

    /////////////////////////////////////////////////////////////////////////////////
    //      Background Colors
    /////////////////////////////////////////////////////////////////////////////////

    @inline def bgBlack(implicit colors: Colors) = colors.bgBlack(text)

    @inline def bgBlue(implicit colors: Colors) = colors.bgBlue(text)

    @inline def bgCyan(implicit colors: Colors) = colors.bgCyan(text)

    @inline def bgGreen(implicit colors: Colors) = colors.bgGreen(text)

    @inline def bgMagenta(implicit colors: Colors) = colors.bgMagenta(text)

    @inline def bgRed(implicit colors: Colors) = colors.bgRed(text)

    @inline def bgWhite(implicit colors: Colors) = colors.bgWhite(text)

    @inline def bgYellow(implicit colors: Colors) = colors.bgYellow(text)

    /////////////////////////////////////////////////////////////////////////////////
    //      Foreground Colors
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
    //      Styles
    /////////////////////////////////////////////////////////////////////////////////

    @inline def bold(implicit colors: Colors) = colors.bold(text)

    @inline def dim(implicit colors: Colors) = colors.dim(text)

    @inline def hidden(implicit colors: Colors) = colors.hidden(text)

    @inline def inverse(implicit colors: Colors) = colors.inverse(text)

    @inline def italic(implicit colors: Colors) = colors.italic(text)

    @inline def reset(implicit colors: Colors) = colors.reset(text)

    @inline def strikethrough(implicit colors: Colors) = colors.strikethrough(text)

    @inline def underline(implicit colors: Colors) = colors.underline(text)

    /////////////////////////////////////////////////////////////////////////////////
    //      Styles (Extras)
    /////////////////////////////////////////////////////////////////////////////////

    @inline def america(implicit colors: Colors) = colors.america(text)

    @inline def rainbow(implicit colors: Colors) = colors.rainbow(text)

    @inline def random(implicit colors: Colors) = colors.random(text)

    @inline def trap(implicit colors: Colors) = colors.trap(text)

    @inline def zalgo(implicit colors: Colors) = colors.zalgo(text)

    @inline def zebra(implicit colors: Colors) = colors.zebra(text)

    /////////////////////////////////////////////////////////////////////////////////
    //      Styles (Custom)
    /////////////////////////////////////////////////////////////////////////////////

    @inline
    def styledWith(id: => String)(implicit colors: Colors) = {
      val style = js.Object.getOwnPropertyDescriptor(colors, id).asInstanceOf[js.UndefOr[Style]]
      style.map(_.value(text))
    }

    @inline def <<=(id: String)(implicit colors: Colors) = styledWith(id)

  }

}
