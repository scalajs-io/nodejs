package com.github.ldaniels528.meansjs.repl

import com.github.ldaniels528.meansjs.nodejs.stream.{Readable, Writable}
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * REPL Options
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait REPLOptions extends js.Object {
  /** the prompt and stream for all I/O. Defaults to > . */
  var prompt: js.UndefOr[String] = js.native

  /** the readable stream to listen to. Defaults to process.stdin. */
  var input: js.UndefOr[Readable] = js.native

  /** the writable stream to write readline data to. Defaults to process.stdout. */
  var output: js.UndefOr[Writable] = js.native

  /** pass true if the stream should be treated like a TTY, and have ANSI/VT100 escape codes written to it.
    * Defaults to checking isTTY on the output stream upon instantiation.
    */
  var terminal: js.UndefOr[Boolean] = js.native

  /** function that will be used to eval each given line. Defaults to an async wrapper for eval().
    * See below for an example of a custom eval. */
  var eval: js.UndefOr[js.Function] = js.native

  /** a boolean which specifies whether or not the writer function should output colors.
    * If a different writer function is set then this does nothing. Defaults to the repl's terminal value. */
  var useColors: js.UndefOr[Boolean] = js.native

  /** if set to true, then the repl will use the global object, instead of running scripts in a separate context.
    * Defaults to false. */
  var useGlobal: js.UndefOr[Boolean] = js.native

  /** if set to true, then the repl will not output the return value of command if it's undefined. Defaults to false. */
  var ignoreUndefined: js.UndefOr[Boolean] = js.native

  /** the function to invoke for each command that gets evaluated which returns the formatting (including coloring) to display.
    * Defaults to util.inspect.
    */
  var writer: js.UndefOr[js.Function] = js.native

  /** controls whether the repl runs all commands in strict mode, default mode, or a hybrid mode ("magic" mode.)
    * Acceptable values are:
    * <ul>
    * <li>repl.REPL_MODE_SLOPPY - run commands in sloppy mode.</li>
    * <li>repl.REPL_MODE_STRICT - run commands in strict mode. This is equivalent to prefacing every repl statement with 'use strict'.</li>
    * <li>repl.REPL_MODE_MAGIC - attempt to run commands in default mode. If they fail to parse, re-try in strict mode.</li>
    * </ul>
    */
  var replMode: js.UndefOr[String] = js.native

}

/**
  * REPL Options
  * @author lawrence.daniels@gmail.com
  */
object REPLOptions {

  def apply(prompt: js.UndefOr[String] = js.undefined,
            input: js.UndefOr[Readable] = js.undefined,
            output: js.UndefOr[Writable] = js.undefined,
            terminal: js.UndefOr[Boolean] = js.undefined,
            eval: js.UndefOr[js.Function] = js.undefined,
            useColors: js.UndefOr[Boolean] = js.undefined,
            useGlobal: js.UndefOr[Boolean] = js.undefined,
            ignoreUndefined: js.UndefOr[Boolean] = js.undefined,
            writer: js.UndefOr[js.Function] = js.undefined,
            replMode: js.UndefOr[String] = js.undefined) = {
    val options = makeNew[REPLOptions]
    options.prompt = prompt
    options.input = input
    options.output = output
    options.terminal = terminal
    options.eval = eval
    options.useColors = useColors
    options.useGlobal = useGlobal
    options.ignoreUndefined = ignoreUndefined
    options.writer = writer
    options.replMode = replMode
    options
  }

}