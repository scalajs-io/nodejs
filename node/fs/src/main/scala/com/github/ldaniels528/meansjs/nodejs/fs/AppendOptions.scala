package com.github.ldaniels528.meansjs.nodejs.fs

import com.github.ldaniels528.meansjs.nodejs.fs.Fs.FileMode

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Append Options
  * @since 0.6.7
  */
@ScalaJSDefined
class AppendOptions(var encoding: String = null,
                    var mode: FileMode = 438 /* 0666 */ ,
                    var flag: String = "a") extends js.Object