package examples.nodejs.events

import com.github.ldaniels528.meansjs.nodejs._
import com.github.ldaniels528.meansjs.nodejs.events.EventEmitter
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._
import org.scalajs.dom.console

import scala.scalajs.js

/**
  * Event Emitting
  * @author lawrence.daniels@gmail.com
  */
class EventEmitting(require: Require) {
  val eventEmitter = require[js.Function0[EventEmitter]]("events")
  val ee = eventEmitter.New[EventEmitter]()

  console.log(Error)

  setImmediate(() => {
    // This will crash the process because no "error" event
    // handler has been added.
    ee.emit("error", Error.New("This will crash"))
  })

}
