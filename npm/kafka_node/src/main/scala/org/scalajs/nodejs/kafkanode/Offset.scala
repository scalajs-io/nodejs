package org.scalajs.nodejs.kafkanode

import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.nodejs.util.ScalaJsHelper

import scala.scalajs.js

/**
  * Offset
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Offset extends KafkaNodeEventListener {

  /**
    * @example commit(groupId, payloads, callback)
    */
  def commit(groupId: String, payloads: js.Array[Payload], callback: js.Function): Unit = js.native

  /**
    * @example fetch(payloads, callback)
    */
  def fetch(payloads: js.Array[Payload], callback: js.Function): Unit = js.native

  /**
    * @example fetchCommits(groupid, payloads, callback)
    */
  def fetchCommits(groupId: String, payloads: js.Array[Payload], callback: js.Function): Unit = js.native

}

/**
  * Offset Companion
  * @author lawrence.daniels@gmail.com
  */
object Offset {

  /**
    * Offset Extensions
    * @param offset the given [[Offset offset]]
    */
  implicit class OffsetExtensions(val offset: Offset) extends AnyVal {

    /**
      * @see [[Offset.commit()]]
      */
    def commitAsync(groupId: String, payloads: js.Array[Payload]) = futureCallbackE1[js.Error, js.Any](offset.commit(groupId, payloads, _))

    /**
      * @see [[Offset.fetch()]]
      */
    def fetchAsync(payloads: js.Array[Payload]) = futureCallbackE1[js.Error, js.Any](offset.fetch(payloads, _))

    /**
      * @see [[Offset.fetchCommits()]]
      */
    def fetchCommitsAsync(groupId: String, payloads: js.Array[Payload]) = futureCallbackE1[js.Error, js.Any](offset.fetchCommits(groupId, payloads, _))

  }

}