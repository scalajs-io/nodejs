package io.scalajs.npm.bignum

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined
import scala.scalajs.js.|

/**
  * BigNum Options
  * Note that endian doesn't matter when size = 1. If you wish to reverse the entire buffer byte by byte, pass size: 'auto'.
  * @param endian the endianness of the underlying buffer
  * @param size   the size of the buffer or 'auto'
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class BigNumOptions(var endian: js.UndefOr[String] = js.undefined,
                    var size: js.UndefOr[String | Int] = js.undefined) extends js.Object