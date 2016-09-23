package org.scalajs.nodejs.readline

import org.scalajs.nodejs.NodeRequire._
import org.scalajs.nodejs.fs.Fs
import org.scalajs.nodejs.globals.process
import utest._

/**
  * Readline Tests
  * @author lawrence.daniels@gmail.com
  */
object ReadlineTests extends TestSuite {

  override val tests = this {

    "readline should read/stream files from disk" - {
      val fs = Fs()
      val readline = Readline()

      var lineNo = 0
      val file = "./package.json"
      val reader = readline.createInterface(new ReadlineOptions(
        input = fs.createReadStream(file),
        output = process.stdout,
        terminal = false
      ))

      reader.onLine { line =>
        lineNo += 1
        println("[%d] %s", lineNo, line)
      }

      reader.onClose { () =>
        println("# stream closed.")
      }
    }

  }

}

