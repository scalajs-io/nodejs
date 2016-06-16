package org.scalajs.nodejs.crypto

import org.scalajs.nodejs.stream
import org.scalajs.nodejs.buffer.Buffer
import org.scalajs.nodejs.stream.Duplex

import scala.scalajs.js

/**
  * The Sign Class is a utility for generating signatures. It can be used in one of two ways:
  *
  * <li>As a writable stream, where data to be signed is written and the sign.sign() method is used to generate and return
  * the signature, or</li>
  * <li>Using the sign.update() and sign.sign() methods to produce the signature.</li>
  *
  * The crypto.createSign() method is used to create Sign instances. Sign objects are not to be created directly using
  * the new keyword.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Sign extends Duplex {

  def sign(private_key: String): String = js.native

  def sign(private_key: String, output_format: String): String = js.native

  def update(data: String, input_encoding: String): Unit = js.native

  def update(data: String): Unit = js.native

  def update(data: Buffer): Unit = js.native

}
