package org.scalajs.nodejs.kafkanode

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Consumer Options
  * @param groupId              consumer group id, deafult `kafka-node-group`
  * @param autoCommit           Auto commit config
  * @param autoCommitIntervalMs The max wait time is the maximum amount of time in milliseconds to block waiting if
  *                             insufficient data is available at the time the request is issued, default 100ms
  * @param fetchMaxWaitMs       This is the minimum number of bytes of messages that must be available to give a response, default 1 byte.
  * @param fetchMinBytes        The maximum bytes to include in the message set for this partition. This helps bound the size of the response.
  * @param fetchMaxBytes        If set true, consumer will fetch message from the given offset in the payloads.
  * @param fromOffset           The starting offset
  * @param encoding             If set to 'buffer', values will be returned as raw buffer objects.
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class ConsumerOptions(var groupId: js.UndefOr[String] = js.undefined,
                      var autoCommit: js.UndefOr[Boolean] = js.undefined,
                      var autoCommitIntervalMs: js.UndefOr[Int] = js.undefined,
                      var fetchMaxWaitMs: js.UndefOr[Int] = js.undefined,
                      var fetchMinBytes: js.UndefOr[Int] = js.undefined,
                      var fetchMaxBytes: js.UndefOr[Int] = js.undefined,
                      var fromOffset: js.UndefOr[Boolean] = js.undefined,
                      var encoding: js.UndefOr[String] = js.undefined) extends js.Object