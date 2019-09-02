package io.scalajs.nodejs.buffer

import io.scalajs.collection.Iterator.Entry
import io.scalajs.nodejs.buffer
import nodejs.TestEnvironment
import org.scalatest.FunSpec

import scala.scalajs.js
import scala.scalajs.js.typedarray.{ArrayBuffer, DataView, Uint8Array}

/**
  * Buffer Tests
  */
class BufferTest extends FunSpec {

  describe("Buffer") {
    describe("instance members") {
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
        val buf                   = Buffer.from("Hello!")
        val it                    = buf.entries()
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

      it("should support buffer property") {
        val arrayBuffer = new ArrayBuffer(16)
        val buf         = Buffer.from(arrayBuffer)
        assert(buf.buffer === arrayBuffer)
      }

      it("should support byteOffset property") {
        import scala.scalajs.js.typedarray.Int8Array
        val nodeBuffer = Buffer.from(js.Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9))
        val typedarray = new Int8Array(nodeBuffer.buffer, nodeBuffer.byteOffset, nodeBuffer.length)
        assert(typedarray.mkString == new Int8Array(js.Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)).mkString)
      }

      it("should support byteLength for specific types") {
        assert(Buffer.byteLength("\u00bd + \u00bc = \u00be") == 12)
        assert(Buffer.byteLength("\u00bd + \u00bc = \u00be", "utf8") == 12)
        assert(Buffer.byteLength(Buffer.alloc(12)) == 12)
        assert(Buffer.byteLength(new Uint8Array(12)) == 12)
        assert(Buffer.byteLength(new DataView(new ArrayBuffer(12))) == 12)
        assert(Buffer.byteLength(new ArrayBuffer(12)) == 12)
      }

      it("should support fill") {
        val otherBuf = Buffer.from("abcdef")
        assert(Buffer.alloc(10).fill(otherBuf).toString() == "abcdefabcd")
      }
    }

    describe("class members") {
      it("should support fields") {
        assert(Buffer.poolSize > 0)
      }

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

      it("should create buffers from buffers") {
        val buffer = Buffer.from("hello")
        assert(Buffer.from(buffer).toString() == "hello")

        // TODO: when Scala.js added TypedArray.from
        // val uints = Uint8Array.from(???)
        // assert(Buffer.from(uints).toString() == "worlds")
      }

      it("should support concat") {
        val buffers = js.Array(Buffer.from("abc"), Buffer.from("def"), Buffer.from("ghijk"))
        assert(Buffer.compare(Buffer.concat(buffers), Buffer.from("abcdefghijk")) == 0)
        assert(Buffer.compare(Buffer.concat(buffers, 5), Buffer.from("abcde")) == 0)

        val uints: js.Array[Uint8Array] = js.Array(Buffer.from("abc"), Buffer.from("def"), Buffer.from("ghijk"))
        assert(Buffer.compare(Buffer.concat(uints), Buffer.from("abcdefghijk")) == 0)
        assert(Buffer.compare(Buffer.concat(uints, 5), Buffer.from("abcde")) == 0)
      }

      it("should support isBufrer") {
        assert(!Buffer.isBuffer(null))
        assert(!Buffer.isBuffer(js.Object()))
        assert(!Buffer.isBuffer(js.Array(1, 2, 3)))
        assert(Buffer.isBuffer(Buffer.from("hello")))
      }

      it("should support isEncoding") {
        assert(!Buffer.isEncoding(null))
        if (TestEnvironment.isExecutedInExactNode8) {
          assert(Buffer.isEncoding(""))
        } else {
          assert(!Buffer.isEncoding(""))
        }
        assert(Buffer.isEncoding("utf8"))
        assert(Buffer.isEncoding("UTF-8"))
      }

    }

    describe("module members") {
      it("should support transcode") {
        // package object method
        assert(buffer.transcode(Buffer.from("hello"), "utf8", "ascii").toString("ascii") == "hello")
        assert(buffer.transcode(Buffer.from("€"), "utf8", "ascii").toString("ascii") == "?")

        // extension method
        assert(Buffer.transcode(Buffer.from("hello"), "utf8", "ascii").toString("ascii") == "hello")
        assert(Buffer.transcode(Buffer.from("€"), "utf8", "ascii").toString("ascii") == "?")
      }

      it("should support fields") {
        // package object method
        assert(buffer.INSPECT_MAX_BYTES > 0)
        assert(buffer.kMaxLength > 0)

        // extension method
        assert(Buffer.INSPECT_MAX_BYTES > 0)
        assert(Buffer.kMaxLength > 0)
      }

      it("should support constants") {
        // package object method
        assert(buffer.constants.MAX_LENGTH > 0)
        assert(buffer.constants.MAX_STRING_LENGTH > 0)

        // extension method
        assert(Buffer.constants.MAX_LENGTH > 0)
        assert(Buffer.constants.MAX_STRING_LENGTH > 0)
      }
    }
  }

}
