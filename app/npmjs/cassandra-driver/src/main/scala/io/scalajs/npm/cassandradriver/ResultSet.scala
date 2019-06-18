package io.scalajs.npm.cassandradriver

import scala.scalajs.js
import scala.scalajs.js.Array

/**
  * Cassandra Result Set
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ResultSet extends js.Object {

  def first(): js.Any = js.native

  def nextPage: js.Function0[Unit] = js.native

  def pageState: PageState = js.native

  def rows: js.Array[js.Any] = js.native

}

/**
  * Cassandra Result Set Companion
  * @author lawrence.daniels@gmail.com
  */
object ResultSet {

  /**
    * Cassandra Result Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class CassandraResultSetExtensions(val result: ResultSet) extends AnyVal {

    def headOption[T]: Option[T] = Option(result.first()).map(_.asInstanceOf[T])

    def rowsAs[T]: Array[T] = result.rows.asInstanceOf[js.Array[T]]

  }

}