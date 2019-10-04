package io.scalajs.nodejs.crypto

import com.thoughtworks.enableIf
import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.stream.Writable

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * The Sign Class is a utility for generating signatures. It can be used in one of two ways:
  *
  * <li>As a writable stream, where data to be signed is written and the sign.sign() method is used to generate and return
  * the signature, or</li>
  * <li>Using the sign.update() and sign.sign() methods to produce the signature.</li>
  *
  * The crypto.createSign() method is used to create Sign instances. Sign objects are not to be created directly using
  * the new keyword.
  */
@js.native
sealed trait Sign extends Writable {
  def sign(privateKey: String | Buffer): Buffer                         = js.native
  def sign(privateKey: String | Buffer, outputEncoding: String): String = js.native
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def sign(privateKey: KeyObject): Buffer = js.native
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def sign(privateKey: KeyObject, outputEncoding: String): String = js.native

  def update(data: String, inputEncoding: String = js.native): Unit = js.native
  def update(data: BufferLike): Unit                                = js.native
}
