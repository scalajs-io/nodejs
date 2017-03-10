package io.scalajs.nodejs.zlib

import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.util.PromiseHelper._
import org.scalatest.FunSpec

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue

/**
  * Zlib Tests
  * @author lawrence.daniels@gmail.com
  */
class ZlibTest extends FunSpec {

  describe("Zlib") {

    it("should compress strings and buffers") {
      val original = Buffer.from("This is a compression example")

      for {
        compressed   <- Zlib.deflateAsync(original).future
        uncompressed <- Zlib.unzipAsync(compressed, new CompressionOptions(finishFlush = Zlib.Z_SYNC_FLUSH)).future
      } {
        info(s"compressed => ${compressed.toString()}")
        info(s"uncompressed => ${uncompressed.toString()}")
        assert(original.compare(uncompressed) == 0)
      }
    }
  }

}
