package io.scalajs.nodejs

import scala.scalajs.js

/**
  * query string package object
  */
package object querystring {

  /**
    * Query String Enrichment
    * @param qs the given [[QueryString]]
    */
  implicit final class QueryStringEnrichment(private val qs: QueryString) extends AnyVal {
    @inline
    def parseAs[T <: js.Object](str: String,
                                sep: String = null,
                                eq: String = null,
                                options: QueryDecodeOptions = null): T = {
      qs.parse(str, sep, eq, options).asInstanceOf[T]
    }
  }
}
