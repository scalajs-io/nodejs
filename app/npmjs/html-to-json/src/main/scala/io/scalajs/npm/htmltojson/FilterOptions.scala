package io.scalajs.npm.htmltojson

import io.scalajs.FlexibleOptions
import io.scalajs.dom.Attr
import io.scalajs.dom.html.Image
import io.scalajs.jquery.JQueryElement

import scala.scalajs.js

/**
  * Html-to-Json Filter Options
  * @author lawrence.daniels@gmail.com
  */
class FilterOptions(var text: js.Function1[JQueryElement, String] = null,
                    var images: js.UndefOr[js.Array[_]] = js.undefined) extends js.Object

/**
  * Html-to-Json Filter Options Companion
  * @author lawrence.daniels@gmail.com
  */
object FilterOptions extends FlexibleOptions[FilterOptions] {

  /**
    * Filter Options Enrichment
    * @param options the given [[FilterOptions filter options]]
    */
  final implicit class FilterOptionsEnrichment[T <: FilterOptions](val options: T) extends AnyVal {

    @inline
    def withImages(f: Image => Attr): T = {
      options.images = js.Array("img", f)
      options
    }

    @inline
    def withText(f: JQueryElement => String): T = {
      options.text = f
      options
    }

  }

}
