package io.scalajs.npm.mongodb

import io.scalajs.nodejs
import io.scalajs.npm.mongodb.Cursor.CursorFlag

import scala.concurrent.Future
import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.{Array, UndefOr, |}

/**
  * Cursor
  * @author lawrence.daniels@gmail.com
  * @see {{{ https://mongodb.github.io/node-mongodb-native/api-generated/cursor.html }}}
  */
@js.native
@JSImport("mongodb", "Cursor")
class Cursor extends nodejs.stream.Readable {

  /**
    * Add a cursor flag to the cursor
    * @param flag  The flag to set, must be one of following ['tailable', 'oplogReplay', 'noCursorTimeout', 'awaitData', 'partial'].
    * @param value The flag boolean value.
    */
  def addCursorFlag(flag: CursorFlag, value: Boolean): this.type = js.native

  /**
    * Add a query modifier to the cursor query
    * @param name  The query modifier (must start with $, such as $orderby etc)
    * @param value The flag boolean value.
    */
  def addQueryModifier(name: String, value: js.Any): this.type = js.native

  /**
    * Sets the batch size parameter of this cursor to the given value.
    * @param batchSize the new batch size.
    * @param callback  this optional callback will be called after executing this method. The first parameter will
    *                  contain an error object when the batchSize given is not a valid number or when the cursor is
    *                  already closed while the second parameter will contain a reference to this object upon successful
    *                  execution.
    * @example batchSize(batchSize[, callback])
    */
  def batchSize(batchSize: Int, callback: js.Function = js.native): this.type = js.native

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
    * Add a comment to the cursor query allowing for tracking the comment in the log.
    * @param value The comment attached to this query.
    */
  def comment(value: String): this.type = js.native

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
    * Set the cursor query
    * @param filter The filter object used for the cursor.
    */
  def filter(filter: js.Any): this.type = js.native

  /**
    * Iterates over all the documents for this cursor using the iterator, callback pattern.
    * @param iterator The iteration callback.
    * @param callback The end callback.
    */
  def forEach[T <: js.Any](iterator: js.Function1[T, Any], callback: js.Function1[MongoError, Any]): Unit = js.native

  /**
    * Set the cursor hint
    * @param hint If specified, then the query system will only consider plans using the hinted index.
    */
  def hint(hint: String = js.native): this.type = js.native

  /**
    * Check if the cursor is closed or open.
    * @return the state of the cursor.
    */
  def isClosed(): Boolean = js.native

  /**
    * Sets the limit parameter of this cursor to the given value.
    * @param limit    the new limit.
    * @param callback this optional callback will be called after executing this method. The first parameter will
    *                 contain an error object when the limit given is not a valid number or when the cursor is already
    *                 closed while the second parameter will contain a reference to this object upon successful execution.
    * @example limit(limit[, callback])
    */
  def limit(limit: Int, callback: js.Function = js.native): this.type = js.native

  /**
    * Map all documents using the provided function
    * @param transform The mapping transformation method.
    */
  def map(transform: js.Function): Unit = js.native

  /**
    * Set the cursor max
    * @param max Specify a $max value to specify the exclusive upper bound for a specific index in order to constrain
    *            the results of find(). The $max specifies the upper bound for all keys of a specific index in order.
    */
  def max(max: Int): this.type = js.native

  /**
    * Set a maxAwaitTimeMS on a tailing cursor query to allow to customize the timeout value for the option awaitData
    * (Only supported on MongoDB 3.2 or higher, ignored otherwise)
    * @param value Number of milliseconds to wait before aborting the tailed query.
    */
  def maxAwaitTimeMS(value: Int): this.type = js.native

  /**
    * Set the cursor maxScan
    * @param maxScan Constrains the query to only scan the specified number of documents when fulfilling the query
    */
  def maxScan(maxScan: Int): this.type = js.native

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
  def maxTimeMS(maxTimeMS: Int, callback: js.Function = js.native): this.type = js.native

  /**
    * Set the cursor min
    * @param min Specify a $min value to specify the inclusive lower bound for a specific index in order to constrain
    *            the results of find(). The $min specifies the lower bound for all keys of a specific index in order.
    */
  def min(min: Int): this.type = js.native

  /**
    * Get the next available document from the cursor, returns null if no more documents are available.
    * @param callback The result callback.
    * @return [[js.Promise promise]] if no callback passed
    */
  def next(callback: js.Function): Unit = js.native

  /**
    * Get the next available document from the cursor, returns null if no more documents are available.
    * @return [[js.Promise promise]] if no callback passed
    */
  def next[T <: js.Any](): js.Promise[T] = js.native

  /**
    * Gets the next document from the cursor.
    * @param callback The result callback.
    * @return [[js.Promise promise]] if no callback passed
    */
  @deprecated("Use next() instead", since = "2.0")
  def nextObject(callback: js.Function): Unit = js.native

  /**
    * Gets the next document from the cursor.
    * @return [[js.Promise promise]] if no callback passed
    */
  @deprecated("Use next() instead", since = "2.0")
  def nextObject[T <: js.Any](): js.Promise[T] = js.native

  /**
    * Sets a field projection for the query.
    * @param value The field projection object.
    */
  def project(value: js.Any): this.type = js.native

  /**
    * Set the cursor returnKey
    * @param returnKey Only return the index field or fields for the results of the query. If $returnKey is
    *                  set to true and the query does not use an index to perform the read operation, the
    *                  returned documents will not contain any fields.
    */
  def returnKey(returnKey: Int): this.type = js.native

  /**
    * Resets this cursor to its initial state. All settings like the query string, tailable, batchSizeValue,
    * skipValue and limits are preserved.
    */
  def rewind(): this.type = js.native

  /**
    * Sets the read preference for the cursor
    * @param pref     read preference for the cursor, one of [[Server.READ_PRIMARY Server.READ_PRIMARY]],
    *                 [[Server.READ_SECONDARY Server.READ_SECONDARY]], [[Server.READ_SECONDARY Server.READ_SECONDARY_ONLY]]
    * @param callback this optional callback will be called after executing this method. The first parameter will
    *                 contain an error object when the read preference given is not a valid number or when the cursor
    *                 is already closed while the second parameter will contain a reference to this object upon
    *                 successful execution.
    * @example setReadPreference(pref[, callback])
    */
  def setReadPreference(pref: String, callback: js.Function = js.native): this.type = js.native

  /**
    * Set the cursor showRecordId
    * @param enable The $showDiskLoc option has now been deprecated and replaced with the showRecordId field.
    *               $showDiskLoc will still be accepted for OP_QUERY stye find.
    */
  def showRecordId(enable: Boolean): this.type = js.native

  /**
    * Sets the skip parameter of this cursor to the given value.
    * @param skip     the new skip value.
    * @param callback this optional callback will be called after executing this method. The first parameter will contain
    *                 an error object when the skip value given is not a valid number or when the cursor is already closed
    *                 while the second parameter will contain a reference to this object upon successful execution.
    * @example skip(skip[, callback])
    */
  def skip(skip: Int, callback: js.Function = js.native): this.type = js.native

  /**
    * Sets the sort parameter of this cursor to the given value.
    * @param keyOrList this can be a string or an array. If passed as a string, the string will be the field to sort.
    *                  If passed an array, each element will represent a field to be sorted and should be an array that
    *                  contains the format [string, direction].
    * @param direction this determines how the results are sorted. "asc", "ascending" or 1 for
    *                  ascending order while "desc", "descending or -1 for descending order.
    *                  <b>Note</b> that the strings are case insensitive.
    * @param callback  this will be called after executing this method. The first parameter will contain an error
    *                  object when the cursor is already closed while the second parameter will contain a reference
    *                  to this object upon successful execution.
    * @example sort(keyOrList, direction, callback)
    */
  def sort(keyOrList: String, direction: Int | String, callback: js.Function): this.type = js.native

  /**
    * Sets the sort parameter of this cursor to the given value.
    * @param keyOrList this can be a string or an array. If passed as a string, the string will be the field to sort.
    *                  If passed an array, each element will represent a field to be sorted and should be an array that
    *                  contains the format [string, direction].
    * @param callback  this will be called after executing this method. The first parameter will contain an error
    *                  object when the cursor is already closed while the second parameter will contain a reference
    *                  to this object upon successful execution.
    * @example sort(keyOrList, direction, callback)
    */
  def sort(keyOrList: js.Array[js.Any], callback: js.Function = js.native): this.type = js.native

  /**
    * Sets the sort parameter of this cursor to the given value.
    * @param keyOrList this can be a string or an array. If passed as a string, the string will be the field to sort.
    *                  If passed an array, each element will represent a field to be sorted and should be an array that
    *                  contains the format [string, direction].
    * @param direction this determines how the results are sorted. "asc", "ascending" or 1 for
    *                  ascending order while "desc", "descending or -1 for descending order.
    *                  <b>Note</b> that the strings are case insensitive.
    * @example sort(keyOrList, direction, callback)
    */
  def sort(keyOrList: String | js.Array[js.Any], direction: Int | String): this.type = js.native

  /**
    * TODO document me
    * @param enable
    * @return
    */
  def snapshot(enable: Boolean): this.type = js.native

  /**
    * Returns a Node Transform Stream interface for this cursor.
    * {{{
    *   var stream = collection.find({mykey:{$ne:2}}).stream();
    *   stream.on("data", function(item) {});
    *   stream.on("end", function() {});
    * }}}
    * @return returns a [[CursorStream stream object]].
    */
  def stream(): CursorStream = js.native

  /**
    * Returns a Node Transform Stream interface for this cursor.
    * @return returns a [[CursorStream stream object]].
    */
  def stream(transform: StreamTransform): this.type = js.native

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

  type CursorFlag = String
  val TAILABLE: CursorFlag        = "tailable"
  val OPLOGREPLAY: CursorFlag     = "oplogReplay"
  val NOCURSORTIMEOUT: CursorFlag = "noCursorTimeout"
  val AWAITDATA: CursorFlag       = "awaitData"
  val PARTIAL: CursorFlag         = "partial"

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
    def batchSizeFuture(batchSize: Int): Future[Cursor] = callbackMongoFuture[Cursor](cursor.batchSize(batchSize, _))

    /**
      * Close the cursor.
      */
    @inline
    def closeFuture(): Future[Cursor] = callbackMongoFuture[Cursor](cursor.close)

    /**
      * Determines how many result the query for this cursor will return
      * @param applySkipLimit if set to true will apply the skip and limits set on the cursor. Defaults to false.
      */
    @inline
    def countFuture(applySkipLimit: Boolean): Future[Cursor] =
      callbackMongoFuture[Cursor](cursor.count(applySkipLimit, _))

    /**
      * Iterates over all the documents for this cursor. As with {cursor.toArray}, not all of the elements will be
      * iterated if this cursor had been previouly accessed. In that case, {cursor.rewind} can be used to reset the
      * cursor. However, unlike {cursor.toArray}, the cursor will only hold a maximum of batch size elements at any
      * given time if batch size is specified. Otherwise, the caller is responsible for making sure that the entire
      * result can fit the memory.
      */
    @inline
    def eachFuture[T <: js.Any]: Future[UndefOr[T]] = callbackMongoFuture[js.UndefOr[T]](cursor.each)

    /**
      * Gets a detailed information about how the query is performed on this cursor and how long it took the database to process it.
      */
    @inline
    def explainFuture[T <: js.Any]: Future[T] = callbackMongoFuture[T](cursor.explain)

    /**
      * Sets the limit parameter of this cursor to the given value.
      * @param limit the new limit.
      */
    @inline
    def limitFuture(limit: Int): Future[Cursor] = callbackMongoFuture[Cursor](cursor.limit(limit, _))

    /**
      * Specifies a time limit for a query operation. After the specified time is exceeded, the operation will be
      * aborted and an error will be returned to the client. If maxTimeMS is null, no limit is applied.
      * @param maxTimeMS the maxTimeMS for the query.
      */
    @inline
    def maxTimeMSFuture(maxTimeMS: Int): Future[Cursor] = callbackMongoFuture[Cursor](cursor.maxTimeMS(maxTimeMS, _))

    /**
      * Gets the next document from the cursor.
      */
    @inline
    def nextFuture[T <: js.Any]: Future[UndefOr[T]] = callbackMongoFuture[js.UndefOr[T]](cursor.next)

    @inline
    def onOnce(callback: js.Function): cursor.type = cursor.on("once", callback)

    /**
      * Sets the read preference for the cursor
      * @param pref read preference for the cursor, one of [[Server.READ_PRIMARY Server.READ_PRIMARY]],
      *             [[Server.READ_SECONDARY Server.READ_SECONDARY]], [[Server.READ_SECONDARY Server.READ_SECONDARY_ONLY]]
      */
    @inline
    def setReadPreferenceFuture(pref: String): Future[Cursor] =
      callbackMongoFuture[Cursor](cursor.setReadPreference(pref, _))

    /**
      * Sets the skip parameter of this cursor to the given value.
      * @param skip the new skip value.
      */
    @inline
    def skipFuture(skip: Int): Future[Cursor] = callbackMongoFuture[Cursor](cursor.skip(skip, _))

    /**
      * Sets the sort parameter of this cursor to the given value.
      * @param list this can be a string or an array. If passed as a string, the string will be the field to sort.
      *             If passed an array, each element will represent a field to be sorted and should be an array that
      *             contains the format [string, direction].
      */
    @inline
    def sortFuture(list: js.Array[js.Any]): Future[Cursor] = callbackMongoFuture[Cursor](cursor.sort(list, _))

    /**
      * Sets the sort parameter of this cursor to the given value.
      * @param key       this can be a string or an array. If passed as a string, the string will be the field to sort.
      *                  If passed an array, each element will represent a field to be sorted and should be an array that
      *                  contains the format [string, direction].
      * @param direction this determines how the results are sorted. "asc", "ascending" or 1 for
      *                  ascending order while "desc", "descending or -1 for descending order.
      *                  <b>Note</b> that the strings are case insensitive.
      */
    @inline
    def sortFuture(key: String, direction: Int | String): Future[Cursor] =
      callbackMongoFuture[Cursor](cursor.sort(key, direction, _))

    /**
      * Returns an array of documents. The caller is responsible for making sure that there is enough memory to store
      * the results. Note that the array only contain partial results when this cursor had been previouly accessed.
      * In that case, cursor.rewind() can be used to reset the cursor.
      */
    @inline
    def toArrayFuture[T <: js.Any]: Future[Array[T]] = callbackMongoFuture[js.Array[T]](cursor.toArray)

  }

}
