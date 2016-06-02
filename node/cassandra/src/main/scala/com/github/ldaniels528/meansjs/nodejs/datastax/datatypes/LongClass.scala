package com.github.ldaniels528.meansjs.nodejs.datastax.datatypes

import com.github.ldaniels528.meansjs.nodejs.buffer.Buffer
import com.github.ldaniels528.meansjs.nodejs.datastax.datatypes.IntegerClass.CxInteger
import com.github.ldaniels528.meansjs.nodejs.datastax.datatypes.LongClass.CxLong
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Cassandra Long class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait LongClass extends js.Object {
  val ZERO: Long = js.native
  val UZERO: Long = js.native
  val ONE: Long = js.native
  val UONE: Long = js.native
  val NEG_ONE: Long = js.native
  val MAX_VALUE: Long = js.native
  val MAX_UNSIGNED_VALUE: Long = js.native
  val MIN_VALUE: Long = js.native

  def fromBuffer(buffer: Buffer): CxLong = js.native

  def fromInt(value: CxInteger): CxLong = js.native

  def fromNumber(number: Number): CxLong = js.native

  def fromString(value: String): CxLong = js.native

  def isLong(value: CxLong): Boolean = js.native

  def toBuffer(value: CxLong): Buffer = js.native

}

/**
  * Cassandra Long Class Companion
  * @author lawrence.daniels@gmail.com
  */
object LongClass {

  /**
    * Cassandra Long instance
    */
  @js.native
  trait CxLong extends js.Any

  /**
    * Cassandra Long Class Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class CassandraLongClassExtensions(val `class`: LongClass) extends AnyVal {

    @inline
    def apply(low: Int, high: Int, unsigned: Boolean) = `class`.New[CxLong](low, high, unsigned)

  }

}