package examples.nodejs.io

import com.github.ldaniels528.meansjs.nodejs._
import com.github.ldaniels528.meansjs.nodejs.global.process
import com.github.ldaniels528.meansjs.nodejs.stream.Stream

import scala.concurrent.duration._

/**
  * Readable Example 
  * @author lawrence.daniels@gmail.com
  */
class ReadableExample(bootstrap: Bootstrap) {
  import bootstrap._

  var Readable = require[Stream]("stream").Readable
  var rs = Readable()
  var c = 97 - 1

  rs._read = () => {
    if (c >= 'z') rs.push(null)
    else setTimeout(() => rs.push(String.valueOf({c += 1; c})), 100.millis)
  }

  rs.pipe(process.stdout)

  process.on("exit", () => console.error("\n_read() called " + (c - 97) + " times"))
  process.stdout.on("error", () => process.exit())

}
