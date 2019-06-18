package io.scalajs.npm.cassandradriver.types

import io.scalajs.nodejs.buffer.Buffer

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Cassandra Integer
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("cassandra-driver", "types.Integer")
class Integer(bits: js.Array[Int], sign: Int) extends js.Object

/**
  * Cassandra Integer Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("cassandra-driver", "types.Integer")
object Integer extends js.Object {
  val TWO_PWR_32_DBL_ : Int = js.native
  val ZERO: Int             = js.native
  val ONE: Int              = js.native
  val TWO_PWR_24_ : Int     = js.native

  def fromBits(bits: js.Array[Int]): Integer = js.native

  def fromBuffer(buffer: Buffer): Integer = js.native

  def fromNumber(value: Number): Integer = js.native

  def fromString(value: String): Integer = js.native

  def toBuffer(value: Integer): Buffer = js.native

}
