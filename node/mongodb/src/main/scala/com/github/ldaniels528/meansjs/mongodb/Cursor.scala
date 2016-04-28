package com.github.ldaniels528.meansjs.mongodb

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Cursor
  * @author lawrence.daniels@gmail.com
  * @see {{{ https://mongodb.github.io/node-mongodb-native/api-generated/cursor.html }}}
  */
@js.native
trait Cursor extends js.Object {

  /**
    * Sets the batch size parameter of this cursor to the given value.
    * @param batchSize the new batch size.
    * @param callback  this optional callback will be called after executing this method. The first parameter will
    *                  contain an error object when the batchSize given is not a valid number or when the cursor is
    *                  already closed while the second parameter will contain a reference to this object upon successful
    *                  execution.
    * @example batchSize(batchSize[, callback])
    */
  def batchSize(batchSize: Int, callback: js.Function): this.type = js.native

  /**
    * Close the cursor.
    * @param callback this will be called after executing this method. The first parameter will always contain null
    *                 while the second parameter will contain a reference to this cursor.
    */
  def close(callback: js.Function): Unit = js.native

  /**
    * Determines how many result the query for this cursor will return
    * @param applySkipLimit if set to true will apply the skip and limits set on the cursor. Defaults to false.
    * @param callback       this will be called after executing this method. The first parameter will contain the Error
    *                       object if an error occurred, or null otherwise. While the second parameter will contain the
    *                       number of results or null if an error occurred.
    * @example count(applySkipLimit, callback)
    */
  def count(applySkipLimit: Boolean, callback: js.Function): Unit = js.native

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
    * Sets the limit parameter of this cursor to the given value.
    * @param limit the new limit.
    * @example limit(limit[, callback])
    */
  def limit(limit: Int): this.type = js.native

  /**
    * Sets the limit parameter of this cursor to the given value.
    * @param limit    the new limit.
    * @param callback this optional callback will be called after executing this method. The first parameter will
    *                 contain an error object when the limit given is not a valid number or when the cursor is already
    *                 closed while the second parameter will contain a reference to this object upon successful execution.
    * @example limit(limit[, callback])
    */
  def limit(limit: Int, callback: js.Function): this.type = js.native

  /**
    * Specifies a time limit for a query operation. After the specified time is exceeded, the operation will be
    * aborted and an error will be returned to the client. If maxTimeMS is null, no limit is applied.
    * @param maxTimeMS the maxTimeMS for the query.
    * @param callback  this optional callback will be called after executing this method. The first parameter will
    *                  contain an error object when the limit given is not a valid number or when the cursor is
    *                  already closed while the second parameter will contain a reference to this object upon
    *                  successful execution.
    * @example maxTimeMS(maxTimeMS[, callback])
    */
  def maxTimeMS(maxTimeMS: Int, callback: js.Function): this.type = js.native

  /**
    * Gets the next document from the cursor.
    * @param callback this will be called after executing this method. The first parameter will contain an error
    *                 object on error while the second parameter will contain a document from the returned result
    *                 or null if there are no more results.
    */
  def nextObject(callback: js.Function): Unit = js.native

  /**
    * Resets this cursor to its initial state. All settings like the query string, tailable, batchSizeValue,
    * skipValue and limits are preserved.
    */
  def rewind(): this.type = js.native

  /**
    * Sets the read preference for the cursor
    * @param pref read preference for the cursor, one of [[ServerClass.READ_PRIMARY Server.READ_PRIMARY]],
    *             [[ServerClass.READ_SECONDARY Server.READ_SECONDARY]], [[ServerClass.READ_SECONDARY Server.READ_SECONDARY_ONLY]]
    * @example setReadPreference(pref[, callback])
    */
  def setReadPreference(pref: String): this.type = js.native

  /**
    * Sets the read preference for the cursor
    * @param pref     read preference for the cursor, one of [[ServerClass.READ_PRIMARY Server.READ_PRIMARY]],
    *                 [[ServerClass.READ_SECONDARY Server.READ_SECONDARY]], [[ServerClass.READ_SECONDARY Server.READ_SECONDARY_ONLY]]
    * @param callback this optional callback will be called after executing this method. The first parameter will
    *                 contain an error object when the read preference given is not a valid number or when the cursor
    *                 is already closed while the second parameter will contain a reference to this object upon
    *                 successful execution.
    * @example setReadPreference(pref[, callback])
    */
  def setReadPreference(pref: String, callback: js.Function): this.type = js.native

  /**
    * Sets the skip parameter of this cursor to the given value.
    * @param skip     the new skip value.
    * @param callback this optional callback will be called after executing this method. The first parameter will contain
    *                 an error object when the skip value given is not a valid number or when the cursor is already closed
    *                 while the second parameter will contain a reference to this object upon successful execution.
    * @example skip(skip[, callback])
    */
  def skip(skip: Int, callback: js.Function): this.type = js.native

  /**
    * Sets the sort parameter of this cursor to the given value.
    * @param keyOrList this can be a string or an array. If passed as a string, the string will be the field to sort.
    *                  If passed an array, each element will represent a field to be sorted and should be an array that
    *                  contains the format [string, direction].
    * @param direction this determines how the results are sorted. "asc", "ascending" or 1 for
    *                  ascending order while "desc", "desceding or -1 for descending order.
    *                  <b>Note</b> that the strings are case insensitive.
    * @param callback  this will be called after executing this method. The first parameter will contain an error
    *                  object when the cursor is already closed while the second parameter will contain a reference
    *                  to this object upon successful execution.
    * @example sort(keyOrList, direction, callback)
    */
  def sort(keyOrList: js.Any, direction: Int, callback: js.Function): this.type = js.native

  /**
    * Sets the sort parameter of this cursor to the given value.
    * @param keyOrList this can be a string or an array. If passed as a string, the string will be the field to sort.
    *                  If passed an array, each element will represent a field to be sorted and should be an array that
    *                  contains the format [string, direction].
    * @param direction this determines how the results are sorted. "asc", "ascending" or 1 for
    *                  ascending order while "desc", "desceding or -1 for descending order.
    *                  <b>Note</b> that the strings are case insensitive.
    * @param callback  this will be called after executing this method. The first parameter will contain an error
    *                  object when the cursor is already closed while the second parameter will contain a reference
    *                  to this object upon successful execution.
    * @example sort(keyOrList, direction, callback)
    */
  def sort(keyOrList: js.Any, direction: String, callback: js.Function): this.type = js.native

  /**
    * Returns a Node Transform Stream interface for this cursor.
    * @return returns a [[CursorStream stream object]].
    */
  def stream(): CursorStream = js.native

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
  * Cursor Companion
  * @author lawrence.daniels@gmail.com
  */
object Cursor {

  /**
    * Cursor Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class CursorExtensions(val cursor: Cursor) extends AnyVal {

    /**
      * Sets the batch size parameter of this cursor to the given value.
      * @param batchSize the new batch size.
      */
    @inline
    def batchSizeAsync(batchSize: Int) = callbackWithErrorToFuture[Cursor](cursor.batchSize(batchSize, _))

    /**
      * Close the cursor.
      */
    @inline
    def close() = callbackWithErrorToFuture[Cursor](cursor.close)

    /**
      * Determines how many result the query for this cursor will return
      * @param applySkipLimit if set to true will apply the skip and limits set on the cursor. Defaults to false.
      */
    @inline
    def countAsync(applySkipLimit: Boolean) = callbackWithErrorToFuture[Cursor](cursor.count(applySkipLimit, _))

    /**
      * Iterates over all the documents for this cursor. As with {cursor.toArray}, not all of the elements will be
      * iterated if this cursor had been previouly accessed. In that case, {cursor.rewind} can be used to reset the
      * cursor. However, unlike {cursor.toArray}, the cursor will only hold a maximum of batch size elements at any
      * given time if batch size is specified. Otherwise, the caller is responsible for making sure that the entire
      * result can fit the memory.
      */
    @inline
    def eachAsync[T <: js.Any] = callbackWithErrorToFuture[js.UndefOr[T]](cursor.each)

    /**
      * Gets a detailed information about how the query is performed on this cursor and how long it took the database to process it.
      */
    @inline
    def explainAsync[T <: js.Any] = callbackWithErrorToFuture[T](cursor.explain)

    /**
      * Sets the limit parameter of this cursor to the given value.
      * @param limit the new limit.
      */
    @inline
    def limitAsync(limit: Int) = callbackWithErrorToFuture[Cursor](cursor.limit(limit, _))

    /**
      * Specifies a time limit for a query operation. After the specified time is exceeded, the operation will be
      * aborted and an error will be returned to the client. If maxTimeMS is null, no limit is applied.
      * @param maxTimeMS the maxTimeMS for the query.
      */
    @inline
    def maxTimeMSAsync(maxTimeMS: Int) = callbackWithErrorToFuture[Cursor](cursor.maxTimeMS(maxTimeMS, _))

    /**
      * Gets the next document from the cursor.
      */
    @inline
    def nextObjectAsync[T <: js.Any] = callbackWithErrorToFuture[js.UndefOr[T]](cursor.nextObject)

    /**
      * Sets the read preference for the cursor
      * @param pref read preference for the cursor, one of [[ServerClass.READ_PRIMARY Server.READ_PRIMARY]],
      *             [[ServerClass.READ_SECONDARY Server.READ_SECONDARY]], [[ServerClass.READ_SECONDARY Server.READ_SECONDARY_ONLY]]
      */
    @inline
    def setReadPreferenceAsync(pref: String) = callbackWithErrorToFuture[Cursor](cursor.setReadPreference(pref, _))

    /**
      * Sets the skip parameter of this cursor to the given value.
      * @param skip the new skip value.
      */
    @inline
    def skipAsync(skip: Int) = callbackWithErrorToFuture[Cursor](cursor.skip(skip, _))

    /**
      * Sets the sort parameter of this cursor to the given value.
      * @param keyOrList this can be a string or an array. If passed as a string, the string will be the field to sort.
      *                  If passed an array, each element will represent a field to be sorted and should be an array that
      *                  contains the format [string, direction].
      * @param direction this determines how the results are sorted. "asc", "ascending" or 1 for
      *                  ascending order while "desc", "desceding or -1 for descending order.
      *                  <b>Note</b> that the strings are case insensitive.
      */
    @inline
    def sortAsync(keyOrList: js.Any, direction: Int) = {
      callbackWithErrorToFuture[Cursor](cursor.sort(keyOrList, direction, _))
    }

    /**
      * Sets the sort parameter of this cursor to the given value.
      * @param keyOrList this can be a string or an array. If passed as a string, the string will be the field to sort.
      *                  If passed an array, each element will represent a field to be sorted and should be an array that
      *                  contains the format [string, direction].
      * @param direction this determines how the results are sorted. "asc", "ascending" or 1 for
      *                  ascending order while "desc", "desceding or -1 for descending order.
      *                  <b>Note</b> that the strings are case insensitive.
      */
    @inline
    def sortAsync(keyOrList: js.Any, direction: String) = {
      callbackWithErrorToFuture[Cursor](cursor.sort(keyOrList, direction, _))
    }

    /**
      * Returns an array of documents. The caller is responsible for making sure that there is enough memory to store
      * the results. Note that the array only contain partial results when this cursor had been previouly accessed.
      * In that case, cursor.rewind() can be used to reset the cursor.
      */
    @inline
    def toArrayAsync[T <: js.Any] = callbackWithErrorToFuture[js.Array[T]](cursor.toArray)

  }

}