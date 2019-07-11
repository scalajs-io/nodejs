package io.scalajs.npm.cassandradriver.policies

import io.scalajs.FlexibleOptions

import scala.scalajs.js

/**
  * Load Balancing Policy Options
  * @param loadBalancing the load balancing option
  */
class LoadBalancingPolicyOptions(var loadBalancing: js.UndefOr[Policy] = js.undefined) extends js.Object

/**
  * Load Balancing Policy Options Companion
  * @author lawrence.daniels@gmail.com
  */
object LoadBalancingPolicyOptions extends FlexibleOptions[LoadBalancingPolicyOptions]