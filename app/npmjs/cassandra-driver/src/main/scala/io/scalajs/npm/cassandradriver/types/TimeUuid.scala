package io.scalajs.npm.cassandradriver.types

import io.scalajs.nodejs.buffer.Buffer

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * Cassandra TimeUUID
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("cassandra-driver", "types.TimeUuid")
class TimeUuid(value: Buffer | Int, ticks: Int, nodeId: Int, clockId: Int) extends js.Object

/**
  * Cassandra TimeUUID Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("cassandra-driver", "types.TimeUuid")
object TimeUuid extends js.Object {

  def fromDate(date: js.Date): TimeUuid = js.native

  def fromString(string: String): TimeUuid = js.native

  def min(): TimeUuid = js.native

  def max(): TimeUuid = js.native

  def now(): TimeUuid = js.native

}
