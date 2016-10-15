package org.scalajs.npm.kafkarest

import scala.scalajs.js

/**
  * Kafka Topic
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Topic extends js.Object {

  def partition(index: Int): Partition = js.native

  def partitions: PartitionCollection = js.native

  def produce(payloads: js.Any*): Unit = js.native

  def raw: js.Object = js.native

}
