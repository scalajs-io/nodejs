package com.github.ldaniels528.meansjs.nodejs.xml2js

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * NodeJS/xml2js Render Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class RenderOptions extends js.Object {
  var pretty: js.UndefOr[Boolean] = _
  var indent: js.UndefOr[String] = _
  var newline: js.UndefOr[String] = _
}

/**
  * Render Options
  * @author lawrence.daniels@gmail.com
  */
object RenderOptions {

  def apply(pretty: js.UndefOr[Boolean] = js.undefined,
            indent: js.UndefOr[String] = js.undefined,
            newline: js.UndefOr[String] = js.undefined) = {
    val options = new RenderOptions()
    options.pretty = pretty
    options.indent = indent
    options.newline = newline
    options
  }

}