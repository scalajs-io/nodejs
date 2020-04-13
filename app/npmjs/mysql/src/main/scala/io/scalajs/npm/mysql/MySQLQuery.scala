package io.scalajs.npm.mysql

import io.scalajs.nodejs.events.IEventEmitter

import scala.scalajs.js

/**
  * MySQL Query handle
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait MySQLQuery extends IEventEmitter {

  def pause(): Unit = js.native

  def resume(): Unit = js.native

  /**
    * The query object provides a convenience method .stream([options]) that wraps query events into a
    * Readable Streams2 object. This stream can easily be piped downstream and provides automatic pause/resume,
    * based on downstream congestion and the optional highWaterMark. The objectMode parameter of the stream is
    * set to true and cannot be changed (if you need a byte stream, you will need to use a transform stream.
    * @param options the given [[MySQLStreamOptions options]]
    * @return a [[Readable readable stream]]
    */
  def stream(options: MySQLStreamOptions): Readable = js.native

}

/**
  * Query Companion
  * @author lawrence.daniels@gmail.com
  */
object MySQLQuery {

  /**
    * Query Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class QueryExtensions(val query: MySQLQuery) extends AnyVal {

    def onEnd(callback: js.Function): query.type = query.on("end", callback)

    def onError(callback: js.Function): query.type = query.on("error", callback)

    def onFields(callback: js.Function): query.type = query.on("fields", callback)

    def onResult(callback: js.Function): query.type = query.on("result", callback)

  }

}