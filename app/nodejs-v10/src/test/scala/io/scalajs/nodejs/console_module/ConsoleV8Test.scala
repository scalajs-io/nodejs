package io.scalajs.nodejs.console_module

import io.scalajs.nodejs.TestEnvironment
import io.scalajs.nodejs.fs.{Fs, WriteStream}
import org.scalatest.BeforeAndAfterEach

import scala.scalajs.js.JavaScriptException
import org.scalatest.funspec.AnyFunSpec

class ConsoleV8Test extends AnyFunSpec with BeforeAndAfterEach {
  private val logFileName                  = "x.nodejs8.ConsoleTest"
  private var failingWritable: WriteStream = null

  override def afterEach(): Unit = {
    if (Fs.existsSync(logFileName)) Fs.unlinkSync(logFileName)
  }

  override def beforeEach(): Unit = {
    failingWritable = Fs.createWriteStream(logFileName)
    failingWritable.close(_ => {})
  }

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
    // https://github.com/nodejs/node/issues/33628
    assume(TestEnvironment.isExecutedInNode14OrNewer === false)
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
