package io.scalajs.npm.cassandradriver.types

import io.scalajs.nodejs.buffer.Buffer

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Cassandra BigDecimal
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("cassandra-driver", "types.BigDecimal")
class BigDecimal(value: Double, scale: Int = js.native) extends js.Object

/**
  * Cassandra BigDecimal Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("cassandra-driver", "types.BigDecimal")
object BigDecimal extends js.Object {

  def fromBuffer(buffer: Buffer): BigDecimal = js.native

  def toBuffer(value: BigDecimal): Buffer = js.native

  def fromString(value: String): BigDecimal = js.native

  def fromNumber(number: Number): BigDecimal = js.native

}
