package io.scalajs.npm.csvparse

import io.scalajs.nodejs.stream.{Readable, Writable}

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * CSV Parser
  * @author lawrence.daniels@gmail.com
  */
@js.native
class Parser(val options: ParserOptions) extends Readable with Writable {

  /**
    * Internal counter of records being processed.
    */
  def count: Int = js.native

  /**
    * The number of lines encountered in the source dataset.
    */
  def lines: Int = js.native

  /**
    * The regular expression or function used to determine if a value should be cast to an integer.
    * @param expr the given regular expression or function
    * @return true, if a value should be cast to an integer.
    */
  def is_int(expr: js.RegExp | js.Function): Boolean = js.native

  /**
    * The regular expression or function used to determine if a value should be cast to a float.
    * @param expr the given regular expression or function
    * @return true, if a value should be cast to a float
    */
  def is_float(expr: js.RegExp | js.Function): Boolean = js.native

}
