package com.github.ldaniels528.meansjs.nodejs.events

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Much of the Node.js core API is built around an idiomatic asynchronous event-driven architecture
  * in which certain kinds of objects (called "emitters") periodically emit named events that cause
  * Function objects ("listeners") to be called.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait EventEmitter extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  def EventEmitter: EventEmitterClass = js.native

  var usingDomains: Boolean = js.native

  /**
    * By default, a maximum of 10 listeners can be registered for any single event. This limit can be changed
    * for individual EventEmitter instances using the emitter.setMaxListeners(n) method. To change the default
    * for all EventEmitter instances, the EventEmitter.defaultMaxListeners property can be used.
    * @example EventEmitter.defaultMaxListeners
    */
  var defaultMaxListeners: Int = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  def init(): js.Any = js.native

  def listenerCount(): Int = js.native

}

/**
  * Event Emitter Companion
  * @author lawrence.daniels@gmail.com
  */
object EventEmitter {

  /**
    * Event Emitter Factory Extensions
    * @param `class` the given [[EventEmitterClass event emitter class]]
    */
  implicit class EventEmitterExtensions(val `class`: EventEmitter) extends AnyVal {

    def apply() = `class`.New[EventEmitterInstance]()

  }

}


