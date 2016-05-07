package com.github.ldaniels528.meansjs.nodejs.kafkanode

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Keyed Message Class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait KeyedMessageClass extends js.Object

/**
  * Keyed Message Class Companion
  * @author lawrence.daniels@gmail.com
  */
object KeyedMessageClass {

  /**
    * Keyed Message Class Extensions
    * @param `class` the given [[KeyedMessageClass keyed message class]]
    */
  implicit class KeyedMessageClassExtensions(val `class`: KeyedMessageClass) extends AnyVal {

    /**
      * @example new KeyedMessage('key', 'message')
      */
    def apply(key: String, message: String) = `class`.New[KeyedMessage](key, message)

  }

}