package com.github.ldaniels528.meansjs.nodejs.events

import scala.scalajs.js

/**
  * Much of the Node.js core API is built around an idiomatic asynchronous event-driven architecture
  * in which certain kinds of objects (called "emitters") periodically emit named events that cause
  * Function objects ("listeners") to be called.
  * @author lawrence.daniels@gmail.com
  * @see [[https://nodejs.org/api/events.html]]
  */
@js.native
trait Events extends js.Object {

  def EventEmitter: EventEmitter

}
