package com.github.ldaniels528.meansjs.nodejs.vm

import com.github.ldaniels528.meansjs.nodejs.buffer.Buffer
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Script Options
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ScriptOptions extends js.Object {

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

  /**
    * Provides an optional Buffer with V8's code cache data for the supplied source. When supplied, the
    * cachedDataRejected value will be set to either true or false depending on acceptance of the data by V8.
    */
  var cachedData: js.UndefOr[Buffer] = js.native

  /**
    * When true and no cachedData is present, V8 will attempt to produce code cache data for code. Upon success,
    * a Buffer with V8's code cache data will be produced and stored in the cachedData property of the returned
    * vm.Script instance. The cachedDataProduced value will be set to either true or false depending on whether
    * code cache data is produced successfully.
    */
  var produceCachedData: js.UndefOr[Boolean] = js.native

}

/**
  * Script Options Companion
  * @author lawrence.daniels@gmail.com
  */
object ScriptOptions extends js.Object {

  def apply(filename: js.UndefOr[String] = js.undefined,
            lineOffset: js.UndefOr[Int] = js.undefined,
            columnOffset: js.UndefOr[Int] = js.undefined,
            displayErrors: js.UndefOr[Boolean] = js.undefined,
            timeout: js.UndefOr[Int] = js.undefined,
            cachedData: js.UndefOr[Buffer] = js.undefined,
            produceCachedData: js.UndefOr[Boolean] = js.undefined) = {
    val options = New[ScriptOptions]
    options.filename = filename
    options.lineOffset = lineOffset
    options.columnOffset = columnOffset
    options.displayErrors = displayErrors
    options.timeout = timeout
    options.cachedData = cachedData
    options.produceCachedData = produceCachedData
    options
  }

}