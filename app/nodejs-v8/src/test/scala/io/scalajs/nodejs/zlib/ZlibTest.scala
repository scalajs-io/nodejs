package io.scalajs.nodejs.zlib

import io.scalajs.nodejs.buffer.Buffer
import org.scalatest.FunSpec

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue

class ZlibTest extends FunSpec {
  describe("Zlib") {
    it("should compress strings and buffers") {
      val original = Buffer.from("This is a compression example")

      for {
        compressed   <- Zlib.deflateFuture(original)
        uncompressed <- Zlib.unzipFuture(compressed, new CompressionOptions(finishFlush = Zlib.Z_SYNC_FLUSH))
      } {
        assert(original.compare(uncompressed) === 0)
      }
    }
  }
}
