package com.github.ldaniels528.meansjs.kafkanode

import com.github.ldaniels528.meansjs.kafkanode.KafkaNode.KafkaError
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.concurrent.{ExecutionContext, Promise}
import scala.scalajs.js

/**
  * Kafka-Node Client Instance
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Client extends js.Object {

  /**
    * Closes the consumer
    * @param callback the callback
    */
  def close(callback: js.Function): Unit = js.native

}

/**
  * Client Instance Companion
  * @author lawrence.daniels@gmail.com
  */
object Client {

  /**
    * Client Extensions
    * @param client the given [[Client client]]
    */
  implicit class ClientExtensions(val client: Client) extends AnyVal {

    /**
      * @see [[Client.close()]]
      */
    def closeAsync()(implicit ec: ExecutionContext) = {
      val promise = Promise[js.Any]()
      client.close((err: KafkaError, result: js.Any) => {
        if (!isDefined(err)) promise.success(result) else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

  }

}