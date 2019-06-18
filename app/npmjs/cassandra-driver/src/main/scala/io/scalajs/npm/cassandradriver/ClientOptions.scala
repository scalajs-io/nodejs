package io.scalajs.npm.cassandradriver

import io.scalajs.npm.cassandradriver.policies.LoadBalancingPolicyOptions

import scala.scalajs.js


/**
  * Cassandra Client Options
  * @param contactPoints the array of contact points
  * @param keyspace      the keyspace
  */

class ClientOptions(val contactPoints: js.Array[String],
                    val keyspace: js.UndefOr[String] = js.undefined,
                    val pooling: js.UndefOr[PoolingOptions] = js.undefined,
                    val policies: js.UndefOr[LoadBalancingPolicyOptions] = js.undefined)
    extends js.Object
