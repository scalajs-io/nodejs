package io.scalajs.npm.xml2js

import scala.scalajs.js

/**
  * NodeJS/xml2js XML Declaration Options
  * @author lawrence.daniels@gmail.com
  */

class XmlDeclarationOptions(var encoding: js.UndefOr[String] = js.undefined,
                            var standalone: js.UndefOr[Boolean] = js.undefined,
                            var version: js.UndefOr[String] = js.undefined)
    extends js.Object
