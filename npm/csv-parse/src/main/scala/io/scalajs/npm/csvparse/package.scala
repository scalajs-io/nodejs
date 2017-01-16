package io.scalajs.npm

import io.scalajs.nodejs.{Error, NodeOptions}
import io.scalajs.util.ScalaJsHelper.futureCallbackX1

import scala.concurrent.Promise
import scala.scalajs.js
import scala.scalajs.js.|

/**
  * csv-parse package object
  * @author lawrence.daniels@gmail.com
  */
package object csvparse {

  type CsvResults = js.Array[js.Array[String]]

  /**
    * Csv-Parse Events
    * @param parser the given [[CsvParse parser]] instance
    */
  implicit class CsvParseEvents(val parser: CsvParse) extends AnyVal {

    @inline
    def parseFuture(text: String, options: ParserOptions | NodeOptions = null): Promise[js.Array[js.Array[String]]] = {
      futureCallbackX1[String, js.Array[js.Array[String]]](parser.apply(text, options, _))
    }

    @inline
    def onError(listener: Error => Any): parser.type = parser.on("error", listener)

    @inline
    def onFinish(listener: () => Any): parser.type = parser.on("finish", listener)

    @inline
    def onReadable(listener: () => Any): parser.type = parser.on("readable", listener)

  }

}
