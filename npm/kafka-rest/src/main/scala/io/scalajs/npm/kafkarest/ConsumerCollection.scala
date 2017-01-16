package io.scalajs.npm.kafkarest

import io.scalajs.nodejs.Error
import io.scalajs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Kafka Consumers Object
  * @author lawrence.daniels@gmail.com
  */
@js.native
class ConsumerCollection extends js.Object {

  def get(name: String): Consumer = js.native

  def list(callback: js.Function2[Error, js.Array[Consumer], Any]): Unit = js.native

}

/**
  * Kafka Consumers Companion
  * @author lawrence.daniels@gmail.com
  */
object ConsumerCollection {

  /**
    * Kafka Consumers Enrichment
    * @param consumers the given [[ConsumerCollection consumers object]]
    */
  implicit class KafkaConsumersEnrichment(val consumers: ConsumerCollection) extends AnyVal {

    @inline
    def listFuture = futureCallbackE1[Error, js.Array[Consumer]](consumers.list)

  }

}
