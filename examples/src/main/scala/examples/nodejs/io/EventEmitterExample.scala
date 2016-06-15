package examples.nodejs.io

import com.github.ldaniels528.meansjs.nodejs.{errors, _}
import com.github.ldaniels528.meansjs.nodejs.events.Events

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
    ee.emit("error", errors.Error("This will crash"))
  })

}
