package io.scalajs.nodejs
package child_process

import io.scalajs.nodejs.Error
import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.util.ScalaJsHelper._
import org.scalatest.FunSpec

import scala.scalajs.js
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

    it("supports execFile(...)") {
      ChildProcess.execFile(
        "ls",
        js.Array("-l"),
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

    it("supports execFileSync(...)") {
      val r = ChildProcess.execFileSync("ls", js.Array("-l"))
      assert(r.asInstanceOf[Buffer].toString().length > 0)
    }

    it("supports connected") {
      assert(
        ChildProcess
          .exec(
            "echo 1",
            callback = (error: Error, stdout: Buffer | String, stderr: Buffer | String) => {}
          )
          .connected === false
      )
    }

    it("supports killed") {
      assert(
        ChildProcess
          .exec(
            "echo 1",
            callback = (error: Error, stdout: Buffer | String, stderr: Buffer | String) => {}
          )
          .killed === false
      )
    }

    it("supports pid") {
      assert(
        ChildProcess
          .exec(
            "echo 1",
            callback = (error: Error, stdout: Buffer | String, stderr: Buffer | String) => {}
          )
          .pid > 0
      )
    }
  }
}
