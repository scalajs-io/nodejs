package com.github.ldaniels528.meansjs.kafkanode

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Producer Factory
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ProducerFactory extends js.Object

/**
  * Producer Factory
  * @author lawrence.daniels@gmail.com
  */
object ProducerFactory {

  /**
    * Producer Factory Enrichment
    * @param factory the given [[ProducerFactory producer factory]]
    */
  implicit class ProducerFactoryEnrichment(val factory: ProducerFactory) extends AnyVal {

    /**
      * @example Producer(client, [options])
      */
    def apply(client: Client) = factory.New[Producer](client)

    /**
      * @example Producer(client, [options])
      */
    def apply(client: Client, options: ProducerOptions) = factory.New[Producer](client, options)

  }

}