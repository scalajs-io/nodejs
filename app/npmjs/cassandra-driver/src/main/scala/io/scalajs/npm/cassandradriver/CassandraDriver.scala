package io.scalajs.npm.cassandradriver

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * DataStax Node.js Driver for Apache Cassandra
  * @version 3.2.0
  * @see https://github.com/datastax/nodejs-driver
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait CassandraDriver extends js.Object {

  val consistencies: js.Dictionary[Int] = js.native
  val policies: js.Dictionary[_]        = js.native
  val types: Types                      = js.native

}

/**
  * Cassandra-Driver Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("cassandra-driver", JSImport.Namespace)
object CassandraDriver extends CassandraDriver
