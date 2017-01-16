package io.scalajs.npm.kafkarest

import io.scalajs.nodejs.Error
import io.scalajs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Kafka Brokers Object
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait BrokerCollection extends js.Object {

  def get(name: String): Broker = js.native

  def list(callback: js.Function2[Error, js.Array[Broker], Any]): Unit = js.native

}

/**
  * Kafka Brokers Companion
  * @author lawrence.daniels@gmail.com
  */
object BrokerCollection {

  /**
    * Kafka Brokers Enrichment
    * @param brokers the given [[BrokerCollection brokers object]]
    */
  implicit class KafkaBrokersEnrichment(val brokers: BrokerCollection) extends AnyVal {

    @inline
    def listFuture = futureCallbackE1[Error, js.Array[Broker]](brokers.list)

  }

}
