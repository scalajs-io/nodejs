package org.scalajs.nodejs

import scala.scalajs.js

/**
  * DataStax Cassandra Package object
  * @author lawrence.daniels@gmail.com
  */
package object datastax {

  type CassandraParams = js.Array[_ <: js.Any]

  type ConsistencyLevel = Int

  type PageState = js.Any

}
