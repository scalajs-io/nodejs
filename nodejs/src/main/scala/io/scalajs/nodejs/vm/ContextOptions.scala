package io.scalajs.nodejs.vm

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Script Context Options
  * @param filename      Specifies the filename used in stack traces produced by this script.
  * @param lineOffset    Specifies the line number offset that is displayed in stack traces produced by this script.
  * @param columnOffset  Specifies the column number offset that is displayed in stack traces produced by this script.
  * @param displayErrors When true, if an Error error occurs while compiling the code, the line of code causing the error
  *                      is attached to the stack trace.
  * @param timeout       Specifies the number of milliseconds to execute code before terminating execution. If execution
  *                      is terminated, an Error will be thrown.
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class ContextOptions(var filename: js.UndefOr[String] = js.undefined,
                     var lineOffset: js.UndefOr[Int] = js.undefined,
                     var columnOffset: js.UndefOr[Int] = js.undefined,
                     var displayErrors: js.UndefOr[Boolean] = js.undefined,
                     var timeout: js.UndefOr[Int] = js.undefined) extends js.Object