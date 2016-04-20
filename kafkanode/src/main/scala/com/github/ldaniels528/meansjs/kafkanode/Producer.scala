package com.github.ldaniels528.meansjs.kafkanode

import com.github.ldaniels528.meansjs.kafkanode.KafkaNode.KafkaError
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.concurrent.{ExecutionContext, Promise}
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
    * Producer Enrichment
    * @param producer the given [[Producer producer]]
    */
  implicit class ProducerEnrichment(val producer: Producer) extends AnyVal {

    /**
      * @see [[Producer.on()]]
      */
    def onError(callback: js.Function) = producer.on("error", callback)

    /**
      * @see [[Producer.on()]]
      */
    def onReady(callback: js.Function) = producer.on("ready", callback)

    /**
      * @see [[Producer.createTopics()]]
      */
    def createTopicsAsync(topics: js.Array[String], async: Boolean, callback: js.Function)(implicit ec: ExecutionContext) = {
      val promise = Promise[js.Any]()
      producer.createTopics(topics, async, (err: KafkaError, result: js.Any) => {
        if (!isDefined(err)) promise.success(result) else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

    /**
      * @see [[Producer.send()]]
      */
    def sendAsync(payloads: js.Array[Payload])(implicit ec: ExecutionContext) = {
      val promise = Promise[js.Any]()
      producer.send(payloads, (err: KafkaError, result: js.Any) => {
        if (!isDefined(err)) promise.success(result) else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }
  }

}