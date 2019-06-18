package io.scalajs.npm.mongodb

import io.scalajs._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * Cursor
  * @author lawrence.daniels@gmail.com
  * @see {{{ https://mongodb.github.io/node-mongodb-native/api-generated/cursor.html }}}
  */
@js.native
trait Cursor[T] extends nodejs.stream.Readable {

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
  def addQueryModifier(name: String, value: Boolean): this.type = js.native

  /**
    * Sets the batch size parameter of this cursor to the given value.
    * @param size     the new batch size.
    * @param callback this optional callback will be called after executing this method. The first parameter will
    *                 contain an error object when the batchSize given is not a valid number or when the cursor is
    *                 already closed while the second parameter will contain a reference to this object upon successful
    *                 execution.
    * @return a promise of the [[Cursor]] if the  callback was not passed
    * @example batchSize(size[, callback])
    */
  def batchSize(size: Int, callback: MongoCallback1[this.type] = js.native): js.Promise[this.type] = js.native

  /**
    * Clone the cursor
    */
  override def clone(): this.type = js.native

  /**
    * Close the cursor, sending a KillCursor command and emitting close.
    * @param callback this will be called after executing this method. The first parameter will always contain null
    *                 while the second parameter will contain a reference to this cursor.
    * @return a promise of the [[Cursor]] if the callback was not passed
    */
  def close(callback: MongoCallback1[this.type] = js.native): js.Promise[this.type] = js.native

  /**
    * Set the collation options for the cursor.
    * @param value the cursor collation options (MongoDB 3.4 or higher) settings for update operation
    *              (see 3.4 documentation for available fields).
    * @return the [[Cursor]]
    */
  def collation(value: js.Any): this.type = js.native

  /**
    * Add a comment to the cursor query allowing for tracking the comment in the log.
    * @param value The comment attached to this query.
    * @return the [[Cursor]]
    */
  def comment(value: String): this.type = js.native

  /**
    * Determines how many result the query for this cursor will return
    * @param applySkipLimit if set to true will apply the skip and limits set on the cursor. Defaults to false.
    * @param callback       this will be called after executing this method. The first parameter will contain the Error
    *                       object if an error occurred, or null otherwise. While the second parameter will contain the
    *                       number of results or null if an error occurred.
    * @param options        the optional settings.
    * @return a promise of the count if the  callback was not passed
    * @example count(applySkipLimit, [options], [callback])
    */
  def count(applySkipLimit: Boolean,
            options: CountOptions | RawOptions,
            callback: MongoCallback1[Int]): js.Promise[Int] = js.native

  /**
    * Determines how many result the query for this cursor will return
    * @param applySkipLimit if set to true will apply the skip and limits set on the cursor. Defaults to false.
    * @param callback       this will be called after executing this method. The first parameter will contain the Error
    *                       object if an error occurred, or null otherwise. While the second parameter will contain the
    *                       number of results or null if an error occurred.
    * @return a promise of the count if the  callback was not passed
    * @example count(applySkipLimit, [options], [callback])
    */
  def count(applySkipLimit: Boolean, callback: MongoCallback1[Int]): js.Promise[Int] = js.native

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
  @deprecated(message = "No alternatives specified", since = "2.2")
  def each(callback: MongoCallback1[T]): Unit = js.native

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
  def forEach(iterator: js.Function1[T, Any], callback: MongoCallback1[T]): Unit = js.native

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
    * @param value The limit for the cursor query.
    * @return the [[Cursor]]
    */
  def limit(value: Int): this.type = js.native

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
  def next(callback: MongoCallback1[T] = js.native): js.Promise[T] = js.native

  /**
    * Gets the next document from the cursor.
    * @param callback The result callback.
    * @return [[js.Promise promise]] if no callback passed
    */
  @deprecated("Use next() instead", since = "2.0")
  def nextObject(callback: MongoCallback1[T] = js.native): js.Promise[T] = js.native

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
    * @param readPreference The new read preference for the cursor.
    * @example setReadPreference(pref)
    */
  def setReadPreference(readPreference: ReadPreference | String): this.type = js.native

  /**
    * Set the cursor showRecordId
    * @param enable The $showDiskLoc option has now been deprecated and replaced with the showRecordId field.
    *               $showDiskLoc will still be accepted for OP_QUERY stye find.
    * @return the [[Cursor]]
    */
  def showRecordId(enable: Boolean): this.type = js.native

  /**
    * Set the skip for the cursor.
    * @param value The skip for the cursor query.
    * @return the [[Cursor]]
    */
  def skip(value: Int): this.type = js.native

  /**
    * Set the cursor snapshot
    * @param snapshot The $snapshot operator prevents the cursor from returning a document more than once
    *                 because an intervening write operation results in a move of the document.
    * @return the [[Cursor]]
    */
  def snapshot(snapshot: js.Any): this.type = js.native

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
    */
  def snapshot(enable: Boolean): this.type = js.native

  /**
    * Return a modified Readable stream including a possible transform method.
    * @param options the optional settings
    * @return returns a [[Cursor]].
    */
  def stream(options: CursorStreamOptions = js.native): nodejs.stream.Readable = js.native

  /**
    * Returns an array of documents. The caller is responsible for making sure that there is enough memory to store
    * the results. Note that the array only contain partial results when this cursor had been previously accessed.
    * In that case, cursor.rewind() can be used to reset the cursor.
    * @param callback This will be called after executing this method successfully. The first parameter will contain
    *                 the Error object if an error occurred, or null otherwise. The second parameter will contain an
    *                 array of BSON deserialized objects as a result of the query.
    */
  def toArray(callback: MongoCallback1[js.Array[T]] = js.native): js.Promise[js.Array[T]] = js.native

}

/**
  * Cursor Companion
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("mongodb", "Cursor")
object Cursor extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Constants
  /////////////////////////////////////////////////////////////////////////////////

  val INIT: Int = js.native
  val OPEN: Int = js.native
  val CLOSED: Int = js.native
  val GET_MORE: Int = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Static Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Clones a given cursor but uses new options
    * @example Cursor.cloneWithOptions(cursor)
    */
  def cloneWithOptions[T](cursor: Cursor[T]): CursorOptions = js.native

}

/**
  * Count Options
  * @param skip           The number of documents to skip.
  * @param limit          The maximum amounts to count before aborting.
  * @param maxTimeMS      Number of miliseconds to wait before aborting the query.
  * @param hint           An index name hint for the query.
  * @param readPreference The preferred read preference (ReadPreference.PRIMARY, ReadPreference.PRIMARY_PREFERRED,
  *                       ReadPreference.SECONDARY, ReadPreference.SECONDARY_PREFERRED, ReadPreference.NEAREST).
  */

class CountOptions(val skip: js.UndefOr[Int] = js.undefined,
                   val limit: js.UndefOr[Int] = js.undefined,
                   val maxTimeMS: js.UndefOr[Int] = js.undefined,
                   val hint: js.UndefOr[String] = js.undefined,
                   val readPreference: js.UndefOr[ReadPreference | String] = js.undefined) extends js.Object

/**
  * Cursor Options
  * @param skip                  the number of documents to skip.
  * @param limit                 the number of results to return. -1 has a special meaning and is used by Db.eval.
  *                              A value of 1 will also be treated as if it were -1.
  * @param sort                  {Array | Object}, set to sort the documents coming back from the query. Array of indexes, [[‘a’, 1]] etc.
  * @param hint                  {Object}, hint force the query to use a specific index.
  * @param explain               return the explaination of the query.
  * @param snapshot              Snapshot mode assures no duplicates are returned.
  * @param timeout               the allow the query to timeout.
  * @param tailable              allow the cursor to be tailable.
  * @param awaitdata             allow the cursor to wait for data, only applicable for tailable cursor.
  * @param oplogReplay           sets an internal flag, only applicable for tailable cursor.
  * @param batchSize             batchSize the number of the subset of results to request the database to return for every request.
  *                              This should initially be greater than 1 otherwise the database will automatically close the cursor.
  *                              The batch size can be set to 1 with cursorInstance.batchSize after performing the initial query to the database.
  * @param raw                   return all query documents as raw buffers (default false).
  * @param read                  specify override of read from source (primary/secondary).
  * @param returnKey             only return the index key.
  * @param maxScan               limit the number of items to scan.
  * @param min                   set minimum index bounds.
  * @param max                   set maximum index bounds.
  * @param maxTimeMS             the number of miliseconds to wait before aborting the query.
  * @param showDiskLoc           show disk location of results.
  * @param comment               you can put a $comment field on a query to make looking in the profiler logs simpler.
  * @param numberOfRetries       if using awaidata specifies the number of times to retry on timeout.
  * @param dbName                override the default dbName.
  * @param tailableRetryInterval specify the miliseconds between getMores on tailable cursor.
  * @param exhaust               have the server send all the documents at once as getMore packets.
  * @param partial               have the sharded system return a partial result from mongos.
  */

class CursorOptions(var skip: js.UndefOr[Int] = js.undefined,
                    var limit: js.UndefOr[Int] = js.undefined,
                    var sort: js.Any = null,
                    var hint: js.UndefOr[js.Object] = js.undefined,
                    var explain: js.UndefOr[Boolean] = js.undefined,
                    var snapshot: js.UndefOr[Boolean] = js.undefined,
                    var timeout: js.UndefOr[Boolean] = js.undefined,
                    var tailable: js.UndefOr[Boolean] = js.undefined,
                    var awaitdata: js.UndefOr[Boolean] = js.undefined,
                    var oplogReplay: js.UndefOr[Boolean] = js.undefined,
                    var batchSize: js.UndefOr[Int] = js.undefined,
                    var raw: js.UndefOr[Boolean] = js.undefined,
                    var read: js.UndefOr[Boolean] = js.undefined,
                    var returnKey: js.UndefOr[Boolean] = js.undefined,
                    var maxScan: js.UndefOr[Int] = js.undefined,
                    var min: js.UndefOr[Int] = js.undefined,
                    var max: js.UndefOr[Int] = js.undefined,
                    var maxTimeMS: js.UndefOr[Int] = js.undefined,
                    var showDiskLoc: js.UndefOr[Boolean] = js.undefined,
                    var comment: js.UndefOr[String] = js.undefined,
                    var numberOfRetries: js.UndefOr[Int] = js.undefined,
                    var dbName: js.UndefOr[String] = js.undefined,
                    var tailableRetryInterval: js.UndefOr[Int] = js.undefined,
                    var exhaust: js.UndefOr[Boolean] = js.undefined,
                    var partial: js.UndefOr[Boolean] = js.undefined) extends js.Object

/**
  * Cursor Stream Options
  * @param transform A transformation method applied to each document emitted by the stream.
  * @author lawrence.daniels@gmail.com
  */

class CursorStreamOptions(var transform: js.UndefOr[js.Function] = js.undefined) extends js.Object