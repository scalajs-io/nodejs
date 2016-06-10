package com.github.ldaniels528.meansjs.nodejs.datastax

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Cassandra Batch Update query/statement
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class BatchUpdate(var query: String, params: CassandraParams = null) extends js.Object