package io.scalajs.npm

import io.scalajs.nodejs.{Error, NodeOptions}
import io.scalajs.util.ScalaJsHelper._

import scala.concurrent.Promise
import scala.scalajs.js
import scala.scalajs.js.|

/**
  * DataStax Cassandra Package object
  * @author lawrence.daniels@gmail.com
  */
package object cassandradriver {

  type CassandraParams = js.Array[_]

  type ConsistencyLevel = Int

  type PageState = js.Any

  /**
    * Client Extensions
    * @param client the given [[Client]]
    */
  implicit class ClientExtensions(val client: Client) extends AnyVal {

    /**
      * Allows you can execute multiple statements in a batch to update/insert several rows atomically even in
      * different column families.
      * @param queries the given array of queries
      * @param options the given query options
      * @return the promise of an error result
      */
    @inline
    def batchFuture(queries: js.Array[BatchUpdate], options: QueryOptions| NodeOptions = null): Promise[Unit] = {
      futureCallbackE0[Error](client.batch(queries, options, _))
    }

    /**
      * Executes the query; invoking the callback function for each row of the result
      * @param query   the given query
      * @param params  the given query parameters
      * @param options the optional query options
      * @return the promise of a result
      */
    @inline
    def eachRowFuture[T](query: String, params: CassandraParams, options: QueryOptions| NodeOptions = null): Promise[(Int, T)] = {
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
    def executeFuture(query: String, params: CassandraParams, options: QueryOptions | NodeOptions): Promise[js.Dictionary[_]] = {
      futureCallbackE1[Error, js.Dictionary[_]](client.execute(query, params, options, _))
    }

    /**
      * Executes the query and returns the full result set to the callback function
      * @param query  the given query
      * @param params the given query parameters
      * @return the promise of a result
      */
    @inline
    def executeFuture(query: String, params: CassandraParams): Promise[js.Dictionary[_]] = {
      futureCallbackE1[Error, js.Dictionary[_]](client.execute(query, params, _))
    }

    /**
      * Handles emitted "log" events
      * @example client.on('log', function(level, className, message, furtherInfo) { ... })
      */
    @inline
    def onLog(callback: js.Function4[String, String, String, String, Any]): client.type = client.on("log", callback)

  }

}
