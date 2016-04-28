package com.github.ldaniels528.meansjs.mongodb

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Cursor Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class CursorOptions extends js.Object {
  // skip number of documents to skip.
  var skip: js.UndefOr[Int] = _

  // limit the number of results to return. -1 has a special meaning and is used by Db.eval.
  // A value of 1 will also be treated as if it were -1.
  var limit: js.UndefOr[Int] = _

  // {Array | Object}, set to sort the documents coming back from the query. Array of indexes, [[‘a’, 1]] etc.
  var sort: js.Any = _

  // {Object}, hint force the query to use a specific index.
  var hint: js.UndefOr[js.Object] = _

  // explain return the explaination of the query.
  var explain: js.UndefOr[Boolean] = _

  // snapshot Snapshot mode assures no duplicates are returned.
  var snapshot: js.UndefOr[Boolean] = _

  // timeout allow the query to timeout.
  var timeout: js.UndefOr[Boolean] = _

  // tailable allow the cursor to be tailable.
  var tailable: js.UndefOr[Boolean] = _

  // awaitdata allow the cursor to wait for data, only applicable for tailable cursor.
  var awaitdata: js.UndefOr[Boolean] = _

  // sets an internal flag, only applicable for tailable cursor.
  var oplogReplay: js.UndefOr[Boolean] = _

  // batchSize the number of the subset of results to request the database to return for every request.
  // This should initially be greater than 1 otherwise the database will automatically close the cursor.
  // The batch size can be set to 1 with cursorInstance.batchSize after performing the initial query to the database.
  var batchSize: js.UndefOr[Int] = _

  // raw return all query documents as raw buffers (default false).
  var raw: js.UndefOr[Boolean] = _

  // read specify override of read from source (primary/secondary).
  var read: js.UndefOr[Boolean] = _

  // returnKey only return the index key.
  var returnKey: js.UndefOr[Boolean] = _

  // maxScan limit the number of items to scan.
  var maxScan: js.UndefOr[Int] = _

  // min set index bounds.
  var min: js.UndefOr[Int] = _

  // max set index bounds.
  var max: js.UndefOr[Int] = _

  // number of miliseconds to wait before aborting the query.
  var maxTimeMS: js.UndefOr[Int] = _

  // showDiskLoc show disk location of results.
  var showDiskLoc: js.UndefOr[Boolean] = _

  // comment you can put a $comment field on a query to make looking in the profiler logs simpler.
  var comment: js.UndefOr[String] = _

  // numberOfRetries if using awaidata specifies the number of times to retry on timeout.
  var numberOfRetries: js.UndefOr[Int] = _

  // dbName override the default dbName.
  var dbName: js.UndefOr[String] = _

  // tailableRetryInterval specify the miliseconds between getMores on tailable cursor.
  var tailableRetryInterval: js.UndefOr[Int] = _

  // exhaust have the server send all the documents at once as getMore packets.
  var exhaust: js.UndefOr[Boolean] = _

  // partial have the sharded system return a partial result from mongos.
  var partial: js.UndefOr[Boolean] = _

}

/**
  * Cursor Options Companion
  * @author lawrence.daniels@gmail.com
  */
object CursorOptions {

  def apply(skip: js.UndefOr[Int] = js.undefined,
            limit: js.UndefOr[Int] = js.undefined,
            sort: js.Any = js.undefined,
            hint: js.UndefOr[js.Object] = js.undefined,
            explain: js.UndefOr[Boolean] = js.undefined,
            snapshot: js.UndefOr[Boolean] = js.undefined,
            timeout: js.UndefOr[Boolean] = js.undefined,
            tailable: js.UndefOr[Boolean] = js.undefined,
            awaitdata: js.UndefOr[Boolean] = js.undefined,
            oplogReplay: js.UndefOr[Boolean] = js.undefined,
            batchSize: js.UndefOr[Int] = js.undefined,
            raw: js.UndefOr[Boolean] = js.undefined,
            read: js.UndefOr[Boolean] = js.undefined,
            returnKey: js.UndefOr[Boolean] = js.undefined,
            maxScan: js.UndefOr[Int] = js.undefined,
            min: js.UndefOr[Int] = js.undefined,
            max: js.UndefOr[Int] = js.undefined,
            maxTimeMS: js.UndefOr[Int] = js.undefined,
            showDiskLoc: js.UndefOr[Boolean] = js.undefined,
            comment: js.UndefOr[String] = js.undefined,
            numberOfRetries: js.UndefOr[Int] = js.undefined,
            dbName: js.UndefOr[String] = js.undefined,
            tailableRetryInterval: js.UndefOr[Int] = js.undefined,
            exhaust: js.UndefOr[Boolean] = js.undefined,
            partial: js.UndefOr[Boolean] = js.undefined) = {
    val options = new CursorOptions()
    options.skip = skip
    options.limit = limit
    options.sort = sort
    options.hint = hint
    options.explain = explain
    options.snapshot = snapshot
    options.timeout = timeout
    options.tailable = tailable
    options.awaitdata = awaitdata
    options.oplogReplay = oplogReplay
    options.batchSize = batchSize
    options.raw = raw
    options.read = read
    options.returnKey = returnKey
    options.maxScan = maxScan
    options.min = min
    options.max = max
    options.maxTimeMS = maxTimeMS
    options.showDiskLoc = showDiskLoc
    options.comment = comment
    options.numberOfRetries = numberOfRetries
    options.dbName = dbName
    options.tailableRetryInterval = tailableRetryInterval
    options.exhaust = exhaust
    options.partial = partial
    options
  }

}
