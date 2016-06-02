package com.github.ldaniels528.meansjs.nodejs.datastax

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Cassandra Pooling Options
  * @param coreConnectionsPerHost the array of contact points
  */
@ScalaJSDefined
class PoolingOptions(var coreConnectionsPerHost: js.Dictionary[Int]) extends js.Object