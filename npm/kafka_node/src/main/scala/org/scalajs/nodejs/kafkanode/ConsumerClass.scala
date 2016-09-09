package org.scalajs.nodejs.kafkanode

import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.nodejs.util.ScalaJsHelper

import scala.scalajs.js

/**
  * Consumer Class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ConsumerClass extends js.Object

/**
  * Consumer Class Companion
  * @author lawrence.daniels@gmail.com
  */
object ConsumerClass {

  /**
    * Consumer Class Extensions
    * @param `class` the given [[ConsumerClass consumer class]]
    */
  implicit class ConsumerClassExtensions(val `class`: ConsumerClass) extends AnyVal {

    /**
      * @example Consumer(client, payloads, options)
      */
    def apply(client: Client, payloads: js.Any, options: ConsumerOptions) = {
      `class`.New[Client](client, payloads, options)
    }

  }

}