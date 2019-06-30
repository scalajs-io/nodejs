package io.scalajs.nodejs.child_process

import io.scalajs.nodejs.buffer.Buffer
import org.scalatest.AsyncFunSpec

import scala.concurrent.ExecutionContext

class ChildProcessAsyncTest extends AsyncFunSpec {
  override implicit val executionContext = ExecutionContext.Implicits.global

  describe("ChildProcess") {
    it("supports execFuture(...)") {
      for {
        r <- ChildProcess.execFuture("cat ./package.json | wc -l")
      } yield {
        assert(r._1.asInstanceOf[Buffer].toString().trim.toInt > 0)
      }
    }
  }

}
