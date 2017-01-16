package io.scalajs.npm.cassandradriver

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Cassandra Pooling Options
  * @param coreConnectionsPerHost the array of contact points
  */
@ScalaJSDefined
class PoolingOptions(val coreConnectionsPerHost: js.UndefOr[js.Dictionary[Int]] = js.undefined) extends js.Object