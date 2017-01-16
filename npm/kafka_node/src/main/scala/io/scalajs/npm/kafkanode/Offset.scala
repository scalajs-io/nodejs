package io.scalajs.npm.kafkanode

import io.scalajs.nodejs.Error
import io.scalajs.nodejs.events.IEventEmitter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Offset
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("kafka-node", "Offset")
class Offset(client: Client) extends IEventEmitter {

  /**
    * @example commit(groupId, payloads, callback)
    */
  def commit(groupId: String, payloads: js.Array[Payload], callback: js.Function): Unit = js.native

  /**
    * @example fetch(payloads, callback)
    */
  def fetch(payloads: js.Array[Payload], callback: js.Function2[Error, js.Any, Any]): Unit = js.native

  /**
    * @example fetchCommits(groupid, payloads, callback)
    */
  def fetchCommits(groupId: String, payloads: js.Array[Payload], callback: js.Function): Unit = js.native

}
