package org.scalajs.nodejs.kafkanode

import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.nodejs.util.ScalaJsHelper

import scala.scalajs.js

/**
  * High-Level Consumer Class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait HighLevelConsumerClass extends js.Object

/**
  * High-Level Consumer Class Companion
  * @author lawrence.daniels@gmail.com
  */
object HighLevelConsumerClass {

  /**
    * Consumer Class Extensions
    * @param `class` the given [[HighLevelConsumerClass consumer class]]
    */
  implicit class ConsumerClassExtensions(val `class`: HighLevelConsumerClass) extends AnyVal {

    /**
      * @example HighLevelConsumer(client, payloads, options)
      */
    def apply(client: Client, payloads: js.Array[Payload], options: ConsumerOptions) = {
      `class`.New[HighLevelConsumer](client, payloads, options)
    }

  }

}