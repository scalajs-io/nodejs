package org.scalajs.npm.kafkarest

import org.scalajs.nodejs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Kafka Rest Class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait KafkaRestClass extends js.Object

/**
  * Kafka Rest Class Companion
  * @author lawrence.daniels@gmail.com
  */
object KafkaRestClass {

  /**
    * Kafka Rest Enrichment
    * @param `class` the given [[KafkaRest KafkaRest class]]
    */
  implicit class KafkaRestClassEnrichment(val `class`: KafkaRestClass) extends AnyVal {

    @inline
    def apply(options: KafkaRestOptions) = `class`.New[KafkaRestInstance](options)

  }

}