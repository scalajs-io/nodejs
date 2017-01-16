package io.scalajs.npm.cassandradriver
package policies

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * DC-Aware Round-Robin Policy
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("cassandra-driver", "policies.DCAwareRoundRobinPolicy")
class DCAwareRoundRobinPolicy(name: String) extends Policy