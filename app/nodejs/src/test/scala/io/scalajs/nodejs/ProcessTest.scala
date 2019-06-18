package io.scalajs.nodejs

import io.scalajs.JSON
import io.scalajs.nodejs.Process.ProcessEnvExtensions
import org.scalatest.FunSpec

import scala.scalajs.js

/**
  * Process Tests
  * @author lawrence.daniels@gmail.com
  */
class ProcessTest extends FunSpec {

  describe("Process") {

    it("contains the following properties") {
      show("process.arch", process.arch)
      show("process.argv", process.argv)
      show("process.config", process.config)
      show("process.connected", process.connected)
      show("process.cwd()", process.cwd())
      show("process.domain", process.domain)
      show("process.env", process.env)
      show("process.env.NODE_ENV", process.env.NODE_ENV)
      show("process.env.PATH", process.env.PATH)
      show("process.execArgv", process.execArgv)
      show("process.execPath", process.execPath)
      show("process.features", process.features)
      show("process.moduleLoadList", process.moduleLoadList)
      show("process.title", process.title)
      show("process.version", process.version)
      show("process.versions", JSON.stringify(process.versions))
      //show("process.stdout.isTTY", process.stdout.isTTY)
      //show("process.stderr.isTTY", process.stderr.isTTY)
    }

  }

  private def show(label: String, value: js.Any) = info(s"$label: $value")

}
