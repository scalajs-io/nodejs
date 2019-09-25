package io.scalajs.nodejs.buffer

import io.scalajs.nodejs.buffer.Buffer
import org.scalatest.FunSpec

import scala.scalajs.js

/**
  * Buffer Tests
  */
class BufferTest extends FunSpec {
  it("should support writeBigInt64BE, writeBigInt64LE, writeBigInt64BE and writeBigInt64BE") {
    val buf = Buffer.allocUnsafe(8)
    val v   = js.Dynamic.global.BigInt("0x0102030405060708")
    buf.writeBigInt64BE(v, 0);
    assert(Buffer.compare(buf, Buffer.from(js.Array(1, 2, 3, 4, 5, 6, 7, 8))) === 0)
  }
}
