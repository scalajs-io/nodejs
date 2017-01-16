package io.scalajs.npm

import scala.scalajs.js
import scala.scalajs.js.JSConverters._
import scala.scalajs.js.UndefOr

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

    def get(styleName: String): UndefOr[Style] = colors.asInstanceOf[js.Dictionary[Style]].get(styleName).orUndefined

  }

  /**
    * Style Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class StyleExtensions(val text: String) extends AnyVal {

    /////////////////////////////////////////////////////////////////////////////////
    //      Background Colors
    /////////////////////////////////////////////////////////////////////////////////

    @inline def bgBlack: Colors.type = Colors.bgBlack(text)

    @inline def bgBlue: Colors.type = Colors.bgBlue(text)

    @inline def bgCyan: Colors.type = Colors.bgCyan(text)

    @inline def bgGreen: Colors.type = Colors.bgGreen(text)

    @inline def bgMagenta: Colors.type = Colors.bgMagenta(text)

    @inline def bgRed: Colors.type = Colors.bgRed(text)

    @inline def bgWhite: Colors.type = Colors.bgWhite(text)

    @inline def bgYellow: Colors.type = Colors.bgYellow(text)

    /////////////////////////////////////////////////////////////////////////////////
    //      Foreground Colors
    /////////////////////////////////////////////////////////////////////////////////

    @inline def black: Colors.type = Colors.black(text)

    @inline def blue: Colors.type = Colors.blue(text)

    @inline def cyan: Colors.type = Colors.cyan(text)

    @inline def gray: Colors.type = Colors.gray(text)

    @inline def green: Colors.type = Colors.green(text)

    @inline def grey: Colors.type = Colors.grey(text)

    @inline def magenta: Colors.type = Colors.magenta(text)

    @inline def red: Colors.type = Colors.red(text)

    @inline def white: Colors.type = Colors.white(text)

    @inline def yellow: Colors.type = Colors.white(text)

    /////////////////////////////////////////////////////////////////////////////////
    //      Styles
    /////////////////////////////////////////////////////////////////////////////////

    @inline def bold: Colors.type = Colors.bold(text)

    @inline def dim: Colors.type = Colors.dim(text)

    @inline def hidden: Colors.type = Colors.hidden(text)

    @inline def inverse: Colors.type = Colors.inverse(text)

    @inline def italic: Colors.type = Colors.italic(text)

    @inline def reset: Colors.type = Colors.reset(text)

    @inline def strikethrough: Colors.type = Colors.strikethrough(text)

    @inline def underline: Colors.type = Colors.underline(text)

    /////////////////////////////////////////////////////////////////////////////////
    //      Styles (Extras)
    /////////////////////////////////////////////////////////////////////////////////

    @inline def america: Colors.type = Colors.america(text)

    @inline def rainbow: Colors.type = Colors.rainbow(text)

    @inline def random: Colors.type = Colors.random(text)

    @inline def trap: Colors.type = Colors.trap(text)

    @inline def zalgo: Colors.type = Colors.zalgo(text)

    @inline def zebra: Colors.type = Colors.zebra(text)

    /////////////////////////////////////////////////////////////////////////////////
    //      Styles (Custom)
    /////////////////////////////////////////////////////////////////////////////////

    @inline
    def styledWith(id: => String): UndefOr[Colors] = {
      val property = js.Object.getOwnPropertyDescriptor(Colors, id)
      val style = property.asInstanceOf[js.UndefOr[Style]]
      style.map(_.value(text))
    }

    @inline def <<=(id: String): UndefOr[Colors] = styledWith(id)

  }

}
