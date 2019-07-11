package io.scalajs.npm.mkdirp

import io.scalajs.nodejs.fs.Fs
import org.scalatest.funspec.AnyFunSpec

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.util.{Failure, Success}

/**
  * Mkdirp Test Suite
  * @author lawrence.daniels@gmail.com
  */
class MkdirpTest extends AnyFunSpec {

  describe("Mkdirp") {

    it("supports asynchronous execution via callbacks") {
      val path = "./src/test/resources/foo/bar"

      // delete the directory if it exists
      if (Fs.existsSync(path)) Fs.rmdirSync(path)

      Mkdirp(path, { (err, result) =>
        if (err == null) info(s"Success: $result")
        else fail("Failed: " + err.code)
      })
    }

    it("supports asynchronous execution via promises") {
      val path = "./src/test/resources/foo/baz"

      // delete the directory if it exists
      if (Fs.existsSync(path)) Fs.rmdirSync(path)

      Mkdirp.future(path) onComplete {
        case Success(result) => info(s"Success: $result")
        case Failure(e) =>
          fail(s"Failed: ${Option(e).map(_.getMessage).orNull}")
      }
    }

    it("supports synchronous execution") {
      val path = "./src/test/resources/foo/barz"

      // delete the directory if it exists
      if (Fs.existsSync(path)) Fs.rmdirSync(path)

      val result = Mkdirp.sync(path)
      info(s"Success: $result")
    }

  }

}
