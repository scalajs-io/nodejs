package org.scalajs.nodejs.readline

import org.scalajs.nodejs.stream.{Readable, Writable}

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Readline Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class ReadlineOptions(var input: js.UndefOr[Readable] = js.undefined,
                      var output: js.UndefOr[Writable] = js.undefined,
                      var completer: js.UndefOr[js.Function] = js.undefined,
                      var terminal: js.UndefOr[Boolean] = js.undefined,
                      var historySize: js.UndefOr[Int] = js.undefined) extends js.Object
