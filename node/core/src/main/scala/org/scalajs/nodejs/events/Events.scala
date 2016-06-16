package org.scalajs.nodejs.events

import org.scalajs.nodejs.NodeModule
import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.nodejs.{NodeModule, NodeRequire}

import scala.scalajs.js

/**
  * Much of the Node.js core API is built around an idiomatic asynchronous event-driven architecture
  * in which certain kinds of objects (called "emitters") periodically emit named events that cause
  * Function objects ("listeners") to be called.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Events extends NodeModule with EventEmitter {

  def init(): js.Any = js.native

  def listenerCount(): Int = js.native

}

/**
  * Event Emitter Companion
  * @author lawrence.daniels@gmail.com
  */
object Events {

  /**
    * Convenience method for retrieving the 'events' module
    * @param require the implicit [[NodeRequire require function]]
    * @return the Events instance
    */
  def apply()(implicit require: NodeRequire) = require[Events]("events")

  /**
    * Event Emitter Factory Extensions
    * @param `class` the given [[EventEmitterClass event emitter class]]
    */
  implicit class EventEmitterExtensions(val `class`: Events) extends AnyVal {

    @inline
    def apply() = `class`.New[EventEmitter]()

  }

}


