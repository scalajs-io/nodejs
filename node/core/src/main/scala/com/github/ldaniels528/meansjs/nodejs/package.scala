package com.github.ldaniels528.meansjs

import com.github.ldaniels528.meansjs.nodejs.errors
import com.github.ldaniels528.meansjs.nodejs.timer._

import scala.concurrent.duration.FiniteDuration
import scala.language.implicitConversions
import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * Node.js Pacakage Object
  * @author lawrence.daniels@gmail.com
  */
package object nodejs {

  /////////////////////////////////////////////////////////////////////////////////
  //      Built-in Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Used to print to stdout and stderr. See the console section.
    */
  @js.native
  @JSName("console")
  object console extends Console

  /**
    * In browsers, the top-level scope is the global scope. That means that in browsers if you're in the global scope
    * var something will define a global variable. In Node.js this is different. The top-level scope is not the global
    * scope; var something inside an Node.js module will be local to that module.
    */
  @js.native
  @JSName("global")
  object global extends js.Object

  /**
    * The process object. See the process object section.
    */
  @js.native
  @JSName("process")
  object process extends ProcessClass

  /////////////////////////////////////////////////////////////////////////////////
  //      Timers
  /////////////////////////////////////////////////////////////////////////////////

  @js.native
  @JSName("clearImmediate")
  object clearImmediate extends ClearImmediate

  @js.native
  @JSName("clearInterval")
  object clearInterval extends ClearInterval

  @js.native
  @JSName("clearTimeout")
  object clearTimeout extends ClearTimeout

  @js.native
  @JSName("ref")
  object ref extends Ref

  @js.native
  @JSName("setImmediate")
  object setImmediate extends SetImmediate

  @js.native
  @JSName("setInterval")
  object setInterval extends SetInterval

  @js.native
  @JSName("setTimeout")
  object setTimeout extends SetTimeout

  @js.native
  @JSName("unref")
  object unref extends UnRef

  /**
    * Implicit conversation to translate durations into an integer
    * @param duration the given [[FiniteDuration duration]]
    * @return the time in milliseconds as an integer
    */
  implicit def duration2Int(duration: FiniteDuration): Int = duration.toMillis.toInt

  /**
    * Implicit conversation to translate durations into a double
    * @param duration the given [[FiniteDuration duration]]
    * @return the time in milliseconds as a double
    */
  implicit def duration2Double(duration: FiniteDuration): Double = duration.toMillis.toDouble

}
