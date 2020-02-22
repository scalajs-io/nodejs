package io.scalajs.nodejs

import scala.scalajs.js

object TestHelper {
  def isDefined(obj: js.Any): Boolean = obj != null && !js.isUndefined(obj)
}
