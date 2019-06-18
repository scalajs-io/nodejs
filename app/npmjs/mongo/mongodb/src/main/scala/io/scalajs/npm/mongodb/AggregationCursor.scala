package io.scalajs.npm.mongodb

import io.scalajs.nodejs

import scala.scalajs.js

/**
  * Aggregation Cursor
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait AggregationCursor[T] extends nodejs.stream.Readable {

  /**
    * Sets the batch size parameter of this cursor to the given value.
    * @param size the new batch size.
    * @example batchSize(batchSize[, callback])
    */
  def batchSize(size: Int): this.type = js.native

  /**
    * Clone the cursor
    */
  override def clone(): this.type = js.native

  /**
    * Close the cursor, sending a AggregationCursor command and emitting close.
    * @param callback this optional callbak will be called after executing this method.
    *                 The first parameter will always contain null while;
    *                 The second parameter will contain a reference to this cursor.
    */
  def close(callback: MongoCallback1[this.type] = js.native): js.Promise[this.type] = js.native

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
  def each(callback: MongoCallback1[T]): Unit = js.native

  /**
    * Gets a detailed information about how the query is performed on this cursor and how long it took the database to process it.
    * @param callback this will be called after executing this method. The first parameter will always be null while
    *                 the second parameter will be an object containing the details.
    * @example explain(callback)
    */
  def explain(callback: MongoCallback1[js.Any]): Unit = js.native

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
    * @return a promise of the results
    */
  def toArray(callback: MongoCallback1[js.Array[T]] = js.native): js.Promise[js.Array[T]] = js.native

}
