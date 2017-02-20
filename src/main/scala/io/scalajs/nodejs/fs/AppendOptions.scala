package io.scalajs.nodejs.fs

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Append Options
  * @since 0.6.7
  */
@ScalaJSDefined
class AppendOptions(var encoding: String = null, var mode: FileMode = 438 /* 0666 */, var flag: String = "a")
    extends js.Object
