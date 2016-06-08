package com.github.ldaniels528.meansjs.nodejs.vm

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Script Context Options
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ContextOptions extends js.Object {

  /**
    * Specifies the filename used in stack traces produced by this script.
    */
  var filename: js.UndefOr[String] = js.native

  /**
    * Specifies the line number offset that is displayed in stack traces produced by this script.
    */
  var lineOffset: js.UndefOr[Int] = js.native

  /**
    * Specifies the column number offset that is displayed in stack traces produced by this script.
    */
  var columnOffset: js.UndefOr[Int] = js.native

  /**
    * When true, if an Error error occurs while compiling the code, the line of code causing the error is attached to
    * the stack trace.
    */
  var displayErrors: js.UndefOr[Boolean] = js.native

  /**
    * Specifies the number of milliseconds to execute code before terminating execution. If execution is terminated,
    * an Error will be thrown.
    */
  var timeout: js.UndefOr[Int] = js.native

}

/**
  * Script Context Options Companion
  * @author lawrence.daniels@gmail.com
  */
object ContextOptions extends js.Object {

  def apply(filename: js.UndefOr[String] = js.undefined,
            lineOffset: js.UndefOr[Int] = js.undefined,
            columnOffset: js.UndefOr[Int] = js.undefined,
            displayErrors: js.UndefOr[Boolean] = js.undefined,
            timeout: js.UndefOr[Int] = js.undefined) = {
    val options = New[ContextOptions]
    options.filename = filename
    options.lineOffset = lineOffset
    options.columnOffset = columnOffset
    options.displayErrors = displayErrors
    options.timeout = timeout
    options
  }

}