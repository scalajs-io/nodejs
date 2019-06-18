package io.scalajs.npm

import io.scalajs.RawOptions
import io.scalajs.nodejs.Error
import io.scalajs.util.PromiseHelper._

import scala.concurrent.Future
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
    def parseFuture(text: String, options: ParserOptions | RawOptions = null): Future[CsvResults] = {
      promiseWithError1[Error, CsvResults](parser.apply(text, options, _))
    }

    @inline
    def onError(listener: Error => Any): parser.type = parser.on("error", listener)

    @inline
    def onFinish(listener: () => Any): parser.type = parser.on("finish", listener)

    @inline
    def onReadable(listener: () => Any): parser.type = parser.on("readable", listener)

  }

}
