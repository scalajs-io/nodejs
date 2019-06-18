package io.scalajs.npm.glob

import io.scalajs.JSON
import io.scalajs.nodejs.Assert
import io.scalajs.util.ScalaJsHelper._
import org.scalatest.FunSpec

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js
import scala.util.{Failure, Success}

/**
  * Glob Tests
  * @author lawrence.daniels@gmail.com
  */
class GlobTest extends FunSpec {
  private val expected = js.Array(
    "src/main/scala/io/scalajs/npm/glob/Glob.scala",
    "src/main/scala/io/scalajs/npm/glob/GlobOptions.scala",
    "src/main/scala/io/scalajs/npm/glob/package.scala",
    "src/test/scala/io/scalajs/npm/glob/GlobTest.scala")

  describe("Glob") {

    it("supports asynchronous execution via callbacks") {
      Glob("**/*.scala", (err, files) => {
        if (isDefined(err)) alert(s"callback failed: ${JSON.stringify(err)}")
        else {
          info(s"callback: ${JSON.stringify(files)}")
          Assert.deepEqual(files, expected)
        }
      })
    }

    it("supports asynchronous execution via promises") {
      Glob.future("**/*.scala") onComplete {
        case Success(files) =>
          info(s"promise: ${JSON.stringify(files)}")
          Assert.deepEqual(files, expected)
        case Failure(e) =>
          alert(s"promise failed: ${e.getMessage}")
      }
    }

    it("supports synchronous execution") {
      val files = Glob.sync("**/*.scala")
      info(s"synchronous: ${JSON.stringify(files)}")
      Assert.deepEqual(files, expected)
    }

    it("supports instantiated execution") {
      val glob = new Glob("**/*.scala", (err, files) => {
        info(s"instantiated: files = ${JSON.stringify(files)}")
        Assert.deepEqual(files, expected)
      })
      //info(s"found = ${JSON.stringify(glob.found)}")
      //info(s"aborted:       ${JSON.stringify(glob.aborted)}")
      //info(s"cache:         ${glob.cache}")
      info(s"minimatch:     ${JSON.stringify(glob.minimatch)}")
      info(s"realpathCache: ${JSON.stringify(glob.realpathCache)}")
      info(s"symlinks:      ${JSON.stringify(glob.symlinks)}")
    }

  }

}
