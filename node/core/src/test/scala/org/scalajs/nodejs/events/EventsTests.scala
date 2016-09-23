package org.scalajs.nodejs.events

import org.scalajs.nodejs.NodeRequire._
import org.scalajs.nodejs._
import org.scalajs.nodejs.errors.Error
import utest._

/**
  * Events Tests
  * @author lawrence.daniels@gmail.com
  */
object EventsTests extends TestSuite {

  override val tests = this {
    val events = Events()
    val emitter = events()

    "emitter.setImmediate()" - {
      setImmediate(() => {
        // This will crash the process because no "error" event
        // handler has been added.
        emitter.emit("error", Error("This will crash"))
      })
    }
  }

}
