package examples.nodejs.terminal

import org.scalajs.nodejs._
import org.scalajs.nodejs.globals.process
import org.scalajs.nodejs.readline.ReadlineOptions
import org.scalajs.dom.console
import org.scalajs.nodejs.Bootstrap
import org.scalajs.nodejs.readline.{Readline, ReadlineOptions}

/**
  * Tiny CLI Example
  * @author lawrence.daniels@gmail.com
  */
class TinyCLIExample(bootstrap: Bootstrap) {
  implicit val require = bootstrap.require

  val readline = Readline()
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
