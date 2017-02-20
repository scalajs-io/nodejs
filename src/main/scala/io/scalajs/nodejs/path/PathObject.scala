package io.scalajs.nodejs.path

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Path Object
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class PathObject(val root: js.UndefOr[String] = js.undefined,
                 val dir: js.UndefOr[String] = js.undefined,
                 val base: js.UndefOr[String] = js.undefined,
                 val ext: js.UndefOr[String] = js.undefined,
                 val name: js.UndefOr[String] = js.undefined)
    extends js.Object
