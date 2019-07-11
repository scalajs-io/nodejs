package io.scalajs.npm.nodefetch

import io.scalajs.JSON
import io.scalajs.nodejs.fs.Fs
import org.scalatest.funspec.AnyFunSpec

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.util.{Failure, Success}

/**
  * Node-Fetch Test Suite
  * @author lawrence.daniels@gmail.com
  */
class NodeFetchTest extends AnyFunSpec {

  describe("NodeFetch") {

    it("asynchronously retrieves contents via HTTP") {
      NodeFetch("https://assets-cdn.github.com/images/modules/logos_page/Octocat.png").toFuture onComplete {
        case Success(resp) =>
          val dest = Fs.createWriteStream("./octocat.png")
          resp.body.pipe(dest)
        case Failure(e) =>
          alert(e.getMessage)
      }
    }

    it("returns a response containing the typical properties") {
      NodeFetch("https://github.com/").toFuture onComplete {
        case Success(res) =>
          info(s"ok => ${res.ok}")
          info(s"status => ${res.status}")
          info(s"statusText => ${res.statusText}")
          info(s"headers.raw() => ${JSON.stringify(res.headers.raw())}")
          info(s"headers.get('content-type') => ${res.headers.get("content-type").orNull}")
        case Failure(e) =>
          alert(e.getMessage)
      }
    }

  }

}
