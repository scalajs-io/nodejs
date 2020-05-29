package io.scalajs.nodejs.repl

import io.scalajs.nodejs.stream
import net.exoego.scalajs.types.util.Factory

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * The repl module provides a Read-Eval-Print-Loop (REPL) implementation that is available
  * both as a standalone program or includable in other applications.
  * @see https://nodejs.org/api/repl.html#repl_repl
  */
@js.native
trait REPL extends js.Object {
  var REPL_MODE_SLOPPY: js.Symbol = js.native
  var REPL_MODE_STRICT: js.Symbol = js.native

  def start(options: StartOptions = js.native): REPLServer = js.native
  def start(prompt: String): REPLServer                    = js.native
}

@Factory
trait StartOptions extends js.Object {
  var prompt: js.UndefOr[String]                                                  = js.undefined
  var input: js.UndefOr[stream.IReadable]                                         = js.undefined
  var output: js.UndefOr[stream.IWritable]                                        = js.undefined
  var terminal: js.UndefOr[Boolean]                                               = js.undefined
  var eval: js.UndefOr[js.Function4[String, js.Object, String, js.Function, Any]] = js.undefined
  var useColors: js.UndefOr[Boolean]                                              = js.undefined
  var useGlobal: js.UndefOr[Boolean]                                              = js.undefined
  var ignoreUndefined: js.UndefOr[Boolean]                                        = js.undefined
  var writer: js.UndefOr[js.Function1[js.Any, Any]]                               = js.undefined
  var completer: js.UndefOr[js.Function]                                          = js.undefined
  var replMode: js.UndefOr[js.Symbol]                                             = js.undefined
  var breakEvalOnSigint: js.UndefOr[Boolean]                                      = js.undefined
}

/**
  * REPL Singleton
  */
@js.native
@JSImport("repl", JSImport.Namespace)
object REPL extends REPL
