package org.scalajs.nodejs.kafkanode

import scala.scalajs.js

/**
  * Kafka-Node Event Listener
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait KafkaNodeEventListener extends js.Object {

  /**
    * By default, we will consume messages from the last committed offset of the current group
    * @param message   the given event message (e.g. "error")
    * @param onMessage callback when new message comes
    * @example consumer.on('message', function (message) { .. })
    */
  def on(message: String, onMessage: js.Function): Unit = js.native

}
