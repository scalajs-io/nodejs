package examples.nodejs.events

import com.github.ldaniels528.meansjs.nodejs._
import com.github.ldaniels528.meansjs.nodejs.events.EventEmitter

/**
  * Event Emitting Example
  * @author lawrence.daniels@gmail.com
  */
class EventEmitting(require: Require) {
  val eventEmitter = require[EventEmitter]("events")
  val ee = eventEmitter()

  setImmediate(() => {
    // This will crash the process because no "error" event
    // handler has been added.
    ee.emit("error", Error("This will crash"))
  })

}
