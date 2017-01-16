package io.scalajs.npm.csvparse

import io.scalajs.nodejs.NodeOptions
import io.scalajs.nodejs.events.IEventEmitter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * CSV parsing implementing the Node.js 'stream.Transform' API
  * @version 1.1.2
  * @see https://github.com/wdavidw/node-csv-parse
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait CsvParse extends IEventEmitter {

  /////////////////////////////////////////////////////////////////////////////////
  //      Streaming
  /////////////////////////////////////////////////////////////////////////////////

  def apply(text: String, options: ParserOptions | NodeOptions): Parser = js.native

  def apply(options: ParserOptions | NodeOptions): Parser = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Asynchronous
  /////////////////////////////////////////////////////////////////////////////////

  def apply(text: String, options: ParserOptions | NodeOptions, callback: js.Function2[String, CsvResults, Any]): Unit = js.native

  def apply(text: String, callback: js.Function2[String, CsvResults, Any]): Unit = js.native

}

/**
  * Csv-Parse Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("csv-parse", JSImport.Namespace)
object CsvParse extends CsvParse
