package io.scalajs.npm.xml2js

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * NodeJS/xml2js XML Declaration Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class XmlDeclarationOptions(var encoding: js.UndefOr[String] = js.undefined,
                            var standalone: js.UndefOr[Boolean] = js.undefined,
                            var version: js.UndefOr[String] = js.undefined)
    extends js.Object
