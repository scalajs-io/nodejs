package nodejs

import io.scalajs.nodejs.console_module.{Console, ConsoleOptions}
import io.scalajs.nodejs.fs.Fs
import org.scalatest.{BeforeAndAfterEach, FunSpec}

import scala.scalajs.js
import scala.scalajs.js.JavaScriptException

class ConsoleTest extends FunSpec with BeforeAndAfterEach {

  private val logFileName = "x.nodejs8.ConsoleTest"

  override def afterEach(): Unit = {
    if (Fs.existsSync(logFileName)) Fs.unlinkSync(logFileName)
  }

  describe("NodeJS v10") {
    it("have constructor(stdout, stderr, ignoreErrors) added in v8.0.0") {
      val failingWritable = Fs.createWriteStream(logFileName)
      failingWritable.close(_ => {})
      val looseConsole = new Console(
        stdout = failingWritable,
        stderr = failingWritable,
        ignoreErrors = true
      )
      looseConsole.log("ok")

      val strictConsole = new Console(
        stdout = failingWritable,
        stderr = failingWritable,
        ignoreErrors = false
      )
      val ex = intercept[JavaScriptException] {
        strictConsole.log("ok")
      }
      assert(ex.getMessage().contains("write after end"))
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
          stdout = io.scalajs.nodejs.process.stdout
        )
      )

      val label = "yay"
      console.time(label)
      console.timeEnd(label)
    }
  }
}
