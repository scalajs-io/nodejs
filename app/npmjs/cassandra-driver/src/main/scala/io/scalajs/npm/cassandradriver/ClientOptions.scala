package io.scalajs.npm.cassandradriver

import io.scalajs.FlexibleOptions
import io.scalajs.npm.cassandradriver.policies.LoadBalancingPolicyOptions

import scala.scalajs.js

/**
  * Cassandra Client Options
  * @param contactPoints the array of contact points
  * @param keyspace      the keyspace
  * @param pooling       the [[PoolingOptions pooling options]]
  * @param policies      the [[LoadBalancingPolicyOptions load balancing policy options]]
  */
class ClientOptions(var contactPoints: js.Array[String],
                    var keyspace: js.UndefOr[String] = js.undefined,
                    var pooling: js.UndefOr[PoolingOptions] = js.undefined,
                    var policies: js.UndefOr[LoadBalancingPolicyOptions] = js.undefined)
  extends js.Object

/**
  * Cassandra Client Options Companion
  * @author lawrence.daniels@gmail.com
  */
object ClientOptions extends FlexibleOptions[ClientOptions]
