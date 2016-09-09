package org.scalajs.nodejs
package csvparse

import org.scalajs.nodejs.csvparse.CsvParse.CsvParser

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * csv-parse - CSV parsing implementing the Node.js 'stream.Transform' API
  * @see [[https://github.com/wdavidw/node-csv-parse]]
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait CsvParse extends NodeModule with stream.Readable {

  def apply(options: CsvParseOptions | js.Any): CsvParser = js.native

  def apply(input: String, options: CsvParseOptions | js.Any, callback: js.Function): Unit = js.native

  def apply(input: String, callback: js.Function2[errors.Error, js.Any, Any]): Unit = js.native

  def write(data: String): Unit = js.native

}

/**
  * Csv-Parse Companion
  * @author lawrence.daniels@gmail.com
  */
object CsvParse {

  /**
    * Csv Parser
    * @author lawrence.daniels@gmail.com
    */
  @js.native
  trait CsvParser extends stream.Readable with stream.Writable

  /**
    * Convenience method for retrieving the csv-parse module
    * @param require the implicit [[NodeRequire require function]]
    * @return the CsvParse instance
    */
  def apply()(implicit require: NodeRequire) = require[CsvParse]("csv-parse")

  /**
    * Csv-Parse Events
    * @param parser the given [[CsvParse parser]] instance
    */
  implicit class CsvParseEvents(val parser: CsvParse) extends AnyVal {

    def onError(listener: errors.Error => Any) = parser.on("error", listener)

    def onFinish(listener: () => Any) = parser.on("finish", listener)

    def onReadable(listener: () => Any) = parser.on("readable", listener)

  }

}