package org.scalajs

import org.scalajs.nodejs.timer._

import scala.concurrent.duration.FiniteDuration
import scala.language.implicitConversions
import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * Node.js package Object
  * @author lawrence.daniels@gmail.com
  */
package object nodejs {

  /**
    * Represents a file descriptor
    */
  type FileDescriptor = Integer

  type NodeOptions = js.Dictionary[_]

  /////////////////////////////////////////////////////////////////////////////////
  //      Built-in Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Used to print to stdout and stderr. See the console section.
    */
  @js.native
  @JSName("console")
  object console extends Console

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

  /////////////////////////////////////////////////////////////////////////////////
  //      Implicit Conversions
  /////////////////////////////////////////////////////////////////////////////////

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
