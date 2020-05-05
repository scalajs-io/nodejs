package io.scalajs.nodejs.events

import scala.concurrent.{ExecutionContext, Promise}
import scala.scalajs.js
import org.scalatest.funspec.AsyncFunSpec

class EventEmitterTest extends AsyncFunSpec {
  override implicit val executionContext = ExecutionContext.Implicits.global

  describe("EventEmitter") {
    it("should handle custom events with arguments") {
      val promise   = Promise[js.Array[Int]]()
      val myEmitter = new EventEmitter()
      myEmitter.on(
        "custom-event",
        (args: js.Array[Int]) => {
          promise.success(args)
        }
      )
      myEmitter.emit("custom-event", js.Array(1, 2, 3))

      promise.future.map { array =>
        assert(array.mkString(",") === "1,2,3")
      }
    }

    it("should handle one-time events") {
      val promise   = Promise[Unit]()
      val myEmitter = new EventEmitter()
      var n         = 0
      myEmitter.once(
        "event",
        () => {
          n += 1
          promise.success(())
        }
      )
      myEmitter.emit("event")
      myEmitter.emit("event")

      promise.future.map { _ =>
        assert(n === 1)
      }
    }

    it("should handle repeated events") {
      val promise   = Promise[Unit]()
      val myEmitter = new EventEmitter()
      var n         = 0
      myEmitter
        .on(
          "event",
          () => {
            n += 1
          }
        )
        .on(
          "end",
          () => {
            promise.success(())
          }
        )
      myEmitter.emit("event")
      myEmitter.emit("event")
      myEmitter.emit("end")

      promise.future.map { _ =>
        assert(n === 2)
      }
    }

    it("should count the number of fired events") {
      val myEmitter = new EventEmitter()
      myEmitter.on("event", () => {})
      myEmitter.on("event", () => {})
      assert(myEmitter.listenerCount("event") === 2)
    }
  }
}
