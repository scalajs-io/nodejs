package io.scalajs.npm.cassandradriver

import scala.scalajs.js


/**
  * Cassandra Pooling Options
  * @param coreConnectionsPerHost the array of contact points
  */

class PoolingOptions(val coreConnectionsPerHost: js.UndefOr[js.Dictionary[Int]] = js.undefined) extends js.Object