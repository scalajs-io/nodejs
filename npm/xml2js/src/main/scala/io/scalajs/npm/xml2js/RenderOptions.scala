package io.scalajs.npm.xml2js

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * NodeJS/xml2js Render Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class RenderOptions(var pretty: js.UndefOr[Boolean] = js.undefined,
                    var indent: js.UndefOr[String] = js.undefined,
                    var newline: js.UndefOr[String] = js.undefined)
    extends js.Object
