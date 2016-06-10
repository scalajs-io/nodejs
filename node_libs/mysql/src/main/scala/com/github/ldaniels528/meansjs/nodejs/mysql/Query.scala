package com.github.ldaniels528.meansjs.nodejs.mysql

import com.github.ldaniels528.meansjs.nodejs.events.EventEmitter
import com.github.ldaniels528.meansjs.nodejs.stream.Readable

import scala.scalajs.js

/**
  * Query handle
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Query extends EventEmitter {

  def pause(): Unit = js.native

  def resume(): Unit = js.native

  /**
    * The query object provides a convenience method .stream([options]) that wraps query events into a
    * Readable Streams2 object. This stream can easily be piped downstream and provides automatic pause/resume,
    * based on downstream congestion and the optional highWaterMark. The objectMode parameter of the stream is
    * set to true and cannot be changed (if you need a byte stream, you will need to use a transform stream.
    * @param options the given [[StreamOptions options]]
    * @return a [[Readable readable stream]]
    */
  def stream(options: StreamOptions): Readable = js.native

}

/**
  * Query Companion
  * @author lawrence.daniels@gmail.com
  */
object Query {

  /**
    * Query Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class QueryExtensions(val query: Query) extends AnyVal {

    def onEnd(callback: js.Function) = query.on("end", callback)

    def onError(callback: js.Function) = query.on("error", callback)

    def onFields(callback: js.Function) = query.on("fields", callback)

    def onResult(callback: js.Function) = query.on("result", callback)

  }

}