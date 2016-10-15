package org.scalajs.npm.kafkarest

import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.nodejs.errors

import scala.scalajs.js

/**
  * Kafka Topics
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait TopicCollection extends js.Object {

  def get(name: String, callback: js.Function2[errors.Error, Topic, Any]): Topic = js.native

  def list(callback: js.Function2[errors.Error, js.Array[Topic], Any]): Unit = js.native

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
    def getFuture(name: String) = futureCallbackE1[errors.Error, Topic](topics.get(name, _))

    @inline
    def listFuture = futureCallbackE1[errors.Error, js.Array[Topic]](topics.list)

  }

}