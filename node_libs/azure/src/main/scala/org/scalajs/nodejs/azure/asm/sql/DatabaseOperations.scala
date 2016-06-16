package org.scalajs.nodejs.azure.asm.sql

import org.scalajs.nodejs.errors
import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.nodejs.util.ScalaJsHelper

import scala.scalajs.js

/**
  * Database Operations
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait DatabaseOperations extends js.Object {

  def create(databaseName: String, options: DatabaseOptions, callback: js.Function): Unit = js.native

}

/**
  * Database Operations Companion
  * @author lawrence.daniels@gmail.com
  */
object DatabaseOperations {

  /**
    * Database Operations Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class DatabasesExtensions(val dbOps: DatabaseOperations) extends AnyVal {

    @inline
    def createFuture(databaseName: String, options: DatabaseOptions) = {
      futureCallbackE1[errors.Error, Database](dbOps.create(databaseName, options, _))
    }

  }

}