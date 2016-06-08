package examples.nodejs.codecs

import com.github.ldaniels528.meansjs.nodejs.{Bootstrap, _}
import com.github.ldaniels528.meansjs.nodejs.crypto.Crypto
import com.github.ldaniels528.meansjs.nodejs.fs.Fs
import com.github.ldaniels528.meansjs.nodejs.global.process

/**
  * Streaming Hash Example
  * @author lawrence.daniels@gmail.com
  */
class StreamingHashExample(bootstrap: Bootstrap) {
  import bootstrap._

  val crypto = require[Crypto]("crypto")
  val fs = require[Fs]("fs")
  val hash = crypto.createHash("sha256")

  val input = fs.createReadStream("test.js")
  input.pipe(hash).pipe(process.stdout)

}
