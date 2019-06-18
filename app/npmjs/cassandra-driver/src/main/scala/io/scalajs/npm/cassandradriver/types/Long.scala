package io.scalajs.npm.cassandradriver.types

import io.scalajs.JsNumber
import io.scalajs.nodejs.buffer.Buffer

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Cassandra Long
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("cassandra-driver", "types.Long")
class Long(low: Int, high: Int, unsigned: Boolean) extends js.Object

/**
  * Cassandra Long Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("cassandra-driver", "types.Long")
object Long extends js.Object {
  val ZERO: Long               = js.native
  val UZERO: Long              = js.native
  val ONE: Long                = js.native
  val UONE: Long               = js.native
  val NEG_ONE: Long            = js.native
  val MAX_VALUE: Long          = js.native
  val MAX_UNSIGNED_VALUE: Long = js.native
  val MIN_VALUE: Long          = js.native

  def fromBuffer(buffer: Buffer): Long = js.native

  def fromInt(value: Integer): Long = js.native

  def fromNumber(number: JsNumber): Long = js.native

  def fromString(value: String): Long = js.native

  def isLong(value: Long): Boolean = js.native

  def toBuffer(value: Long): Buffer = js.native

}
