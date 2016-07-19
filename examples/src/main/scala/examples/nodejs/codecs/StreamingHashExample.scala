package examples.nodejs.codecs

import org.scalajs.nodejs.Bootstrap
import org.scalajs.nodejs.crypto.Crypto
import org.scalajs.nodejs.fs.Fs
import org.scalajs.nodejs.globals.process

/**
  * Streaming Hash Example
  * @author lawrence.daniels@gmail.com
  */
class StreamingHashExample(bootstrap: Bootstrap) {
  implicit val require = bootstrap.require

  val crypto = Crypto()
  val fs = Fs()
  val hash = crypto.createHash("sha256")

  val input = fs.createReadStream("test.js")
  input.pipe(hash).pipe(process.stdout)

}
