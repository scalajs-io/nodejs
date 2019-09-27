package io.scalajs.nodejs.readline

import io.scalajs.nodejs.stream.{Readable, Writable}

import scala.scalajs.js

/**
  * Readline Options
  */
class ReadlineOptions(
    var input: js.UndefOr[Readable] = js.undefined,
    var output: js.UndefOr[Writable] = js.undefined,
    var completer: js.UndefOr[js.Function] = js.undefined,
    var terminal: js.UndefOr[Boolean] = js.undefined,
    var historySize: js.UndefOr[Int] = js.undefined,
    var prompt: js.UndefOr[String] = js.undefined,
    var crlfDelay: js.UndefOr[Double] = js.undefined,
    var removeHistoryDuplicates: js.UndefOr[Boolean] = js.undefined,
    var escapeCodeTimeout: js.UndefOr[Double] = js.undefined
) extends js.Object
