package examples.nodejs.io

import org.scalajs.nodejs.global.process
import org.scalajs.nodejs.readline.ReadlineOptions
import org.scalajs.nodejs.console
import org.scalajs.nodejs.Bootstrap
import org.scalajs.nodejs.fs.Fs
import org.scalajs.nodejs.readline.{Readline, ReadlineOptions}

/**
  * Files Example
  * @author lawrence.daniels@gmail.com
  */
class FilesExample(bootstrap: Bootstrap) {
  implicit val require = bootstrap.require
  import bootstrap._

  val fs = Fs()
  val readline = Readline()

  var lineNo = 0
  val file = __dirname + "/examples.js"
  val reader = readline.createInterface(new ReadlineOptions(
    input = fs.createReadStream(file),
    output = process.stdout,
    terminal = false
  ))

  reader.onLine { line =>
    lineNo += 1
    console.log("[%d] %s", lineNo, line)
  }

  reader.onClose { () =>
    console.log("# stream closed.")
  }

}
