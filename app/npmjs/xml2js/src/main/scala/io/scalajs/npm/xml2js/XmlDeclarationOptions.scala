package io.scalajs.npm.xml2js

import io.scalajs.FlexibleOptions

import scala.scalajs.js

/**
  * NodeJS/xml2js XML Declaration Options
  * @author lawrence.daniels@gmail.com
  */

class XmlDeclarationOptions(var encoding: js.UndefOr[String] = js.undefined,
                            var standalone: js.UndefOr[Boolean] = js.undefined,
                            var version: js.UndefOr[String] = js.undefined)
  extends js.Object

/**
  * XML Declaration Options Companion
  * @author lawrence.daniels@gmail.com
  */
object XmlDeclarationOptions extends FlexibleOptions[XmlDeclarationOptions]