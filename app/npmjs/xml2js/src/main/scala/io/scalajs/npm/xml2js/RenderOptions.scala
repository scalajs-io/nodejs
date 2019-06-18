package io.scalajs.npm.xml2js

import scala.scalajs.js

/**
  * NodeJS/xml2js Render Options
  * @author lawrence.daniels@gmail.com
  */
class RenderOptions(var pretty: js.UndefOr[Boolean] = js.undefined,
                    var indent: js.UndefOr[String] = js.undefined,
                    var newline: js.UndefOr[String] = js.undefined)
    extends js.Object
