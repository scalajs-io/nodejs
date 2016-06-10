package com.github.ldaniels528.meansjs.nodejs.xml2js

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * NodeJS/xml2js XML Declaration Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class XmlDeclarationOptions extends js.Object {
  var version: js.UndefOr[String] = _
  var encoding: js.UndefOr[String] = _
  var standalone: js.UndefOr[Boolean] = _
}

/**
  * XML Declaration Options
  * @author lawrence.daniels@gmail.com
  */
object XmlDeclarationOptions {

  def apply(encoding: js.UndefOr[String] = js.undefined,
            standalone: js.UndefOr[Boolean] = js.undefined,
            version: js.UndefOr[String] = js.undefined) = {
    val options = new XmlDeclarationOptions()
    options.encoding = encoding
    options.standalone = standalone
    options.version = version
    options
  }

}