package org.scalajs.nodejs.zlib

import org.scalajs.nodejs.NodeRequire._
import org.scalajs.nodejs.buffer.Buffer
import org.scalajs.nodejs.console
import org.scalajs.nodejs.util.ScalaJsHelper._
import utest.TestSuite

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue

/**
  * Zlib Tests
  * @author lawrence.daniels@gmail.com
  */
object ZlibTests extends TestSuite {

  override val tests = this {

    "zlib should compress strings or buffer" {
      val zlib = Zlib()

      val original = Buffer.from("This is a compression example")
      console.log("original =>", original.toString())

      for {
        compressed <- zlib.deflateFuture(original)
        uncompressed <- zlib.unzipFuture(compressed, new CompressionOptions(finishFlush = zlib.Z_SYNC_FLUSH))
      } {
        console.log("compressed =>", compressed.toString())
        console.log("uncompressed =>", uncompressed.toString())
        assert(original.compare(uncompressed) == 0)
      }
      1
    }
  }

}
