package org.scalajs.dom

import org.scalajs.dom.browser.raw.GenericStringFunction

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * browser package object
  * @author lawrence.daniels@gmail.com
  */
package object browser {

  @js.native
  @JSName("console")
  object console extends org.scalajs.dom.raw.Console

  /////////////////////////////////////////////////////////////////////////////////
  //      Global Functions
  /////////////////////////////////////////////////////////////////////////////////

  @js.native
  @JSName("eval")
  object eval extends Eval

  @js.native
  @JSName("decodeURI")
  object decodeURI extends GenericStringFunction

  @js.native
  @JSName("encodeURI")
  object encodeURI extends GenericStringFunction

  @js.native
  @JSName("decodeURIComponent")
  object decodeURIComponent extends GenericStringFunction

  @js.native
  @JSName("encodeURIComponent")
  object encodeURIComponent extends GenericStringFunction

  @deprecated("Use encodeURI() or encodeURIComponent() instead", since = "1.5")
  @js.native
  @JSName("escape")
  object escape extends GenericStringFunction

  @deprecated("Use decodeURI() or decodeURIComponent() instead", since = "1.5")
  @js.native
  @JSName("unescape")
  object unescape extends GenericStringFunction

  @js.native
  @JSName("window")
  object window extends org.scalajs.dom.raw.Window

}
