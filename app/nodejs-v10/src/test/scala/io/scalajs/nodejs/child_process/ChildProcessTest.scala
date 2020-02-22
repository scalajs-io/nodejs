package io.scalajs.nodejs
package child_process

import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.TestHelper._
import io.scalajs.util.NodeJSConverters._

import scala.concurrent.{ExecutionContext, Promise}
import scala.scalajs.js
import scala.scalajs.js.|
import org.scalatest.funspec.AsyncFunSpec

/**
  * ChildProcess Test
  *
  */
class ChildProcessTest extends AsyncFunSpec {
  override implicit val executionContext = ExecutionContext.Implicits.global

  describe("Extension") {
    it("supports execFuture(...)") {
      for {
        r <- ChildProcess.execFuture("cat ./package.json | wc -l")
      } yield {
        assert(r._1.asInstanceOf[Buffer].toString().trim.toInt > 0)
      }
    }
  }

  describe("ChildProcess") {
    it("supports exec(...)") {
      val promise = Promise[(Output, Output)]()
      ChildProcess.exec(
        "cat ./package.json | wc -l",
        callback = (error: Error, stdout: Output, stderr: Output) => {
          if (isDefined(error)) {
            promise.failure(error.toException)
          } else {
            promise.success((stdout, stderr))
          }
        }
      )
      promise.future.map {
        case (stdout, stderr) =>
          assert(stdout.toString.trim.toInt === 19)
          assert(stderr.toString.trim === "")
      }
    }

    it("supports execFile(...)") {
      val promise = Promise[(Output, Output)]()
      ChildProcess.execFile(
        "ls",
        js.Array("-l"),
        callback = (error: Error, stdout: Output, stderr: Output) => {
          if (isDefined(error)) {
            promise.failure(error.toException)
          } else {
            promise.success((stdout, stderr))
          }
        }
      )
      promise.future.map {
        case (stdout, stderr) =>
          assert(stdout.toString.trim.linesIterator.length > 1)
          assert(stderr.toString.trim === "")
      }
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
