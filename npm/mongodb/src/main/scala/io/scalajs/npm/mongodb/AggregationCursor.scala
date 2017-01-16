package io.scalajs.npm.mongodb

import io.scalajs.nodejs

import scala.concurrent.Future
import scala.scalajs.js
import scala.scalajs.js.Array

/**
  * Aggregation Cursor
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait AggregationCursor extends nodejs.stream.Readable {

  /**
    * Sets the batch size parameter of this cursor to the given value.
    * @param batchSize the new batch size.
    * @example batchSize(batchSize[, callback])
    */
  def batchSize(batchSize: Int): this.type = js.native

  /**
    * Clone the cursor
    */
  override def clone(): this.type = js.native

  /**
    * Close the cursor.
    * @param callback this will be called after executing this method. The first parameter will always contain null
    *                 while the second parameter will contain a reference to this cursor.
    */
  def close(callback: js.Function): Unit = js.native

  /**
    * Close the cursor.
    */
  def close(): js.Promise[js.Any] = js.native

  /**
    * Iterates over all the documents for this cursor. As with {cursor.toArray}, not all of the elements will be
    * iterated if this cursor had been previouly accessed. In that case, {cursor.rewind} can be used to reset the
    * cursor. However, unlike {cursor.toArray}, the cursor will only hold a maximum of batch size elements at any
    * given time if batch size is specified. Otherwise, the caller is responsible for making sure that the entire
    * result can fit the memory.
    * @param callback this will be called for while iterating every document of the query result. The first parameter
    *                 will contain the Error object if an error occurred, or null otherwise. While the second parameter
    *                 will contain the document.
    */
  def each(callback: js.Function): Unit = js.native

  /**
    * Gets a detailed information about how the query is performed on this cursor and how long it took the database to process it.
    * @param callback this will be called after executing this method. The first parameter will always be null while
    *                 the second parameter will be an object containing the details.
    * @example explain(callback)
    */
  def explain(callback: js.Function): Unit = js.native

  /**
    * Check if the cursor is closed or open.
    * @return the state of the cursor.
    */
  def isClosed(): Boolean = js.native

  /**
    * Returns an array of documents. The caller is responsible for making sure that there is enough memory to store
    * the results. Note that the array only contain partial results when this cursor had been previouly accessed.
    * In that case, cursor.rewind() can be used to reset the cursor.
    * @param callback This will be called after executing this method successfully. The first parameter will contain
    *                 the Error object if an error occurred, or null otherwise. The second parameter will contain an
    *                 array of BSON deserialized objects as a result of the query.
    */
  def toArray(callback: js.Function): Unit = js.native

}

/**
  * Aggregation Cursor Companion
  * @author lawrence.daniels@gmail.com
  */
object AggregationCursor {

  /**
    * Aggregation Cursor Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class AggregationCursorExtensions(val cursor: AggregationCursor) extends AnyVal {

    /**
      * Returns an array of documents. The caller is responsible for making sure that there is enough memory to store
      * the results. Note that the array only contain partial results when this cursor had been previouly accessed.
      * In that case, cursor.rewind() can be used to reset the cursor.
      */
    @inline
    def toArrayFuture[T <: js.Any]: Future[Array[T]] = callbackMongoFuture[js.Array[T]](cursor.toArray)

  }

}