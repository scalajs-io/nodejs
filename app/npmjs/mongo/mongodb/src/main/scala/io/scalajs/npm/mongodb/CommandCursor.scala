package io.scalajs.npm.mongodb

import io.scalajs.nodejs

import scala.scalajs.js

/**
  * Creates a new Command Cursor instance (INTERNAL TYPE, do not instantiate directly)
  * @see http://mongodb.github.io/node-mongodb-native/2.2/api/CommandCursor.html
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait CommandCursor[T] extends nodejs.stream.Readable {

  /**
    * Set the batch size for the cursor.
    * @param size The batchSize for the cursor.
    * @return a [[CommandCursor]]
    */
  def batchSize(size: Int): this.type = js.native

  /**
    * Clone the cursor
    * @return a [[CommandCursor]]
    */
  override def clone(): this.type = js.native

  /**
    * Close the cursor, sending a KillCursor command and emitting close.
    * @return a promise of the result
    */
  def close(): js.Promise[this.type] = js.native

  /**
    * Close the cursor, sending a KillCursor command and emitting close.
    * @param callback The result callback.
    */
  def close(callback: MongoCallback1[this.type]): Unit = js.native

  /**
    * Iterates over all the documents for this cursor. As with {cursor.toArray},
    * not all of the elements will be iterated if this cursor had been previouly accessed.
    * In that case, {cursor.rewind} can be used to reset the cursor. However, unlike
    * {cursor.toArray}, the cursor will only hold a maximum of batch size elements
    * at any given time if batch size is specified. Otherwise, the caller is responsible
    * for making sure that the entire result can fit the memory.
    * @param callback The result callback.
    */
  def each(callback: MongoCallback1[T]): Unit = js.native

  /**
    * Is the cursor closed
    * @return true, if the cursor is closed
    */
  def isClosed(): Boolean = js.native

  /**
    * Add a maxTimeMS stage to the aggregation pipeline
    * @param value The state maxTimeMS value.
    * @return a [[CommandCursor]]
    */
  def maxTimeMS(value: Int): this.type = js.native

  /**
    * Get the next available document from the cursor, returns null if no more documents are available.
    * @param callback The result callback.
    */
  def next(callback: MongoCallback1[T]): Unit = js.native

  /**
    * Returns an array of documents. The caller is responsible for making sure that there
    * is enough memory to store the results. Note that the array only contain partial
    * results when this cursor had been previouly accessed.
    * @return the promise of an array of results
    */
  def toArray(): js.Promise[js.Array[T]] = js.native

  /**
    * Returns an array of documents. The caller is responsible for making sure that there
    * is enough memory to store the results. Note that the array only contain partial
    * results when this cursor had been previouly accessed.
    * @param callback The result callback.
    */
  def toArray(callback: MongoCallback1[js.Array[T]]): Unit = js.native

}

/**
  * Command Cursor Singleton
  * @author lawrence.daniels@gmail.com
  */
object CommandCursor {

  /**
    * Command Cursor Enrichment
    * @param cursor the given [[CommandCursor]]
    */
  implicit class CommandCursorEnrichment[T](val cursor: CommandCursor[T]) extends AnyVal {

    /**
      * CommandCursor stream close event
      */
    @inline
    def onClose(handler: js.Function0[Any]): cursor.type = cursor.on("close", handler)

    /**
      * CommandCursor stream data event, fired for each document in the cursor.
      */
    @inline
    def onData(handler: js.Function1[T, Any]): cursor.type = cursor.on("data", handler)

    /**
      * CommandCursor stream end event
      */
    @inline
    def onEnd(handler: js.Function0[Any]): cursor.type = cursor.on("end", handler)

    /**
      * CommandCursor stream readable event
      */
    @inline
    def onReadable(handler: js.Function0[Any]): cursor.type = cursor.on("readable", handler)

  }

}