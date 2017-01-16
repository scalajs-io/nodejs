package io.scalajs.npm.kafkarest

import io.scalajs.nodejs.Error
import io.scalajs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Kafka Topics
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait TopicCollection extends js.Object {

  def get(name: String, callback: js.Function2[Error, Topic, Any]): Topic = js.native

  def list(callback: js.Function2[Error, js.Array[Topic], Any]): Unit = js.native

  def topic(name: String): Topic = js.native

}

/**
  * Kafka Topics Companion
  * @author lawrence.daniels@gmail.com
  */
object TopicCollection {

  /**
    * Kafka Topics Enrichment
    * @param topics the given [[TopicCollection topics object]]
    */
  implicit class KafkaTopicsEnrichment(val topics: TopicCollection) extends AnyVal {

    @inline
    def getFuture(name: String) = futureCallbackE1[Error, Topic](topics.get(name, _))

    @inline
    def listFuture = futureCallbackE1[Error, js.Array[Topic]](topics.list)

  }

}