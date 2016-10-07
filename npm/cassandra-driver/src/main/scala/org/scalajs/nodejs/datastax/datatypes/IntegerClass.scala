package org.scalajs.nodejs.datastax.datatypes

import org.scalajs.nodejs.buffer.Buffer
import org.scalajs.nodejs.datastax.datatypes.IntegerClass.CxInteger
import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.nodejs.util.ScalaJsHelper

import scala.scalajs.js

/**
  * Cassandra Integer class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait IntegerClass extends js.Object {
  val TWO_PWR_32_DBL_ : Int = js.native
  val ZERO: Int = js.native
  val ONE: Int = js.native
  val TWO_PWR_24_ : Int = js.native

  def fromBuffer(buffer: Buffer): CxInteger = js.native

  def fromBits(bits: js.Array[Int]): CxInteger = js.native

  def fromNumber(value: Number): CxInteger = js.native

  def fromString(value: String): CxInteger = js.native

  def toBuffer(value: CxInteger): Buffer = js.native

}

/**
  * Cassandra Integer Class Companion
  * @author lawrence.daniels@gmail.com
  */
object IntegerClass {

  /**
    * Cassandra Integer instance
    */
  @js.native
  trait CxInteger extends js.Any

  /**
    * Cassandra Integer Class Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class CassandraIntegerClassExtensions(val `class`: IntegerClass) extends AnyVal {

    @inline
    def apply(bits: js.Array[Int], sign: Int) = `class`.New[CxInteger](bits, sign)

  }

}