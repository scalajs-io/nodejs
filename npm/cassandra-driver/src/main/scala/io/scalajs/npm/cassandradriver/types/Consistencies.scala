package io.scalajs.npm.cassandradriver.types

import io.scalajs.npm.cassandradriver.ConsistencyLevel

import scala.scalajs.js

/**
  * Consistencies object
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Consistencies extends js.Object {
  var any: ConsistencyLevel = js.native
  var one: ConsistencyLevel = js.native
  var two: ConsistencyLevel = js.native
  var three: ConsistencyLevel = js.native
  var quorum: ConsistencyLevel = js.native
  var all: ConsistencyLevel = js.native
  var localQuorum: ConsistencyLevel = js.native
  var eachQuorum: ConsistencyLevel = js.native
  var serial: ConsistencyLevel = js.native
  var localSerial: ConsistencyLevel = js.native
  var localOne: ConsistencyLevel = js.native
}