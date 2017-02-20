package io.scalajs.nodejs.vm

import io.scalajs.nodejs.buffer.Buffer

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Script Options
  * @param filename          Specifies the filename used in stack traces produced by this script.
  * @param lineOffset        Specifies the line number offset that is displayed in stack traces produced by this script.
  * @param columnOffset      Specifies the column number offset that is displayed in stack traces produced by this script.
  * @param displayErrors     When true, if an Error error occurs while compiling the code, the line of code causing the error
  *                          is attached to the stack trace.
  * @param timeout           Specifies the number of milliseconds to execute code before terminating execution.
  *                          If execution is terminated, an Error will be thrown.
  * @param cachedData        Provides an optional Buffer with V8's code cache data for the supplied source. When supplied, the
  *                          cachedDataRejected value will be set to either true or false depending on acceptance of the data by V8.
  * @param produceCachedData When true and no cachedData is present, V8 will attempt to produce code cache data for code. Upon success,
  *                          a Buffer with V8's code cache data will be produced and stored in the cachedData property of the returned
  *                          vm.Script instance. The cachedDataProduced value will be set to either true or false depending on whether
  *                          code cache data is produced successfully.
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class ScriptOptions(var filename: js.UndefOr[String] = js.undefined,
                    var lineOffset: js.UndefOr[Int] = js.undefined,
                    var columnOffset: js.UndefOr[Int] = js.undefined,
                    var displayErrors: js.UndefOr[Boolean] = js.undefined,
                    var timeout: js.UndefOr[Int] = js.undefined,
                    var cachedData: js.UndefOr[Buffer] = js.undefined,
                    var produceCachedData: js.UndefOr[Boolean] = js.undefined)
    extends js.Object
