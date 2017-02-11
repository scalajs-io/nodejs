package io.scalajs.dom.html

import io.scalajs.dom.Performance

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * browser package object
  * @author lawrence.daniels@gmail.com
  */
package object browser {

  /////////////////////////////////////////////////////////////////////////////////
  //      Global Properties
  /////////////////////////////////////////////////////////////////////////////////

  @js.native
  @JSName("console")
  object console extends Console

  @js.native
  @JSName("location")
  object location extends Location

  @js.native
  @JSName("performance")
  object performance extends Performance

  @js.native
  @JSName("window")
  object window extends Window

  /////////////////////////////////////////////////////////////////////////////////
  //      Global Functions
  /////////////////////////////////////////////////////////////////////////////////

  @js.native
  @JSName("decodeURI")
  object decodeURI extends RawApplyFunction[String, String]

  @js.native
  @JSName("encodeURI")
  object encodeURI extends RawApplyFunction[String, String]

  @js.native
  @JSName("decodeURIComponent")
  object decodeURIComponent extends RawApplyFunction[String, String]

  @js.native
  @JSName("encodeURIComponent")
  object encodeURIComponent extends RawApplyFunction[String, String]

  @js.native
  @JSName("eval")
  object eval extends RawApplyFunction[String, js.Any]

  @js.native
  @JSName("escape")
  object escape extends RawApplyFunction[String, String]

  @js.native
  @JSName("unescape")
  object unescape extends RawApplyFunction[String, String]

}
