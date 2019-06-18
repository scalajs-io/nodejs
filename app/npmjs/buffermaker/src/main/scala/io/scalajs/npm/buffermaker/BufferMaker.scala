package io.scalajs.npm.buffermaker

import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.npm.bignum.BigNum

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * buffermaker is a convenient way of creating binary strings
  * @version 1.2.0
  * @see https://www.npmjs.com/package/buffermaker
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("buffermaker", JSImport.Namespace)
class BufferMaker extends js.Object {

  def DoubleBE(n: Double): this.type = js.native

  def DoubleLE(n: Double): this.type = js.native

  def FloatBE(n: Float): this.type = js.native

  def FloatLE(n: Float): this.type = js.native

  def Int8(n: Int): this.type = js.native

  def Int16BE(n: Int): this.type = js.native

  def Int16LE(n: Int): this.type = js.native

  def Int32BE(n: Int): this.type = js.native

  def Int32LE(n: Int | Long): this.type = js.native

  // uses the BigNum library
  def Int64BE(n: Int | Long | BigNum): this.type = js.native

  def Int64LE(n: Int | Long | BigNum): this.type = js.native

  def UInt8(n: Int): this.type = js.native

  def UInt16BE(n: Int): this.type = js.native

  def UInt16LE(n: Int): this.type = js.native

  def UInt32BE(n: Int | Long): this.type = js.native

  def UInt32LE(n: Int | Long): this.type = js.native

  def string(s: String): this.type = js.native

  def make(): Buffer = js.native

}