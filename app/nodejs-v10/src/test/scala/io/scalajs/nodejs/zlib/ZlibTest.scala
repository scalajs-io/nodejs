package io.scalajs.nodejs.zlib

import io.scalajs.nodejs.buffer.Buffer

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import org.scalatest.funspec.AnyFunSpec

class ZlibTest extends AnyFunSpec {
  describe("Zlib") {
    it("should compress strings and buffers") {
      val original = Buffer.from("This is a compression example")

      for {
        compressed   <- Zlib.deflateFuture(original)
        uncompressed <- Zlib.unzipFuture(compressed, CompressionOptions(finishFlush = Zlib.Z_SYNC_FLUSH))
      } {
        assert(original.compare(uncompressed) === 0)
      }
    }
  }
}
