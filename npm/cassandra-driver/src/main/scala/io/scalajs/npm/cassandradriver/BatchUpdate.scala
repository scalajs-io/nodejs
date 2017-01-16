package io.scalajs.npm.cassandradriver

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Cassandra Batch Update query/statement
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class BatchUpdate(var query: String, val params: CassandraParams = null) extends js.Object