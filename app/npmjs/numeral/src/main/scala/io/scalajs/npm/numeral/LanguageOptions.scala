package io.scalajs.npm.numeral

import io.scalajs.FlexibleOptions

import scala.scalajs.js

/**
  * Numeral Language Options
  * @param delimiters
  * @param abbreviations
  * @param ordinal
  * @param currency
  */
class LanguageOptions(var delimiters: js.UndefOr[js.Dictionary[String]] = js.undefined,
                      var abbreviations: js.UndefOr[js.Dictionary[String]] = js.undefined,
                      var ordinal: js.Function1[Int, String] = null,
                      var currency: js.UndefOr[js.Dictionary[String]] = js.undefined)
  extends js.Object

/**
  * Language Options
  * @author lawrence.daniels@gmail.com
  */
object LanguageOptions extends FlexibleOptions[LanguageOptions]