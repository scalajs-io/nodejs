package io.scalajs.npm.cassandradriver

import io.scalajs.RawOptions
import io.scalajs.nodejs.Error
import io.scalajs.nodejs.events.IEventEmitter
import io.scalajs.nodejs.stream.Readable

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * Cassandra Client
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("cassandra-driver", "Client")
class Client(options: ClientOptions = js.native) extends IEventEmitter {

  /**
    * Allows you can execute multiple statements in a batch to update/insert several rows atomically even in
    * different column families.
    * @param queries  the given array of queries
    * @param options  the given query options
    * @param callback the callback function
    * @example {{{ client.batch(queries, { prepare: true }, function(err) { ... }) }}}
    */
  def batch(queries: js.Array[BatchUpdate], options: QueryOptions | RawOptions, callback: js.Function): Unit = js.native

  /**
    * When using #eachRow() and #stream() methods, the driver parses each row as soon as it is received, yielding rows
    * without buffering them.
    * @param query    the given query
    * @param params   the given query parameters
    * @param options  the optional query options
    * @param callback the callback function
    * @example {{{ client.eachRow('SELECT time, val FROM temperature WHERE station_id=', ['abc'], function(n, row) { ... }) }}}
    */
  def eachRow[T](query: String, params: CassandraParams, options: RawOptions, callback: js.Function2[Int, T, Any]): Unit = js.native

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
  def eachRow[T](query: String, params: CassandraParams, options: RawOptions, callback: js.Function2[Int, T, Any], endCallback: js.Function): Unit = js.native

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
    * @param query    the given query statement
    * @param callback the callback function
    * @example {{{ client.execute(query, params, { prepare: true }, function(err) { ... }) }}}
    */
  def execute(query: String, callback: js.Function2[Error, js.Dictionary[_], Any]): Unit = js.native

  /**
    * Executes the query and returns the error or result to the callback function
    * @param query    the given query
    * @param params   the given query parameters
    * @param callback the callback function
    * @example {{{ client.execute(query, ['guy'], function(err, result) { ... }) }}}
    */
  def execute(query: String, params: CassandraParams, callback: js.Function2[Error, js.Dictionary[_], Any]): Unit = js.native

  /**
    * Executes the update statement and returns the error to the callback function
    * @param update   the given update statement
    * @param params   the given query parameters
    * @param options  the optional update options
    * @param callback the callback function
    * @example {{{ client.execute(query, params, { prepare: true }, function(err) { ... }) }}}
    */
  def execute(update: String, params: CassandraParams, options: QueryOptions | RawOptions, callback: js.Function2[Error, js.Dictionary[_], Any]): Unit = js.native

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
  def stream(query: String, params: CassandraParams = js.native): Readable = js.native

}

/**
  * Cassandra Client Companion
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("cassandra-driver", "Client")
object Client extends js.Object