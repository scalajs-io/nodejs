package com.github.ldaniels528.meansjs.nodejs.kafkanode

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

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