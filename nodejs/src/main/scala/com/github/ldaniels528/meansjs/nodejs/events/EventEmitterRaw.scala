package com.github.ldaniels528.meansjs.nodejs.events

import scala.scalajs.js

/**
  * Much of the Node.js core API is built around an idiomatic asynchronous event-driven architecture
  * in which certain kinds of objects (called "emitters") periodically emit named events that cause
  * Function objects ("listeners") to be called.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait EventEmitterRaw extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  def EventEmitter: js.Function0[EventEmitter] = js.native

  var usingDomains: Boolean = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * By default, a maximum of 10 listeners can be registered for any single event. This limit can be changed
    * for individual EventEmitter instances using the emitter.setMaxListeners(n) method. To change the default
    * for all EventEmitter instances, the EventEmitter.defaultMaxListeners property can be used.
    * @example EventEmitter.defaultMaxListeners
    */
  var defaultMaxListeners: Int = js.native

  def init(): js.Any = js.native

  def listenerCount(): Int = js.native

}



