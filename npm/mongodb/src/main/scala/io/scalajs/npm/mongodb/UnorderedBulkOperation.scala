package io.scalajs.npm.mongodb

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * Unordered Bulk Operation
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait UnorderedBulkOperation extends js.Object {

  /**
    * Execute the ordered bulk operation
    * @param options  Optional settings.
    * @param callback The command result callback
    * @example execute(options, callback)
    */
  def execute(options: js.Any, callback: js.Function): Unit = js.native

  /**
    * Initiate a find operation for an update/updateOne/remove/removeOne/replaceOne
    * @param selector The selector for the bulk operation.
    * @throws MongoError ()
    * @example find(selector)
    */
  def find(selector: js.Any): Unit = js.native

  /**
    * Add a single insert document to the bulk operation
    * @param doc the document to insert
    * @throws MongoError ()
    * @example insert(doc)
    */
  def insert(doc: js.Any): Unit = js.native

}

@js.native
@JSName("UnorderedBulkOperation")
object UnorderedBulkOperation extends UnorderedBulkOperationClass