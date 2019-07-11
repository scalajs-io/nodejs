package io.scalajs.nodejs
package child_process

import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.util.ScalaJsHelper._
import org.scalatest.funspec.AnyFunSpec

import scala.scalajs.js.|

/**
  * ChildProcess Test
  * @author lawrence.daniels@gmail.com
  */
class ChildProcessTest extends AnyFunSpec {

  describe("ChildProcess") {

    it("supports exec(...)") {
      ChildProcess.exec("cat ./package.json | wc -l", (error: Error, stdout: Buffer | String, stderr: Buffer | String) => {
        if (isDefined(error)) {
          console.error(s"exec error: $error")
        }
        info(s"stdout: $stdout")
        info(s"stderr: $stderr")
      })
    }

  }

}
