package io.scalajs.nodejs.fs

import org.scalatest.{AsyncFunSpec, BeforeAndAfterEach}

import scala.concurrent.ExecutionContext

class FsAsyncTest extends AsyncFunSpec with BeforeAndAfterEach {
  override implicit val executionContext = ExecutionContext.Implicits.global

  private val dir = "x.v12/x.FsAsyncTest/foo/bar"

  override def afterEach(): Unit = {
    Seq(
      "x.v12/x.FsAsyncTest/foo/bar",
      "x.v12/x.FsAsyncTest/foo",
      "x.v12/x.FsAsyncTest",
      "x.v12"
    ).foreach { d =>
      if (Fs.existsSync(d)) Fs.rmdirSync(d)
    }
  }

  describe("Fs") {
    it("should support recursive-rmdir") {
      for {
        dirExistsBeforeMkdir <- Fs.existsFuture(dir)
        _                    <- Fs.mkdirFuture(dir, new MkdirOptions(recursive = true))
        _                    <- Fs.writeFileFuture("x.v12/hoge.txt", "foo")
        fileStat             <- Fs.statFuture("x.v12/hoge.txt")
        dirStat              <- Fs.statFuture(dir)
        dirExistsAfterMkdir  <- Fs.existsFuture(dir)
        _                    <- Fs.rmdirFuture("x.v12", new RmdirOptions(recursive = true))
        dirExistsAfterRmdir  <- Fs.existsFuture("x.v12")
      } yield {
        assert(!dirExistsBeforeMkdir)
        assert(fileStat.isFile())
        assert(dirStat.isDirectory())
        assert(dirExistsAfterMkdir)
        assert(!dirExistsAfterRmdir)
      }
    }
  }
}
