package io.scalajs.nodejs.zlib

import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.util.ScalaJsHelper._
import org.scalatest.FunSpec

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue

/**
  * Zlib Tests
  * @author lawrence.daniels@gmail.com
  */
class ZlibTest extends FunSpec {

  describe("Zlib") {

    it("should compress strings or buffer") {
      val original = Buffer.from("This is a compression example")

      for {
        compressed   <- Zlib.deflateFuture(original)
        uncompressed <- Zlib.unzipFuture(compressed, new CompressionOptions(finishFlush = Zlib.Z_SYNC_FLUSH))
      } {
        info(s"compressed => ${compressed.toString()}")
        info(s"uncompressed => ${uncompressed.toString()}")
        assert(original.compare(uncompressed) == 0)
      }
    }
  }

}
