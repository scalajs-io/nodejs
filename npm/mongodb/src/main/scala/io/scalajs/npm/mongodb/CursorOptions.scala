package io.scalajs.npm.mongodb

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

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
@ScalaJSDefined
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
                    var partial: js.UndefOr[Boolean] = js.undefined)
    extends js.Object
