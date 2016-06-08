package examples.nodejs.terminal

import com.github.ldaniels528.meansjs.nodejs._
import com.github.ldaniels528.meansjs.nodejs.global.process
import com.github.ldaniels528.meansjs.nodejs.readline.{Readline, ReadlineOptions}
import org.scalajs.dom.console

/**
  * Tiny CLI Example
  * @author lawrence.daniels@gmail.com
  */
class TinyCLIExample(bootstrap: Bootstrap) {
  import bootstrap._

  val readline = require[Readline]("readline")
  val rl = readline.createInterface(new ReadlineOptions(input = process.stdin, output = process.stdout))

  rl.setPrompt("OHAI> ")
  rl.prompt()

  rl.onLine((line: String) => {
    line.trim() match {
      case "hello" =>
        console.log("world!")
      case _ =>
        console.log(s"Say what? I might have heard `${line.trim()}`")
    }
    rl.prompt()

  }).onClose(() => {
    console.log("Have a great day!")
    process.exit(0)
  })

}
