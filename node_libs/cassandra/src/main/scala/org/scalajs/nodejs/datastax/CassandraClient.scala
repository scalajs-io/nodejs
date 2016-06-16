package org.scalajs.nodejs.datastax

import org.scalajs.nodejs.errors
import org.scalajs.nodejs.events.EventEmitter
import org.scalajs.nodejs.stream.Readable
import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.nodejs.util.ScalaJsHelper

import scala.scalajs.js

/**
  * Cassandra Client
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait CassandraClient extends EventEmitter {

  /**
    * Allows you can execute multiple statements in a batch to update/insert several rows atomically even in
    * different column families.
    * @param queries  the given array of queries
    * @param options  the given query options
    * @param callback the callback function
    * @example {{{ client.batch(queries, { prepare: true }, function(err) { ... }) }}}
    */
  def batch(queries: js.Array[BatchUpdate], options: QueryOptions, callback: js.Function): Unit = js.native

  /**
    * When using #eachRow() and #stream() methods, the driver parses each row as soon as it is received, yielding rows
    * without buffering them.
    * @param query       the given query
    * @param params      the given query parameters
    * @param options     the optional query options
    * @param callback    the callback function
    * @param endCallback the callback for the final block of results
    * @example {{{ client.eachRow('SELECT time, val FROM temperature WHERE station_id=', ['abc'], function(n, row) { ... }) }}}
    */
  def eachRow(query: String, params: CassandraParams, options: QueryOptions, callback: js.Function, endCallback: js.Function): Unit = js.native

  /**
    * When using #eachRow() and #stream() methods, the driver parses each row as soon as it is received, yielding rows
    * without buffering them.
    * @param query    the given query
    * @param params   the given query parameters
    * @param options  the optional query options
    * @param callback the callback function
    * @example {{{ client.eachRow('SELECT time, val FROM temperature WHERE station_id=', ['abc'], function(n, row) { ... }) }}}
    */
  def eachRow(query: String, params: CassandraParams, options: QueryOptions, callback: js.Function): Unit = js.native

  /**
    * When using #eachRow() and #stream() methods, the driver parses each row as soon as it is received, yielding rows
    * without buffering them.
    * @param query    the given query
    * @param params   the given query parameters
    * @param callback the callback function
    * @example {{{ client.eachRow('SELECT time, val FROM temperature WHERE station_id=', ['abc'], function(n, row) { ... }) }}}
    */
  def eachRow(query: String, params: CassandraParams, callback: js.Function): Unit = js.native

  /**
    * Executes the update statement and returns the error to the callback function
    * @param update   the given update statement
    * @param params   the given query parameters
    * @param options  the optional update options
    * @param callback the callback function
    * @example {{{ client.execute(query, params, { prepare: true }, function(err) { ... }) }}}
    */
  def execute(update: String, params: CassandraParams, options: QueryOptions, callback: js.Function): Unit = js.native

  /**
    * Executes the query and returns the error or result to the callback function
    * @param query    the given query
    * @param params   the given query parameters
    * @param callback the callback function
    * @example {{{ client.execute(query, ['guy'], function(err, result) { ... }) }}}
    */
  def execute(query: String, params: CassandraParams, callback: js.Function): Unit = js.native

  /**
    * Returns the metadata
    * @return the metadata
    */
  def metadata: ClientMetaData = js.native

  /**
    * The #stream() method works in the same way as #eachRow() but instead of callback it returns a Readable Streams2
    * object in objectMode that emits instances of Row. It can be piped downstream and provides automatic pause/resume
    * logic (it buffers when not read).
    * @param query  the given query
    * @param params the given query parameters
    * @return a [[Readable]]
    * @example {{{ client.stream('SELECT time, val FROM temperature WHERE station_id=', ['abc']) }}}
    */
  def stream(query: String, params: CassandraParams): Readable = js.native

}

/**
  * Cassandra Client Companion
  * @author lawrence.daniels@gmail.com
  */
object CassandraClient {

  /**
    * Cassandra Client Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class CassandraClientExtensions(val client: CassandraClient) extends AnyVal {

    /**
      * Allows you can execute multiple statements in a batch to update/insert several rows atomically even in
      * different column families.
      * @param queries the given array of queries
      * @param options the given query options
      * @return the promise of an error result
      */
    @inline
    def batchFuture(queries: js.Array[BatchUpdate], options: QueryOptions = null) = {
      futureCallbackE0[errors.Error](client.batch(queries, options, _))
    }

    /**
      * Executes the query; invoking the callback function for each row of the result
      * @param query   the given query
      * @param params  the given query parameters
      * @param options the optional query options
      * @return the promise of a result
      */
    @inline
    def eachRowFuture[T](query: String, params: CassandraParams, options: QueryOptions = null) = {
      futureCallbackA2[Int, T](client.eachRow(query, params, _))
    }

    /**
      * Executes the update statement and returns the full result set to the callback function
      * @param query   the given query
      * @param params  the given query parameters
      * @param options the optional query options
      * @return the promise of a result
      */
    @inline
    def executeFuture(query: String, params: CassandraParams, options: QueryOptions) = {
      futureCallbackE0[errors.Error](client.execute(query, params, options, _))
    }

    /**
      * Executes the query and returns the full result set to the callback function
      * @param query  the given query
      * @param params the given query parameters
      * @return the promise of a result
      */
    @inline
    def executeFuture(query: String, params: CassandraParams) = {
      futureCallbackE1[errors.Error, CassandraResultSet](client.execute(query, params, _))
    }

    /**
      * Handles emitted "log" events
      * @example client.on('log', function(level, className, message, furtherInfo) { ... })
      */
    @inline
    def onLog(callback: js.Function4[String, String, String, String, Any]) = client.on("log", callback)

  }

}