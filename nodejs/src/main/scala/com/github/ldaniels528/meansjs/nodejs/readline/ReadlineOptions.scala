package com.github.ldaniels528.meansjs.nodejs.readline

import com.github.ldaniels528.meansjs.nodejs.stream.{Readable, Writable}
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Readline Options
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ReadlineOptions extends js.Object {
  var input: js.UndefOr[Readable] = js.native
  var output: js.UndefOr[Writable] = js.native
  var completer: js.UndefOr[js.Function] = js.native
  var terminal: js.UndefOr[Boolean] = js.native
  var historySize: js.UndefOr[Int] = js.native
}

/**
  * Readline Options Companion
  * @author lawrence.daniels@gmail.com
  */
object ReadlineOptions {

  def apply(input: js.UndefOr[Readable] = js.undefined,
            output: js.UndefOr[Writable] = js.undefined,
            completer: js.UndefOr[js.Function] = js.undefined,
            terminal: js.UndefOr[Boolean] = js.undefined,
            historySize: js.UndefOr[Int] = js.undefined) = {
    val options = makeNew[ReadlineOptions]
    options.input = input
    options.output = output
    options.completer = completer
    options.terminal = terminal
    options.historySize = historySize
    options
  }

}