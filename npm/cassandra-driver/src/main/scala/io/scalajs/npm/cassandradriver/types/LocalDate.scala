package io.scalajs.npm.cassandradriver.types

import io.scalajs.nodejs.buffer.Buffer

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Cassandra Local Date
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("cassandra-driver", "types.LocalDate")
class LocalDate(year: Int, month: Int, day: Int) extends js.Object

/**
  * Cassandra Local Date Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("cassandra-driver", "types.LocalDate")
object LocalDate extends js.Object {

  def fromBuffer(buffer: Buffer): LocalDate = js.native

  def fromDate(date: js.Date): LocalDate = js.native

  def fromString(string: String): LocalDate = js.native

  def now(): LocalDate = js.native

  def utcNow(): LocalDate = js.native

}
