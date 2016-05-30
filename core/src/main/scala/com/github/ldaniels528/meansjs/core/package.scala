package com.github.ldaniels528.meansjs

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * MEANS.js Core Package Object
  * @author lawrence.daniels@gmail.com
  */
package object core {

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

}
