package com.github.ldaniels528.meansjs.kafkanode

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * High-Level Consumer Factory
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait HighLevelConsumerFactory extends js.Object

/**
  * High-Level Consumer Factory Companion
  * @author lawrence.daniels@gmail.com
  */
object HighLevelConsumerFactory {

  /**
    * Consumer Factory Enrichment
    * @param factory the given [[HighLevelConsumerFactory consumer factory]]
    */
  implicit class ConsumerFactoryEnrichment(val factory: HighLevelConsumerFactory) extends AnyVal {

    /**
      * @example HighLevelConsumer(client, payloads, options)
      */
    def apply(client: Client, payloads: js.Array[Payload], options: ConsumerOptions) = {
      factory.New[HighLevelConsumer](client, payloads, options)
    }

  }

}