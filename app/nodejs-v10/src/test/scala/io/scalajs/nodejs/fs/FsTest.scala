package io.scalajs.nodejs.fs

import io.scalajs.nodejs.setImmediate
import io.scalajs.util.NodeJSConverters._
import io.scalajs.util.ScalaJsHelper._
import org.scalatest.AsyncFunSpec

import scala.concurrent.{ExecutionContext, Promise}

/**
  * File System (Fs) Tests
  *
  */
class FsTest extends AsyncFunSpec {
  override implicit val executionContext = ExecutionContext.Implicits.global

  final val testResources = "./app/current/src/test/resources/"

  describe("Fs") {
    it("supports watching files") {
      val promise = Promise[(String, String)]()
      val watcher = Fs.watch(s"${testResources}", (eventType, file) => {
        if (!promise.isCompleted) {
          promise.success((eventType, file))
        }
      })
      assert(watcher !== null)

      setImmediate(() =>
        Fs.writeFile(s"${testResources}1.txt", "Hello", error => {
          if (isDefined(error)) {
            promise.failure(error.toException)
          }
        })
      )

      promise.future.map {
        case (eventType, file) =>
          assert(eventType === "change")
          assert(file === "1.txt")
      }
    }

    it("should stream data") {
      val promise1 = Promise[(Stats, Stats)]()
      val promise2 = Promise[Stats]()
      val promise3 = Promise[Boolean]()

      val file1 = s"${testResources}fileA1.txt"
      val file2 = s"${testResources}fileA2.txt"
      val file3 = s"${testResources}fileC2.txt"

      val readable = Fs.createReadStream(file1, new FileInputOptions(encoding = "utf8"))
      val writable = Fs.createWriteStream(file2)
      readable.onData[String](chunk => {
        writable.end(chunk)
      })
      Fs.writeFileSync(file1, "Hello World")

      writable.onFinish { () =>
        promise1.success((Fs.statSync(file1), Fs.statSync(file2)))

        Fs.renameSync(file2, file3)
        promise2.success(Fs.statSync(file3))

        Fs.unlinkSync(file3)
        promise3.success(!Fs.existsSync(file3))
      }

      for {
        (stat1, stat2) <- promise1.future
        stat3          <- promise2.future
        deleted        <- promise3.future
      } yield {
        assert(stat1.size === stat2.size)
        assert(stat3.isFile())
        assert(deleted)
      }
    }

    it("should pipe data from a Readable to a Writable") {
      val file1 = s"${testResources}fileB1.txt"
      val file2 = s"${testResources}fileB2.txt"

      val readable = Fs.createReadStream(file1)
      val writable = Fs.createWriteStream(file2)
      readable.pipe(writable)

      val promise = Promise[(Stats, Stats)]()
      writable.onFinish { () =>
        promise.success((Fs.statSync(file1), Fs.statSync(file2)))
      }

      promise.future.map {
        case (stat1, stat2) =>
          assert(stat1.size === stat2.size)
      }
    }

    it("support access") {
      val promise = Promise[Unit]()
      Fs.access("./package.json", err => {
        if (isDefined(err)) {
          promise.failure(err.toException())
        } else {
          promise.success(())
        }
      })
      promise.future.map { _ =>
        succeed
      }
    }
  }
}
