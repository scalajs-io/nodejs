package com.github.ldaniels528.meansjs.kafkanode

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * High-Level Producer Factory
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait HighLevelProducerFactory extends js.Object

/**
  * High-Level Producer Factory
  * @author lawrence.daniels@gmail.com
  */
object HighLevelProducerFactory {

  /**
    * High-Level Producer Factory Enrichment
    * @param factory the given [[HighLevelProducerFactory producer factory]]
    */
  implicit class HighLevelProducerFactoryEnrichment(val factory: HighLevelProducerFactory) extends AnyVal {

    /**
      * @example HighLevelProducer(client)
      */
    def apply(client: Client) = factory.New[HighLevelProducer](client)

    /**
      * @example HighLevelProducer(client, [options])
      */
    def apply(client: Client, options: ProducerOptions) = factory.New[HighLevelProducer](client, options)

  }

}
