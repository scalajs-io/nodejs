package io.scalajs.npm.cassandradriver.types

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Cassandra Distance
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("cassandra-driver", "types.distance")
class Distance extends js.Object

/**
  * Cassandra Distance Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("cassandra-driver", "types.distance")
object Distance extends js.Object {
  val local: Int   = js.native
  val remote: Int  = js.native
  val ignored: Int = js.native

}
