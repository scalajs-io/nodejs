package io.scalajs.nodejs.readline

import io.scalajs.nodejs.fs.Fs
import io.scalajs.nodejs.{console, process}
import org.scalatest.FunSpec

/**
  * Readline Tests
  * @author lawrence.daniels@gmail.com
  */
class ReadlineTest extends FunSpec {

  describe("Readline") {

    it("should read/stream files from disk") {
      var lineNo = 0
      val file = "./package.json"
      val reader = Readline.createInterface(new ReadlineOptions(
        input = Fs.createReadStream(file),
        output = process.stdout,
        terminal = false
      ))

      reader.onLine { line =>
        lineNo += 1
        info(f"[$lineNo%02d] $line")
      }

      reader.onClose { () =>
        info("# stream closed.")
      }
    }

    it("has REPL-like functionality") {
      val rl = Readline.createInterface(new ReadlineOptions(input = process.stdin, output = process.stdout))
      rl.setPrompt("OHAI> ")
      rl.prompt()

      rl.onLine { line =>
        line.trim() match {
          case "hello" =>
            console.log("world!")
          case _ =>
            console.log(s"Say what? I might have heard `${line.trim()}`")
        }
        rl.prompt()

      } onClose { () =>
        console.log("Have a great day!")
        //process.exit(0)
      }
    }

  }

}

