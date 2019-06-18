package io.scalajs.npm.mongodb

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * Bulk Write Result
  * @param ok        Did bulk operation correctly execute
  * @param nInserted Number of inserted documents
  * @param nUpdated  Number of documents updated logically
  * @param nUpserted Number of upserted documents
  * @param nModified Number of documents updated physically on disk
  * @param nRemoved  Number of removed documents
  */
@js.native
@JSGlobal("BulkWriteResult")
class BulkWriteResult(val ok: Boolean,
                      val nInserted: Int,
                      val nUpdated: Int,
                      val nUpserted: Int,
                      val nModified: Int,
                      val nRemoved: Int)
  extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

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
  * Write Concern Error
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait WriteConcernError extends js.Object {

  /** Write concern error code. */
  var code: Integer = js.native

  /** Write concern error message. */
  var errmsg: String = js.native

}

/**
  * Write Error
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait WriteError extends js.Object {

  /** Write concern error code */
  var code: Integer = js.native

  /** Write concern error original bulk operation index. */
  var index: Integer = js.native

  /** Write concern error message. */
  var errmsg: String = js.native

}