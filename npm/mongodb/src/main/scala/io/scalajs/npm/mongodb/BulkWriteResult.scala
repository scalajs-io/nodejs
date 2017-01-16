package io.scalajs.npm.mongodb

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * Bulk Write Result
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait BulkWriteResult extends js.Object {

  /**
    * Return an array of inserted ids
    * @return an array of inserted ids
    */
  def getInsertedIds[T <: js.Any](): js.Array[T] = js.native

  /**
    * Retrieve lastOp if available
    * @return the lastOp if available
    */
  def getLastOp[T <: js.Any](): T = js.native

  /**
    * Return raw internal result
    * @return raw internal result
    */
  def getRawResponse[T <: js.Any](): T = js.native

  /**
    * Return the upserted id at position x
    * @param index the number of the upserted id to return, returns undefined if no result for passed in index
    * @return the upserted id at position x
    */
  def getUpsertedIdAt[T <: js.Any](index: Int): T = js.native

  /**
    * Return an array of upserted ids
    * @return an array of upserted ids
    */
  def getUpsertedIds[T <: js.Any](): js.Array[T] = js.native

  /**
    * Retrieve the write concern error if any
    * @return the write concern error if any
    */
  def getWriteConcernError(): WriteConcernError = js.native

  /**
    * Returns a specific write error object
    * @return a specific write error object
    */
  def getWriteErrorAt(): WriteError = js.native

  /**
    * Returns the number of write errors off the bulk operation
    * @return the number of write errors off the bulk operation
    */
  def getWriteErrorCount(): Int = js.native

  /**
    * Retrieve all write errors
    * @return all write errors
    */
  def getWriteErrors(): js.Array[WriteError] = js.native

  /**
    * Returns true if the bulk operation contains a write error
    * @return true if the bulk operation contains a write error
    */
  def hasWriteErrors(): Boolean = js.native

}

/**
  * Bulk Write Result Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSName("BulkWriteResult")
object BulkWriteResult extends BulkWriteResultClass