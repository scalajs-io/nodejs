package org.scalajs.nodejs.pvorb.md5

import org.scalajs.nodejs.NodeRequire
import org.scalajs.nodejs.buffer.Buffer

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * pvorb/MD5 - a JavaScript function for hashing messages with MD5
  * @version 2.1.0
  * @see [[https://www.npmjs.com/package/MD5]]
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait MD5 extends js.Object {

  /**
    * Returns the MD5 encoded string generated from a given string or buffer
    * @param value the given [[String string]] or [[Buffer buffer]]
    * @return the MD5 encoded string
    */
  def apply(value: String | Buffer): String = js.native

}

/**
  * MD5 Companion
  * @author lawrence.daniels@gmail.com
  */
object MD5 {

  /**
    * Convenience method for retrieving the MD5 module
    * @param require the implicit [[NodeRequire require function]]
    * @return the MD5 instance
    */
  def apply()(implicit require: NodeRequire) = require[MD5]("md5")

}
