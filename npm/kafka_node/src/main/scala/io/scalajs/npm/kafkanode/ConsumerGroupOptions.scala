package io.scalajs.npm.kafkanode

import io.scalajs.RawOptions

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined
import scala.scalajs.js.|

/**
  * Consumer Group Options
  * @param batch            put client batch settings if you need them (see Client)
  * @param fromOffset       Offsets to use for new groups other options could be 'earliest' or 'none'
  *                         (none will emit an error if no offsets were saved) equivalent to Java client's auto.offset.reset
  * @param host             the Zookeeper host(s) (e.g. 'zookeeper:2181')
  * @param groupId          e.g. 'ExampleTestGroup'
  * @param outOfRangeOffset how to recover from OutOfRangeOffset error (where save offset is past server retention)
  *                         accepts same value as fromOffset
  * @param migrateHLC       for details please see Migration section below
  * @param migrateRolling   true or false
  * @param protocol         An array of partition assignment protocols ordered by preference.
  *                         'roundrobin' or 'range' string for built ins (see below to pass in custom assignment protocol)
  * @param sessionTimeout   e.g. 15000
  * @param ssl              optional (defaults to false) or tls options hash
  * @param zk               put client zk settings if you need them (see Client)
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class ConsumerGroupOptions(var batch: js.UndefOr[String] = js.undefined,
                           var fromOffset: js.UndefOr[String] = js.undefined,
                           var host: js.UndefOr[String] = js.undefined,
                           var groupId: js.UndefOr[String] = js.undefined,
                           var outOfRangeOffset: js.UndefOr[String | js.Array[String]] = js.undefined,
                           var migrateHLC: js.UndefOr[Boolean] = js.undefined,
                           var migrateRolling: js.UndefOr[Boolean] = js.undefined,
                           var protocol: js.UndefOr[js.Array[String]] = js.undefined,
                           var sessionTimeout: js.UndefOr[Int] = js.undefined,
                           var ssl: js.UndefOr[Boolean] = js.undefined,
                           var zk: js.UndefOr[RawOptions] = js.undefined) extends js.Object