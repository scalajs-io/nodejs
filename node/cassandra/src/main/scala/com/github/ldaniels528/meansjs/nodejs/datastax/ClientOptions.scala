package com.github.ldaniels528.meansjs.nodejs.datastax

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Cassandra Client Options
  * @param contactPoints the array of contact points
  * @param keyspace      the keyspace
  */
@ScalaJSDefined
class ClientOptions(var contactPoints: js.Array[String] = null,
                    var keyspace: String = null,
                    var pooling: PoolingOptions = null,
                    var policies: LoadBalancingPolicyOptions = null) extends js.Object