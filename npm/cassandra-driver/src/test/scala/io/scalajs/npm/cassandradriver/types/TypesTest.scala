package io.scalajs.npm.cassandradriver.types

import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.console
import io.scalajs.npm.cassandradriver.types
import org.scalatest.FunSpec

import scala.scalajs.js

/**
  * Types Tests
  * @author lawrence.daniels@gmail.com
  */
class TypesTest  extends FunSpec {

  describe("Types") {

    it("generic type tests") {
      // BigDecimal
      val value0 = types.BigDecimal.fromNumber(Double.MaxValue)
      console.log("value0 =", value0, ", buffer =", types.BigDecimal.toBuffer(value0), "\n")

      // Integer
      val value1 = types.Integer.fromNumber(0xCAFEBABE)
      console.log("value1 =", value1, ", buffer =", types.Integer.toBuffer(value1), "\n")

      // Long
      val value2 = types.Long.fromNumber(0xDEADBEEFCAFEBABEL)
      console.log("value2 =", value2, ", buffer =", types.Long.toBuffer(value2), "\n")

      val value3 = new types.Long(0xDEADBEEF, 0xCAFEBABE, unsigned = true)
      console.log("value3 =", value3, ", buffer =", types.Long.toBuffer(value3), "\n")

      // Inet Address
      val ipAddressBuf = Buffer.from(js.Array(192, 168, 1, 5))
      val value4 = new types.InetAddress(ipAddressBuf)
      console.log("value4 =", value4, ", buffer =", ipAddressBuf, "\n")

      // Local Date
      val value5 = types.LocalDate.fromDate(new js.Date())
      console.log("value5 =", value5, ", now =", types.LocalDate.now(), "\n")

      // Local Time
      val value6 = types.LocalTime.fromDate(new js.Date())
      console.log("value6 =", value6, ", now =", types.LocalTime.now(), "\n")

      // Time UUID
      val value7 = types.TimeUuid.fromDate(new js.Date())
      console.log("value7 =", value7, ", now =", types.TimeUuid.now(), "\n")

      // UUID
      val value8 = types.Uuid.fromString("82effd01-2866-11e6-8cc9-4fb6522aae21")
      console.log("value8 =", value8, ", now =", types.Uuid.random(), "\n")
    }

  }

}
