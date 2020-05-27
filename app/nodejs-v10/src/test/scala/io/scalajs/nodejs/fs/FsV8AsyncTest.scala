package io.scalajs.nodejs.fs

import io.scalajs.nodejs.buffer.Buffer
import org.scalatest.BeforeAndAfterEach

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}
import org.scalatest.funspec.AsyncFunSpec

class FsV8AsyncTest extends AsyncFunSpec with BeforeAndAfterEach {
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
        assert(readBuffer.asInstanceOf[Buffer].toString() === "content")
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

    describe("accessFuture") {
      it("should succeed") {
        for {
          _ <- Fs.accessFuture("package.json")
          _ <- Fs.accessFuture("package.json", Fs.constants.R_OK)
        } yield {
          succeed
        }
      }

      it("should fail: no such file") {
        Fs.accessFuture("package.json111").transformWith {
          case Failure(_) => succeed
          case Success(_) => fail("expected failure")
        }
      }

      it("should fail: invalid file mode") {
        Fs.accessFuture("package.json", Fs.constants.X_OK).transformWith {
          case Failure(_) => succeed
          case Success(_) => fail("expected failure")
        }
      }
    }

    it("should support appendFileFuture") {
      for {
        _              <- Fs.appendFileFuture("x.AppendFile.txt", "yay")
        _              <- Fs.appendFileFuture("x.AppendFile.sh", "echo 0", FileAppendOptions(mode = Fs.constants.X_OK))
        defaultStat    <- Fs.statFuture("x.AppendFile.txt")
        executableStat <- Fs.statFuture("x.AppendFile.sh")
        _              <- Fs.unlinkFuture("x.AppendFile.txt")
        _              <- Fs.unlinkFuture("x.AppendFile.sh")
      } yield {
        assert((defaultStat.mode & Fs.constants.R_OK) > 0)
        assert((defaultStat.mode & Fs.constants.X_OK) === 0)
        assert((executableStat.mode & Fs.constants.R_OK) === 0)
        assert((executableStat.mode & Fs.constants.X_OK) > 0)
        succeed
      }
    }

    it("should support copyFileFuture") {
      for {
        _    <- Fs.appendFileFuture("x.CopyFile.txt", "yay")
        _    <- Fs.copyFileFuture("x.CopyFile.txt", "x.CopyFile_2.txt")
        _    <- Fs.copyFileFuture("x.CopyFile.txt", "x.CopyFile_2.txt") // succeed
        _    <- Fs.copyFileFuture("x.CopyFile.txt", "x.CopyFile_2.txt", Fs.constants.COPYFILE_EXCL).failed
        stat <- Fs.statFuture("x.CopyFile_2.txt")
        _    <- Fs.unlinkFuture("x.CopyFile.txt")
        _    <- Fs.unlinkFuture("x.CopyFile_2.txt")
      } yield {
        assert(stat.isFile())
      }
    }
  }
}
