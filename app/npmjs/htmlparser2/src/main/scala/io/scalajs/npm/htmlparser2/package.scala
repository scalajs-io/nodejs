package io.scalajs.npm

import scala.scalajs.js

/**
  * htmlparser2 package object
  * @author lawrence.daniels@gmail.com
  */
package object htmlparser2 {

  /**
    * Parser Enrichment
    * @param parser the given [[Parser]]
    */
  implicit class ParserEnrichment(val parser: Parser) extends AnyVal {

    @inline
    def onEnd(listener: js.Function): parser.type = parser.on("end", listener)

  }

}
