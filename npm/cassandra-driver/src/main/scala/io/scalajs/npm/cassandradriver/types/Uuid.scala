package io.scalajs.npm.cassandradriver.types

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Cassandra UUID
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("cassandra-driver", "types.Uuid")
class Uuid extends js.Object

/**
  * Cassandra UUID Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("cassandra-driver", "types.Uuid")
object Uuid extends js.Object {

  def fromString(value: String): Uuid = js.native

  def random(): Uuid = js.native

}
