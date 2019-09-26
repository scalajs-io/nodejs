package io.scalajs.nodejs

import io.scalajs.nodejs.Process.ProcessEnvExtensions
import io.scalajs.nodejs.os.OS
import org.scalatest.FunSpec

import scala.scalajs.js

/**
  * Process Tests
  */
class ProcessTest extends FunSpec {

  describe("Process") {
    val versionPrefix =
      if (TestEnvironment.isExecutedInExactNode8) "v8."
      else if (TestEnvironment.isExecutedInExactNode10) "v10."
      else if (TestEnvironment.isExecutedInExactNode12) "v12."
      else "Unknown node.js version"

    it("contains the following properties") {
      assert(process.arch.isInstanceOf[String])
      assert(process.argv.length === 1)
      assert(process.argv(0).endsWith("node"))
      assert(process.config("variables").asInstanceOf[js.Dictionary[String]]("host_arch") === OS.arch())
      assert(process.connected.isEmpty)
      assert(process.cwd().nonEmpty)
      assert(process.env("PATH").nonEmpty)
      assert(process.env.PATH === process.env("PATH"))
      assert(process.execArgv.length === 0)
      assert(process.execPath.endsWith("node"))
      assert(process.features.contains("debug"))
      assert(process.moduleLoadList.length > 0)
      assert(process.title.isInstanceOf[String])
      assert(process.version.startsWith(versionPrefix))
      assert(process.versions.node.map(v => s"v${v}").getOrElse("").startsWith(versionPrefix))

      // TODO: actually undefined in test
      // assert(process.stdout.isTTY)
      // assert(process.stderr.isTTY)
    }

  }

}
