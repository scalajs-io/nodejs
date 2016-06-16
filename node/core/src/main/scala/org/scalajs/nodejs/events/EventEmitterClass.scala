package org.scalajs.nodejs.events

import org.scalajs.nodejs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Event Emitter Class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait EventEmitterClass extends js.Object

/**
  * Event Emitter Factory
  * @author lawrence.daniels@gmail.com
  */
object EventEmitterClass {

  /**
    * Event Emitter Factory Extensions
    * @param `class` the given [[EventEmitterClass event emitter class]]
    */
  implicit class EventEmitterFactoryExtensions(val `class`: EventEmitterClass) extends AnyVal {

    /**
      * @example new EventEmitter()
      */
    @inline
    def apply() = `class`.New[EventEmitter]()

  }

}