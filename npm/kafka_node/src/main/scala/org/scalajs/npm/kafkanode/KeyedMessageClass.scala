package org.scalajs.npm.kafkanode

import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.nodejs.util.ScalaJsHelper

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