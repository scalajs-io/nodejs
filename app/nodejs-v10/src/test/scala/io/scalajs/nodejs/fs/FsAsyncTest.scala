package io.scalajs.nodejs.fs

import org.scalatest.{AsyncFunSpec, BeforeAndAfterEach}

import scala.concurrent.ExecutionContext

class FsAsyncTest extends AsyncFunSpec with BeforeAndAfterEach {
  override implicit val executionContext = ExecutionContext.Implicits.global

  private val dir = "x.FsAsyncTest/foo/bar"

  override def afterEach(): Unit = {
    Seq(
      "x.FsAsyncTest/foo/bar",
      "x.FsAsyncTest/foo",
      "x.FsAsyncTest"
    ).foreach { d =>
      if (Fs.existsSync(d)) Fs.rmdirSync(d)
    }
  }

  describe("Fs") {
    it("should support recursive-mkdir") {
      for {
        dirExistsBeforeMkdir <- Fs.existsFuture(dir)
        _                    <- Fs.mkdirFuture(dir, new MkdirOptions(recursive = true))
        dirStat              <- Fs.statFuture(dir)
        dirExistsAfterMkdir  <- Fs.existsFuture(dir)
      } yield {
        assert(!dirExistsBeforeMkdir)
        assert(dirStat.isDirectory())
        assert(dirExistsAfterMkdir)
      }
    }

    it("should have alias for recursive-mkdir") {
      for {
        dirExistsBeforeMkdir <- Fs.existsFuture(dir)
        _                    <- Fs.mkdirRecursiveFuture(dir)
        dirStat              <- Fs.statFuture(dir)
        dirExistsAfterMkdir  <- Fs.existsFuture(dir)
      } yield {
        assert(!dirExistsBeforeMkdir)
        assert(dirStat.isDirectory())
        assert(dirExistsAfterMkdir)
      }
    }
  }
}
