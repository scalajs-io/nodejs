package io.scalajs.npm.htmltojson

import io.scalajs.dom.Attr
import io.scalajs.dom.html.Image
import io.scalajs.jquery.JQueryElement

import scala.language.existentials
import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Html-to-Json Filter Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class FilterOptions(var text: js.Function1[JQueryElement, String] = null,
                    var images: js.UndefOr[js.Array[_]] = js.undefined) extends js.Object

/**
  * Html-to-Json Filter Options Companion
  * @author lawrence.daniels@gmail.com
  */
object FilterOptions {

  /**
    * Filter Options Enrichment
    * @param options the given [[FilterOptions filter options]]
    */
  implicit class FilterOptionsEnrichment(val options: FilterOptions) extends AnyVal {

    @inline
    def withImages(f: Image => Attr): options.type = {
      options.images = js.Array("img", f)
      options
    }

    @inline
    def withText(f: JQueryElement => String): options.type = {
      options.text = f
      options
    }

  }

}