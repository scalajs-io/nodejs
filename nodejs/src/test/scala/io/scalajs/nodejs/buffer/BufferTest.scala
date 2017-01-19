package io.scalajs.nodejs.buffer

import io.scalajs.collection.Iterator.Entry
import org.scalatest.FunSpec

import scala.scalajs.js

/**
  * Buffer Tests
  * @author lawrence.daniels@gmail.com
  */
class BufferTest extends FunSpec {

  describe("Buffer") {

    it("should create buffers from strings") {
      val bufA = Buffer.from("Hello ")
      info(s"bufA => ${bufA.toString()}")
      val bufB = Buffer.from("World")
      info(s"bufB => ${bufB.toString()}")
      val bufC = bufA + bufB
      info(s"bufC => ${bufC.toString()}, length = ${bufC.byteLength()}")

      assert(bufA.toString() == "Hello ")
      assert(bufB.toString() == "World")
      assert(bufC.byteLength() == 11)
    }

    it("should sort buffers") {
      val buf1 = Buffer.from("ABC")
      val buf2 = Buffer.from("BCD")
      val buf3 = Buffer.from("ABCD")

      assert(buf1.compare(buf1) == 0)
      assert(buf1.compare(buf2) == -1)
      assert(buf1.compare(buf3) == -1)
      assert(buf2.compare(buf1) == 1)
      assert(buf2.compare(buf3) == 1)
    }

    it("should support iterating entries [classic]") {
      val buf = Buffer.from("Hello!")
      val it = buf.entries()
      var result: Entry[js.Any] = null
      do {
        result = it.next()
        if (!result.done) info(s"value: ${result.value}")
      } while (!result.done)
    }

    it("should support iterating entries [Scala]") {
      val buf = Buffer.from("Hello!")
      for (value <- buf.entries()) info(s"value: $value")
    }

  }

}
