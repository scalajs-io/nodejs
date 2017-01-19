package io.scalajs.nodejs

import io.scalajs.RawOptions

import scala.scalajs.js.|

/**
  * query string package object
  * @author lawrence.daniels@gmail.com
  */
package object querystring {

  /**
    * Query String Enrichment
    * @param qs the given [[QueryString]]
    */
  implicit class QueryStringEnrichment(val qs: QueryString) extends AnyVal {

    /**
      * The querystring.parse() method parses a URL query string (str) into a collection of key and value pairs.
      * @param str     The URL query string to parse
      * @param sep     The substring used to delimit key and value pairs in the query string. Defaults to '&'.
      * @param eq      The substring used to delimit keys and values in the query string. Defaults to '='.
      * @param options The given [[QueryDecodeOptions options]]
      * @return
      */
    @inline
    def parseAs[T](str: String, sep: String = null, eq: String = null, options: QueryDecodeOptions | RawOptions = null): T = {
      qs.parse(str, sep, eq, options).asInstanceOf[T]
    }

  }

}
