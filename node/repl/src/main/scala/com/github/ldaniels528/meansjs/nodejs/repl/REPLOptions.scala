package com.github.ldaniels528.meansjs.nodejs.repl

import com.github.ldaniels528.meansjs.nodejs.stream.{Readable, Writable}

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * REPL Options
  * @param prompt          the prompt and stream for all I/O. Defaults to > .
  * @param input           the readable stream to listen to. Defaults to process.stdin.
  * @param output          the writable stream to write readline data to. Defaults to process.stdout.
  * @param terminal        pass true if the stream should be treated like a TTY, and have ANSI/VT100 escape codes written to it.
  *                        Defaults to checking isTTY on the output stream upon instantiation.
  * @param eval            function that will be used to eval each given line. Defaults to an async wrapper for eval().
  *                        See below for an example of a custom eval.
  * @param useColors       a boolean which specifies whether or not the writer function should output colors.
  *                        If a different writer function is set then this does nothing. Defaults to the repl's terminal value.
  * @param useGlobal       if set to true, then the repl will use the global object, instead of running scripts in a separate context.
  *                        Defaults to false.
  * @param ignoreUndefined if set to true, then the repl will not output the return value of command if it's undefined.
  *                        Defaults to false.
  * @param writer          the function to invoke for each command that gets evaluated which returns the formatting
  *                        (including coloring) to display. Defaults to util.inspect.
  * @param replMode        controls whether the repl runs all commands in strict mode, default mode, or a hybrid mode ("magic" mode.)
  *                        Acceptable values are:
  *                        <ul>
  *                        <li>repl.REPL_MODE_SLOPPY - run commands in sloppy mode.</li>
  *                        <li>repl.REPL_MODE_STRICT - run commands in strict mode. This is equivalent to prefacing every
  *                        repl statement with 'use strict'.</li>
  *                        <li>repl.REPL_MODE_MAGIC - attempt to run commands in default mode. If they fail to parse,
  *                        re-try in strict mode.</li>
  *                        </ul>
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class REPLOptions(var prompt: js.UndefOr[String] = js.undefined,
                  var input: js.UndefOr[Readable] = js.undefined,
                  var output: js.UndefOr[Writable] = js.undefined,
                  var terminal: js.UndefOr[Boolean] = js.undefined,
                  var eval: js.UndefOr[js.Function] = js.undefined,
                  var useColors: js.UndefOr[Boolean] = js.undefined,
                  var useGlobal: js.UndefOr[Boolean] = js.undefined,
                  var ignoreUndefined: js.UndefOr[Boolean] = js.undefined,
                  var writer: js.UndefOr[js.Function] = js.undefined,
                  var replMode: js.UndefOr[String] = js.undefined) extends js.Object
