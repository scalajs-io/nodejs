package com.github.ldaniels528.meansjs.nodejs.readline

import com.github.ldaniels528.meansjs.nodejs.stream.{Readable, Writable}

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Readline Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class ReadlineOptions extends js.Object {
  var input: js.UndefOr[Readable] = _
  var output: js.UndefOr[Writable] = _
  var completer: js.UndefOr[js.Function] = _
  var terminal: js.UndefOr[Boolean] = _
  var historySize: js.UndefOr[Int] = _
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
    val options = new ReadlineOptions()
    options.input = input
    options.output = output
    options.completer = completer
    options.terminal = terminal
    options.historySize = historySize
    options
  }

}