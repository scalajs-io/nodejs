package examples.nodejs.io

import com.github.ldaniels528.meansjs.nodejs.fs.Fs
import com.github.ldaniels528.meansjs.nodejs.global.process
import com.github.ldaniels528.meansjs.nodejs.readline.{Readline, ReadlineOptions}
import com.github.ldaniels528.meansjs.nodejs.{Bootstrap, console}

/**
  * Files Example
  * @author lawrence.daniels@gmail.com
  */
class FilesExample(bootstrap: Bootstrap) {
  import bootstrap._

  val fs = require[Fs]("fs")
  val readline = require[Readline]("readline")

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
