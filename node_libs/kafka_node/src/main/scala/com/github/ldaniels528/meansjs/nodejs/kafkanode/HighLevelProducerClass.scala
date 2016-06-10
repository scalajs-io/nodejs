package com.github.ldaniels528.meansjs.nodejs.kafkanode

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * High-Level Producer Class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait HighLevelProducerClass extends js.Object

/**
  * High-Level Producer Class
  * @author lawrence.daniels@gmail.com
  */
object HighLevelProducerClass {

  /**
    * High-Level Producer Class Extensions
    * @param `class` the given [[HighLevelProducerClass producer class]]
    */
  implicit class HighLevelProducerClassExtensions(val `class`: HighLevelProducerClass) extends AnyVal {

    /**
      * @example HighLevelProducer(client)
      */
    def apply(client: Client) = `class`.New[HighLevelProducer](client)

    /**
      * @example HighLevelProducer(client, [options])
      */
    def apply(client: Client, options: ProducerOptions) = `class`.New[HighLevelProducer](client, options)

  }

}
