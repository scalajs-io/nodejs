package io.scalajs.npm.md5

import io.scalajs.nodejs.buffer.Buffer

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * MD5 - js function for hashing messages with MD5
  * @version 2.2.1
  * @see [[https://www.npmjs.com/package/md5]]
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("md5", JSImport.Namespace)
object MD5 extends js.Object {

  /**
    * Returns the MD5 encoded string generated from a given string or buffer
    * @param value the given [[String string]] or [[Buffer]]
    * @return the MD5 encoded string
    */
  def apply(value: String | Buffer): String = js.native

}
