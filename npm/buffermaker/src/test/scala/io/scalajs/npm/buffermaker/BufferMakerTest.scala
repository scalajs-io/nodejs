package io.scalajs.npm.buffermaker

import io.scalajs.nodejs.Assert
import io.scalajs.npm.bignum.BigNum
import org.scalatest._

/**
  * BufferMaker Tests
  * @author lawrence.daniels@gmail.com
  */
class BufferMakerTest extends FunSpec {

  describe("BufferMaker") {

    it("supports binary strings 1") {
      val someBuffer = new BufferMaker()
        .UInt8(1)
        .UInt16BE(2)
        .UInt32BE(3)
        .Int64BE(new BigNum("4")) // uses the BigNum library
        .string("this is a test!")
        .make()

      info(someBuffer.toString())
      Assert(someBuffer.toString(), "<Buffer 01 00 02 00 00 00 03 00 00 00 00 00 00 00 04 74 68 69 73 20 69 73 20 61 20 74 65 73 74 21>")
    }

    it("supports binary strings 2") {
      val someBuffer = new BufferMaker()
        .Int8(1)
        .Int16BE(2)
        .Int32BE(3)
        .Int64BE(4)
        .make()

      info(someBuffer.toString())
      Assert(someBuffer.toString(), "<Buffer 01 00 02 00 00 00 03 00 00 00 00 00 00 00 04>")
    }

    it("supports mixed endian binary strings") {
      val someBuffer = new BufferMaker()
        .UInt16LE(1)
        .UInt32LE(2)
        .Int16LE(3)
        .Int32LE(4)
        .FloatLE(5)
        .FloatBE(6)
        .DoubleLE(7)
        .DoubleBE(8)
        .make()

      info(someBuffer.toString())
      Assert(someBuffer.toString(), "<Buffer 01 00 02 00 00 00 03 00 04 00 00 00 00 00 a0 40 40 c0 00 00 00 00 00 00 00 00 1c 40 40 20 00 00 00 00 00 00>")
    }

  }

}
