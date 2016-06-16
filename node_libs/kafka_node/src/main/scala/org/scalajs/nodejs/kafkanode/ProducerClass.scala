package org.scalajs.nodejs.kafkanode

import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.nodejs.util.ScalaJsHelper

import scala.scalajs.js

/**
  * Producer Class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ProducerClass extends js.Object

/**
  * Producer Class
  * @author lawrence.daniels@gmail.com
  */
object ProducerClass {

  /**
    * Producer Class Extensions
    * @param `class` the given [[ProducerClass producer class]]
    */
  implicit class ProducerClassExtensions(val `class`: ProducerClass) extends AnyVal {

    /**
      * @example Producer(client, [options])
      */
    def apply(client: Client) = `class`.New[Producer](client)

    /**
      * @example Producer(client, [options])
      */
    def apply(client: Client, options: ProducerOptions) = `class`.New[Producer](client, options)

  }

}