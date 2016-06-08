package examples.nodejs.io

import com.github.ldaniels528.meansjs.nodejs.Bootstrap
import com.github.ldaniels528.meansjs.nodejs.fs.Fs
import com.github.ldaniels528.meansjs.nodejs.global.process
import com.github.ldaniels528.meansjs.nodejs.readline.{Readline, ReadlineOptions}
import org.scalajs.dom.console

/**
  * Files Example
  * @author lawrence.daniels@gmail.com
  */
class FilesExample(bootstrap: Bootstrap) {
  import bootstrap._

  val fs = require[Fs]("fs")
  val readline = require[Readline]("readline")
  var lineNo = 0

  val file = __dirname + "/../README.md"
  val reader = readline.createInterface(new ReadlineOptions(
    input = fs.createReadStream(file),
    output = process.stdout,
    terminal = false
  ))

  reader.onLine((line: String) => {
    lineNo += 1
    console.log("[%d] %s", lineNo, line)
  })

}
