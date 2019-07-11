package io.scalajs.npm.minimist

import io.scalajs.FlexibleOptions

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * Minimist optional settings
  * @param string    a string or array of strings argument names to always treat as strings
  * @param boolean   a boolean, string or array of strings to always treat as booleans.
  *                  if true will treat all double hyphenated arguments without equal signs as
  *                  boolean (e.g. affects --foo, not -f or --foo=bar)
  * @param alias     an object mapping string names to strings or arrays of string argument names to use as aliases
  * @param default   an object mapping string argument names to default values
  * @param stopEarly when true, populate argv._ with everything after the first non-option
  * @param unknown   - a function which is invoked with a command line parameter not defined in the opts configuration object.
  *                  If the function returns false, the unknown option is not added to argv.
  */

class MinimistOptions(var string: js.UndefOr[String | js.Array[String]] = js.undefined,
                      var boolean: js.UndefOr[Boolean | String | js.Array[String]] = js.undefined,
                      var alias: js.UndefOr[js.Object | js.Dictionary[String | js.Array[String]]] = js.undefined,
                      var default: js.UndefOr[js.Object | js.Dictionary[String | js.Array[String]]] = js.undefined,
                      var stopEarly: js.UndefOr[Boolean] = js.undefined,
                      var unknown: js.UndefOr[js.Function] = js.undefined) extends js.Object

/**
  * Minimist Options Companion
  * @author lawrence.danils@gmail.com
  */
object MinimistOptions extends FlexibleOptions[MinimistOptions] {

  /**
    * Minimist Options Enrichment
    * @param options the given [[MinimistOptions options]]
    */
  final implicit class MinimistOptionsEnrichment(val options: MinimistOptions) extends AnyVal {

    /**
      * when true, populate argv._ with everything before the -- and argv["--"]
      * with everything after the --. Here's an example:
      * {{{
      *   Minimist("one two three -- four five --six".split(" "), new MinimistOptions().withDelimiter())
      *   //=> { _: [ "one", "two", "three" ], "--": [ "four", "five", "--six" ] }
      * }}}
      * @param enabled indicates whether the delimiter is enabled (default: true)
      * @return the [[MinimistOptions]] with the delimiter added if enabled == true
      */
    @inline
    def withDelimiter(enabled: Boolean = true): MinimistOptions = {
      val dict = MinimistOptions.asInstanceOf[js.Dictionary[js.Any]]
      dict.put("--", enabled)
      dict.asInstanceOf[MinimistOptions]
    }

  }

}