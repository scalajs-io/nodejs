package io.scalajs.npm.cassandradriver

import scala.scalajs.js


/**
  * Cassandra Batch Update query/statement
  * @author lawrence.daniels@gmail.com
  */

class BatchUpdate(var query: String, val params: CassandraParams = null) extends js.Object