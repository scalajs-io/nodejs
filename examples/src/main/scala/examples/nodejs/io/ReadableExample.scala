package examples.nodejs.io

import org.scalajs.nodejs._
import org.scalajs.nodejs.global.process
import org.scalajs.nodejs.Bootstrap
import org.scalajs.nodejs.stream.Stream

import scala.concurrent.duration._

/**
  * Readable Example 
  * @author lawrence.daniels@gmail.com
  */
class ReadableExample(bootstrap: Bootstrap) {
  implicit val require = bootstrap.require

  var Readable = Stream().Readable
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
