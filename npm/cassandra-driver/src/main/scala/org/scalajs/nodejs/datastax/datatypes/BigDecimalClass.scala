package org.scalajs.nodejs.datastax.datatypes

import org.scalajs.nodejs.buffer.Buffer
import org.scalajs.nodejs.datastax.datatypes.BigDecimalClass.CxBigDecimal
import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.nodejs.util.ScalaJsHelper

import scala.scalajs.js

/**
  * Cassandra BigDecimal class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait BigDecimalClass extends js.Object {

  def fromBuffer(buffer: Buffer): CxBigDecimal = js.native

  def toBuffer(value: CxBigDecimal): Buffer = js.native

  def fromString(value: String): CxBigDecimal = js.native

  def fromNumber(number: Number): CxBigDecimal = js.native

}

/**
  * Cassandra BigDecimal Class Companion
  * @author lawrence.daniels@gmail.com
  */
object BigDecimalClass {

  /**
    * Cassandra BigDecimal instance
    */
  @js.native
  trait CxBigDecimal extends js.Any

  /**
    * Cassandra BigDecimal Class Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class CassandraBigDecimalClassExtensions(val `class`: BigDecimalClass) extends AnyVal {

    @inline
    def apply(value: Double, scale: Int) = `class`.New[CxBigDecimal](value, scale)

    @inline
    def apply(value: Double) = `class`.New[CxBigDecimal](value)

  }

}