package org.scalajs.nodejs

import org.scalajs.nodejs.util.ScalaJsHelper._

/**
  * xml2js package object
  * @author lawrence.daniels@gmail.com
  */
package object xml2js {

  /**
    * XML2JS Enrichment
    * @param xml2js the given [[XML2JS]] instance
    */
  implicit class XML2JSEnrichment(val xml2js: XML2JS) extends AnyVal {

    @inline
    def parseStringFuture[T](xml: String) = futureCallbackE1[errors.Error, T](xml2js.parseString(xml, _))

  }

}
