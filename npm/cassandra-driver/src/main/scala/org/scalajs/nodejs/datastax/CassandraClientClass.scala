package org.scalajs.nodejs.datastax

import scala.scalajs.js

/**
  * Represents the Cassandra Client class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait CassandraClientClass extends js.Object {

  def apply(): CassandraClient = js.native

  def apply(options: ClientOptions): CassandraClient = js.native

}
