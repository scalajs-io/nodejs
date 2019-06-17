package io.scalajs.nodejs.fs

import io.scalajs.nodejs.buffer.Buffer
import org.scalatest.{AsyncFunSpec, BeforeAndAfterEach}

import scala.concurrent.{ExecutionContext, Future}

class FsAsyncTest extends AsyncFunSpec with BeforeAndAfterEach {

  private val file = "x.File.txt"

  override def afterEach(): Unit = {
    if (Fs.existsSync(file)) Fs.unlinkSync(file)
  }

  override implicit val executionContext = ExecutionContext.Implicits.global

  describe("Fs") {
    it("support basic operations") {
      for {
        _                 <- Future.successful("")
        _                 <- Fs.writeFileFuture(file, "content")
        exists            <- Fs.existsFuture(file)
        readBuffer        <- Fs.readFileFuture(file)
        _                 <- Fs.unlinkFuture(file)
        existsAfterUnlink <- Fs.existsFuture(file)
      } yield {
        assert(exists)
        assert(readBuffer.asInstanceOf[Buffer].toString() == "content")
        assert(!existsAfterUnlink)
      }
    }

    describe("existsFuture") {
      it("should return false if not exist") {
        for {
          exists <- Fs.existsFuture(file)
        } yield {
          assert(!exists)
        }
      }
    }
  }
}
