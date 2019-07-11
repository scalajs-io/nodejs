package io.scalajs.npm.cassandradriver

import io.scalajs.FlexibleOptions

import scala.scalajs.js

/**
  * Cassandra Pooling Options
  * @param coreConnectionsPerHost the array of contact points
  */
class PoolingOptions(var coreConnectionsPerHost: js.UndefOr[js.Dictionary[Int]] = js.undefined) extends js.Object

/**
  * Cassandra Pooling Options Companion
  * @author lawrence.daniels@gmail.com
  */
object PoolingOptions extends FlexibleOptions[PoolingOptions]