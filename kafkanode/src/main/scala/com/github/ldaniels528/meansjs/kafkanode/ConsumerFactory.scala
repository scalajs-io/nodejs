package com.github.ldaniels528.meansjs.kafkanode

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Consumer Factory
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ConsumerFactory extends js.Object

/**
  * Consumer Factory Companion
  * @author lawrence.daniels@gmail.com
  */
object ConsumerFactory {

  /**
    * Consumer Factory Enrichment
    * @param factory the given [[ConsumerFactory consumer factory]]
    */
  implicit class ConsumerFactoryEnrichment(val factory: ConsumerFactory) extends AnyVal {

    /**
      * @example Consumer(client, payloads, options)
      */
    def apply(client: Client, payloads: js.Any, options: ConsumerOptions) = {
      factory.New[Client](client, payloads, options)
    }

  }

}