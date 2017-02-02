package io.scalajs.npm.numeral

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Numeral Language Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class LanguageOptions(var delimiters: js.UndefOr[js.Dictionary[String]] = js.undefined,
                      var abbreviations: js.UndefOr[js.Dictionary[String]] = js.undefined,
                      var ordinal: js.Function1[Int, String] = null,
                      var currency: js.UndefOr[js.Dictionary[String]] = js.undefined)
    extends js.Object
