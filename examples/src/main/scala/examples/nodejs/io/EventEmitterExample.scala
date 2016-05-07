package examples.nodejs.io

import com.github.ldaniels528.meansjs.nodejs._
import com.github.ldaniels528.meansjs.nodejs.events.Events

/**
  * Event Emitting Example
  * @author lawrence.daniels@gmail.com
  */
class EventEmitterExample(bootstrap: Bootstrap) {
  import bootstrap._

  val eventEmitter = require[Events]("events")
  val ee = eventEmitter()

  setImmediate(() => {
    // This will crash the process because no "error" event
    // handler has been added.
    ee.emit("error", Error("This will crash"))
  })

}
