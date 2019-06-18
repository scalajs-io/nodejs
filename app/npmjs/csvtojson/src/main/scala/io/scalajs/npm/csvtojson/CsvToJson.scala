package io.scalajs.npm.csvtojson

import io.scalajs.RawOptions

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * csvtojson - A tool concentrating on converting csv data to JSON with customised parser supporting
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait CsvToJson extends js.Object {

  def apply(options: ParsingOptions | RawOptions = js.native): CsvToJsonImpl = js.native

}

/**
  * Csvtojson Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("csvtojson", JSImport.Namespace)
object CsvToJson extends CsvToJson

/**
  * CSV Parsing Options
  */

class ParsingOptions(val noheader: js.UndefOr[Boolean] = js.undefined) extends js.Object