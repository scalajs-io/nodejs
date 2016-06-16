package examples.nodejs.codecs

import org.scalajs.nodejs.zlib.Zlib
import org.scalajs.nodejs.console
import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.nodejs.Bootstrap
import org.scalajs.nodejs.buffer.Buffer
import org.scalajs.nodejs.util.ScalaJsHelper
import org.scalajs.nodejs.zlib.{CompressionOptions, Zlib}

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue

/**
  * Zlib Example
  * @author lawrence.daniels@gmail.com
  */
class ZlibExample(bootstrap: Bootstrap) {
  implicit val require = bootstrap.require

  val zlib = Zlib()

  val original = Buffer.from("This is a compression example")
  console.log("original =>", original.toString())

  for {
    compressed <- zlib.deflateFuture(original)
    uncompressed <- zlib.unzipFuture(compressed, new CompressionOptions(finishFlush = zlib.Z_SYNC_FLUSH))
  } {
    console.log("compressed =>", compressed.toString())
    console.log("uncompressed =>", uncompressed.toString())
  }

}
