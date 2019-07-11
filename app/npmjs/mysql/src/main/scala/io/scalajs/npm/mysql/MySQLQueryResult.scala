package io.scalajs.npm.mysql

import scala.scalajs.js

/**
  * MySQL Query Result
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait MySQLQueryResult extends js.Object {

  val insertId: String = js.native

  val affectedRows: Int = js.native

  val changedRows: Int = js.native

  val threadId: String = js.native

}
