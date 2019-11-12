package io.scalajs.nodejs.console_module

import io.scalajs.nodejs.fs.Fs
import org.scalatest.{BeforeAndAfterEach, FunSpec}

import scala.scalajs.js

class ConsoleTest extends FunSpec with BeforeAndAfterEach {
  private val logFileName = "x.nodejs10.ConsoleTest"

  override def afterEach(): Unit = {
    if (Fs.existsSync(logFileName)) Fs.unlinkSync(logFileName)
  }

  it("have table added in v10.0.0") {
    Console.table(js.Array("x", "y"))
  }

  it("have timeLog added in v10.7.0") {
    val label = "yay"
    Console.time(label)
    Console.timeLog(label)
    Console.timeEnd(label)
  }

  it("have constructor(options) added in v10.0.0") {
    val console = new Console(
      new ConsoleOptions(
        stdout = io.scalajs.nodejs.process.Process.stdout
      )
    )

    val label = "yay"
    console.time(label)
    console.timeEnd(label)
  }
}
