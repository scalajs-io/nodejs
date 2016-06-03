package com.github.ldaniels528.meansjs.nodejs.datastax.datatypes

import com.github.ldaniels528.meansjs.nodejs.buffer.Buffer
import com.github.ldaniels528.meansjs.nodejs.datastax.datatypes.TimeUuidClass.CxTimeUuid
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Cassandra Time UUID class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait TimeUuidClass extends js.Object {

  def fromDate(date: js.Date): CxTimeUuid = js.native

  def fromString(string: String): CxTimeUuid = js.native

  def min(): CxTimeUuid = js.native

  def max(): CxTimeUuid = js.native

  def now(): CxTimeUuid = js.native

}

/**
  * Cassandra Time UUID Class Companion
  * @author lawrence.daniels@gmail.com
  */
object TimeUuidClass {

  /**
    * Cassandra Time UUID instance
    */
  @js.native
  trait CxTimeUuid extends js.Any

  /**
    * Cassandra Time UUID Class Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class CassandraTimeUuidClassExtensions(val `class`: TimeUuidClass) extends AnyVal {

    @inline
    def apply(value: Int, ticks: Int, nodeId: Int, clockId: Int) = `class`.New[CxTimeUuid](value, ticks, nodeId, clockId)

    @inline
    def apply(value: Buffer, ticks: Int, nodeId: Int, clockId: Int) = `class`.New[CxTimeUuid](value, ticks, nodeId, clockId)

  }

}