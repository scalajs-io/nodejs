package nodejs

import io.scalajs.nodejs.console_module.Console
import io.scalajs.nodejs.fs.Fs
import org.scalatest.{BeforeAndAfterEach, FunSpec}

import scala.scalajs.js.JavaScriptException

class ConsoleTest extends FunSpec with BeforeAndAfterEach {

  private val logFileName = "x.nodejs8.ConsoleTest"

  override def afterEach(): Unit = {
    if (Fs.existsSync(logFileName)) Fs.unlinkSync(logFileName)
  }

  it("have constructor(stdout, stderr, ignoreErrors) added in v8.0.0") {
    val failingWritable = Fs.createWriteStream(logFileName)
    failingWritable.close(_ => {})
    val looseConsole = new Console(
      stdout = failingWritable,
      stderr = failingWritable,
      ignoreErrors = true
    )
    looseConsole.log("ok")
  }

  it("should suppor ignoreErrors") {
    assume(TestEnvironment.isExecutedInNode10OrNewer)
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
}
