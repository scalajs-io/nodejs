package io.scalajs

import scala.scalajs.js

/**
  * jquery package object
  * @author lawrence.daniels@gmail.com
  */
package object jquery {

  /**
    * A string containing a selector expression
    */
  type Selector = String


  /**
    * JQuery Enrichment
    * @param element the given [[JQueryElement]]
    */
  implicit class JQueryEnrichment(val element: JQueryElement) extends AnyVal {

    @inline
    def attr(name: String, function: (Int, String) => String): element.type = {
      element.attr(name, function: js.Function2[Int, String, String])
    }

  }

}
