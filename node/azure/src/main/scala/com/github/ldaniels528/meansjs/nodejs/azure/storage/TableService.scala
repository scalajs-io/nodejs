package com.github.ldaniels528.meansjs.nodejs.azure.storage

import com.github.ldaniels528.meansjs.nodejs.errors.ErrorClass
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Table Service
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait TableService extends js.Object {

  /**
    * Ensure a table exists
    * @param tableName the name of the table
    * @param callback  the operation result call back
    */
  def createTableIfNotExists(tableName: String, callback: js.Function): Unit = js.native

  /**
    * Inserts a new entity into the specified table
    * @param tableName the name of the table
    * @param entity    the entity to insert
    * @param callback  the operation result call back
    */
  def insertEntity(tableName: String, entity: js.Any, callback: js.Function): Unit = js.native

  /**
    * Fetches saved entities
    * @param tableName the name of the table
    * @param args0     search argument 1
    * @param args1     search argument 2
    * @param callback  the query result call back
    */
  def queryEntity(tableName: String, args0: String, args1: String, callback: js.Function): Unit = js.native

}

/**
  * Table Service Companion
  * @author lawrence.daniels@gmail.com
  */
object TableService {

  /**
    * Table Service Extensions
    * @param tableService the given [[TableService table service]]
    */
  implicit class TableServiceServiceExtensions(val tableService: TableService) extends AnyVal {

    @inline
    def createTableIfNotExistsFuture(tableName: String) = {
      futureCallbackE1[ErrorClass, js.Any](tableService.createTableIfNotExists(tableName, _))
    }

    @inline
    def insertEntityFuture(tableName: String, entity: js.Any) = {
      futureCallbackE1[ErrorClass, js.Any](tableService.insertEntity(tableName, entity, _))
    }

    @inline
    def queryEntityFuture(tableName: String, args0: String, args1: String) = {
      futureCallbackE1[ErrorClass, js.Any](tableService.queryEntity(tableName, args0, args1, _))
    }

  }

}