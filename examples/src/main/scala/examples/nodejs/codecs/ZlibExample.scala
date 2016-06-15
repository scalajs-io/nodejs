package examples.nodejs.codecs

import com.github.ldaniels528.meansjs.nodejs.buffer.Buffer
import com.github.ldaniels528.meansjs.nodejs.zlib.{CompressionOptions, Zlib}
import com.github.ldaniels528.meansjs.nodejs.{Bootstrap, console}
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

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
