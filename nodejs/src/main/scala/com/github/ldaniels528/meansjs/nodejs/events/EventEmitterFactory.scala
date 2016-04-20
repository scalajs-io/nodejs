package com.github.ldaniels528.meansjs.nodejs.events

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Event Emitter Factory
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait EventEmitterFactory extends js.Object

/**
  * Event Emitter Factory
  * @author lawrence.daniels@gmail.com
  */
object EventEmitterFactory {

  /**
    * Event Emitter Factory Enrichment
    * @param factory the given [[EventEmitterFactory event emitter factory]]
    */
  implicit class EventEmitterFactoryEnrichment(val factory: EventEmitterFactory) extends AnyVal {

    def apply() = factory.New[EventEmitterInstance]()

  }

}