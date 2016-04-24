package com.github.ldaniels528.meansjs.nodejs.errors

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Error Class
  * @author lawrence.daniels@gmail.com
  * @see {{{ https://nodejs.org/api/errors.html#errors_class_error }}}
  */
@js.native
trait ErrorClass extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Error.stackTraceLimit
    */
  def stackTraceLimit: Int = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * @example Error.captureStackTrace(targetObject[, constructorOpt])
    */
  def captureStackTrace(targetObject: js.Any): Unit = js.native

  /**
    * @example Error.captureStackTrace(targetObject[, constructorOpt])
    */
  def captureStackTrace(targetObject: js.Any, constructorOpt: js.Any): Unit = js.native

}

/**
  * Error Class Companion
  * @author lawrence.daniels@gmail.com
  */
object ErrorClass {

  /**
    * Error Class Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class ErrorExtensions(val `class`: ErrorClass) extends AnyVal {

    /**
      * Creates a new Error instance
      * @param message the given error message
      * @return a new [[ErrorInstance Error instance]]
      */
    def apply(message: String) = `class`.New[ErrorInstance](message)

  }

}
