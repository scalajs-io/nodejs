package io.scalajs.nodejs.events

import io.scalajs.JSON
import org.scalatest.FunSpec

import scala.scalajs.js

/**
  * EventEmitter Tests
  * @author lawrence.daniels@gmail.com
  */
class EventEmitterTest extends FunSpec {

  describe("EventEmitter") {

    it("should handle events with arguments") {
      val myEmitter = new EventEmitter()
      myEmitter.on("event", (args: js.Array[Int]) => {
        info(s"a custom event was fired with args: ${JSON.stringify(args)}")
      })
      myEmitter.emit("event", js.Array(1, 2, 3))
    }

    it("should handle one-time events") {
      val myEmitter = new EventEmitter()
      var n = 0
      myEmitter.once("event", () => {
        n += 1
        info(s"n = $n")
      })
      myEmitter.emit("event")
      // Prints: 1
      myEmitter.emit("event")
      // Ignored
    }

    it("should handle repeated events") {
      val myEmitter = new EventEmitter()
      var n = 0
      myEmitter.on("event", () => {
        n += 1
        info(s"n = $n")
      })
      myEmitter.emit("event")
      // Prints: 1
      myEmitter.emit("event")
      // Prints: 2
    }

    it("should count the number of fired events") {
      val myEmitter = new EventEmitter()
      myEmitter.on("event", () => {})
      myEmitter.on("event", () => {})
      assert(myEmitter.listenerCount("event") == 2)
    }

  }

}
