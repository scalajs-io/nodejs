package io.scalajs.nodejs
package child_process

import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.util.ScalaJsHelper._
import org.scalatest.FunSpec

import scala.scalajs.js.|

/**
  * ChildProcess Test
  *
  */
class ChildProcessTest extends FunSpec {

  describe("ChildProcess") {

    it("supports exec(...)") {
      ChildProcess.exec(
        "cat ./package.json | wc -l",
        callback = (error: Error, stdout: Buffer | String, stderr: Buffer | String) => {
          if (isDefined(error)) {
            console.error(s"exec error: $error")
          }
          info(s"stdout: $stdout")
          info(s"stderr: $stderr")
        }
      )
    }

    it("supports execSync(...)") {
      val r = ChildProcess.execSync("cat ./package.json | wc -l")
      assert(r.asInstanceOf[Buffer].toString().trim.toInt > 0)
    }
  }

}
