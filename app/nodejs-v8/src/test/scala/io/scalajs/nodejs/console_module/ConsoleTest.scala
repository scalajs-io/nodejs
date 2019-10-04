package io.scalajs.nodejs.console_module

import io.scalajs.nodejs.TestEnvironment
import io.scalajs.nodejs.fs.{Fs, WriteStream}
import org.scalatest.{BeforeAndAfterEach, FunSpec}

import scala.scalajs.js.JavaScriptException

class ConsoleTest extends FunSpec with BeforeAndAfterEach {

  private val logFileName = "x.nodejs8.ConsoleTest"

  override def afterEach(): Unit = {
    if (Fs.existsSync(logFileName)) Fs.unlinkSync(logFileName)
  }

  private val failingWritable = Fs.createWriteStream(logFileName)
  failingWritable.close(_ => {})

  it("have constructor(stdout, stderr, ignoreErrors) added in v8.0.0") {
    val looseConsole = new Console(
      stdout = failingWritable,
      stderr = failingWritable,
      ignoreErrors = true
    )
    looseConsole.log("ok")
  }

  it("should support ignoreErrors") {
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
