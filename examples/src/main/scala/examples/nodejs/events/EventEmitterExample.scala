package examples.nodejs.events

import com.github.ldaniels528.meansjs.nodejs._
import com.github.ldaniels528.meansjs.nodejs.events.Events

import scala.scalajs.js

/**
  * Event Emitting Example
  * @author lawrence.daniels@gmail.com
  */
class EventEmitterExample(require: Require, scope: js.Dynamic) {
  val eventEmitter = require[Events]("events")
  val ee = eventEmitter()

  //console.log(scope)

  setImmediate(() => {
    // This will crash the process because no "error" event
    // handler has been added.
    ee.emit("error", Error("This will crash"))
  })

}
