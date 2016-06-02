package com.github.ldaniels528.meansjs.nodejs.kafkanode

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Kafka-Node Producer
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Producer extends KafkaNodeEventListener {

  /**
    * @example createTopics(topics, [async,] callback)
    */
  def createTopics(topics: js.Array[String], async: Boolean, callback: js.Function): Unit = js.native

  /**
    * @example createTopics(topics, [async,] callback)
    */
  def createTopics(topics: js.Array[String], callback: js.Function): Unit = js.native

  /**
    * @example send(payloads, callback)
    */
  def send(payloads: js.Array[Payload], callback: js.Function): Unit = js.native

}

/**
  * Producer Companion
  * @author lawrence.daniels@gmail.com
  */
object Producer {

  /**
    * Producer Extensions
    * @param producer the given [[Producer producer]]
    */
  implicit class ProducerExtensions(val producer: Producer) extends AnyVal {

    /**
      * @see [[Producer.on()]]
      */
    @inline def onError(callback: js.Function) = producer.on("error", callback)

    /**
      * @see [[Producer.on()]]
      */
    @inline def onReady(callback: js.Function) = producer.on("ready", callback)

    /**
      * @see [[Producer.createTopics()]]
      */
    @inline def createTopicsFuture(topics: js.Array[String], async: Boolean) = callbackWithErrorToFuture[js.Any](producer.createTopics(topics, async, _))

    /**
      * @see [[Producer.send()]]
      */
    @inline def sendFuture(payloads: js.Array[Payload]) = callbackWithErrorToFuture[js.Any](producer.send(payloads, _))

  }

}