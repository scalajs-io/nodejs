package examples.nodejs.io

import org.scalajs.nodejs.{errors, _}
import org.scalajs.nodejs.Bootstrap
import org.scalajs.nodejs.errors.Error
import org.scalajs.nodejs.events.Events

/**
  * Event Emitting Example
  * @author lawrence.daniels@gmail.com
  */
class EventEmitterExample(bootstrap: Bootstrap) {
  implicit val require = bootstrap.require

  val ee = require[Events]("events")()

  setImmediate(() => {
    // This will crash the process because no "error" event
    // handler has been added.
    ee.emit("error", Error("This will crash"))
  })

}
