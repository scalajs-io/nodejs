package io.scalajs.npm.cheerio

import io.scalajs.jquery.JQueryElement

import scala.scalajs.js

/**
  * Cheerio JQuery Element
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait CheerioJQueryElement extends JQueryElement {

  def serializeArray(): js.Array[_ <: js.Any] = js.native

}
