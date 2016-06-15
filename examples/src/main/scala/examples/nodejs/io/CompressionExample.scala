package examples.nodejs.io

import com.github.ldaniels528.meansjs.nodejs.Bootstrap
import com.github.ldaniels528.meansjs.nodejs.zlib.Zlib
import org.scalajs.dom._

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
