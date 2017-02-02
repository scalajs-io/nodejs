package io.scalajs.nodejs
package child_process

import io.scalajs.util.ScalaJsHelper._
import org.scalatest.FunSpec

/**
  * ChildProcess Test
  * @author lawrence.daniels@gmail.com
  */
class ChildProcessTest extends FunSpec {

  describe("ChildProcess") {

    it("supports exec(...)") {
      ChildProcess.exec(
        "cat ./package.json | wc -l",
        (error, stdout, stderr) => {
          if (isDefined(error)) {
            console.error(s"exec error: $error")
          }
          info(s"stdout: $stdout")
          info(s"stderr: $stderr")
        }
      )
    }

  }

}
