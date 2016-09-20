package org.scalajs.nodejs.request

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Client Request Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class RequestOptions(var url: js.UndefOr[String] = js.undefined,
                     var form: js.Any = js.undefined,
                     var formData: js.Any = js.undefined) extends js.Object

