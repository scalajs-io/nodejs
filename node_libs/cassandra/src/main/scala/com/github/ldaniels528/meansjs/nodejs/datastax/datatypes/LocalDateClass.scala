package com.github.ldaniels528.meansjs.nodejs.datastax.datatypes

import com.github.ldaniels528.meansjs.nodejs.buffer.Buffer
import com.github.ldaniels528.meansjs.nodejs.datastax.datatypes.LocalDateClass.LocalDate
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Cassandra Local Date class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait LocalDateClass extends js.Object {

  def fromBuffer(buffer: Buffer): LocalDate = js.native

  def fromDate(date: js.Date): LocalDate = js.native

  def fromString(string: String): LocalDate = js.native

  def now(): LocalDate = js.native

  def utcNow(): LocalDate = js.native

}

/**
  * Cassandra Local Date Class Companion
  * @author lawrence.daniels@gmail.com
  */
object LocalDateClass {

  /**
    * Cassandra Local Date instance
    */
  @js.native
  trait LocalDate extends js.Any

  /**
    * Cassandra Local Date Class Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class CassandraLocalDateClassExtensions(val `class`: LocalDateClass) extends AnyVal {

    @inline
    def apply(year: Int, month: Int, day: Int) = `class`.New[LocalDate](year, month, day)

  }

}