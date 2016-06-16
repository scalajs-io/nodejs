package examples.nodejs.io

import org.scalajs.dom._
import org.scalajs.nodejs.Bootstrap
import org.scalajs.nodejs.zlib.Zlib

/**
  * Compression Examples
  * @author lawrence.daniels@gmail.com
  */
class CompressionExample(bootstrap: Bootstrap) {
  implicit val require = bootstrap.require

  val zlib = Zlib()

  console.log("zlib = %j", zlib.Z_VERSION_ERROR)

  //zlib.flushAsync(1)

}
