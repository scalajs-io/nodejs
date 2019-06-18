package io.scalajs.dom.html

import io.scalajs.dom.{Document, Performance}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * browser package object
  * @author lawrence.daniels@gmail.com
  */
package object browser {

  /////////////////////////////////////////////////////////////////////////////////
  //      Global Properties
  /////////////////////////////////////////////////////////////////////////////////

  @js.native
  @JSGlobal("console")
  object console extends Console

  @js.native
  @JSGlobal("document")
  object document extends Document

  @js.native
  @JSGlobal("location")
  object location extends Location

  @js.native
  @JSGlobal("performance")
  object performance extends Performance

  @js.native
  @JSGlobal("window")
  object window extends Window

  /////////////////////////////////////////////////////////////////////////////////
  //      Global Functions
  /////////////////////////////////////////////////////////////////////////////////

  @js.native
  @JSGlobal("decodeURI")
  object decodeURI extends RawApplyFunction[String, String]

  @js.native
  @JSGlobal("encodeURI")
  object encodeURI extends RawApplyFunction[String, String]

  @js.native
  @JSGlobal("decodeURIComponent")
  object decodeURIComponent extends RawApplyFunction[String, String]

  @js.native
  @JSGlobal("encodeURIComponent")
  object encodeURIComponent extends RawApplyFunction[String, String]

  @js.native
  @JSGlobal("eval")
  object eval extends RawApplyFunction[String, js.Any]

  @js.native
  @JSGlobal("escape")
  object escape extends RawApplyFunction[String, String]

  @js.native
  @JSGlobal("unescape")
  object unescape extends RawApplyFunction[String, String]

}
