package io.scalajs.npm.kafkanode

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Keyed Message
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("kafka-node", "KeyedMessage")
class KeyedMessage(key: String, message: String) extends js.Object {}
