package com.github.ldaniels528.meansjs.kafkanode

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Keyed Message Factory
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait KeyedMessageFactory extends js.Object

/**
  * Keyed Message Factory Companion
  * @author lawrence.daniels@gmail.com
  */
object KeyedMessageFactory {

  /**
    * Keyed Message Factory Enrichment
    * @param factory the given [[KeyedMessageFactory keyed message factory]]
    */
  implicit class KeyedMessageFactoryEnrichment(val factory: KeyedMessageFactory) extends AnyVal {

    /**
      * @example new KeyedMessage('key', 'message')
      */
    def apply(key: String, message: String) = factory.New[KeyedMessage](key, message)

  }

}