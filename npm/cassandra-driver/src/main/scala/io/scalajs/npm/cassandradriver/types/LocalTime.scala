package io.scalajs.npm.cassandradriver.types

import io.scalajs.nodejs.buffer.Buffer

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * Cassandra LocalTime
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("cassandra-driver", "types.LocalTime")
class LocalTime(year: Int, month: Int, day: Int) extends js.Object

/**
  * Cassandra LocalTime Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("cassandra-driver", "types.LocalTime")
object LocalTime extends js.Object {

  def fromBuffer(buffer: Buffer): LocalTime = js.native

  def fromDate(date: js.Date): LocalTime = js.native

  def fromMilliseconds(millis: Int | Double): LocalTime = js.native

  def fromString(string: String): LocalTime = js.native

  def now(): LocalTime = js.native

}
