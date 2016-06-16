package org.scalajs.nodejs.azure.asm.sql

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Database Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class DatabaseOptions(name: String,
                      edition: String,
                      collationName: String,
                      maximumDatabaseSizeInGB: String) extends js.Object


/**
  * Database Options
  * @author lawrence.daniels@gmail.com
  */
object DatabaseOptions {

  def apply(name: String,
            edition: String,
            collationName: String,
            maximumDatabaseSizeInGB: String) = {
    new DatabaseOptions(name, edition, collationName, maximumDatabaseSizeInGB)
  }

}