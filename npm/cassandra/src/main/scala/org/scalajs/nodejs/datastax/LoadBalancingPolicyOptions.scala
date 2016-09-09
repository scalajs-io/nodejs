package org.scalajs.nodejs.datastax

import org.scalajs.nodejs.datastax.CassandraDriver.Policy

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Load Balancing Policy Options
  * @param loadBalancing the load balancing option
  */
@ScalaJSDefined
class LoadBalancingPolicyOptions(var loadBalancing: Policy) extends js.Object