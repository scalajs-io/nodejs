package io.scalajs.npm.numeral

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Numeral - A javascript library for formatting and manipulating numbers.
  * @version 2.0.4
  * @see http://numeraljs.com/
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Numeral extends js.Object {

  def apply(number: js.Any = js.native): NumeralInstance = js.native

  def language(code: String, options: LanguageOptions = js.native): Unit = js.native

}

/**
  * Numeral Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("numeral", JSImport.Namespace)
object Numeral extends Numeral
