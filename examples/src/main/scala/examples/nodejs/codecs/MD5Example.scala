package examples.nodejs.codecs

import com.github.ldaniels528.meansjs.nodejs.buffer.Buffer
import com.github.ldaniels528.meansjs.nodejs.crypto.Crypto
import com.github.ldaniels528.meansjs.nodejs.fs.Fs
import com.github.ldaniels528.meansjs.nodejs.{Bootstrap, _}

/**
  * MD5 Example
  * @author lawrence.daniels@gmail.com
  */
class MD5Example(bootstrap: Bootstrap) {
  import bootstrap._

  val crypto = require[Crypto]("crypto")
  val fs = require[Fs]("fs")

  process.argv.drop(3).headOption match {
    case Some(filename) =>
      val md5sum = crypto.createHash("md5")
      val stream = fs.ReadStream(filename)
      stream.onData((d: Buffer) => md5sum.update(d))
      stream.onEnd(() => {
        val md5 = md5sum.digest("hex")
        console.log(md5 + "  " + filename)
      })
    case None =>
      console.warn("No input file was specified")
      console.log("Usage: MD5Example <filename>")
  }

}
