package com.github.ldaniels528.meansjs.mongodb

import com.github.ldaniels528.meansjs.nodejs.events.EventEmitter

import scala.scalajs.js

/**
  * Cursor Stream
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait CursorStream extends EventEmitter {

  /**
    * This is the preferred way if you have to retrieve a lot of data for streaming, as data is deserialized
    * a data event is emitted. This keeps the resident memory usage low as the documents are streamed to you.
    * Very useful if you are pushing documents out via websockets or some other streaming socket protocol.
    * Once there is no more document the driver will emit the end event to notify the application that it’s done.
    * {{{
    *   var stream = collection.find({mykey:{$ne:2}}).stream();
    *   stream.on("data", function(item) {});
    *   stream.on("end", function() {});
    * }}}
    * @param eventName the given event name
    * @param callback  the given callback function
    */
  override def on(eventName: String, callback: js.Function): this.type = js.native

}

/**
  * Cursor Stream
  * @author lawrence.daniels@gmail.com
  */
object CursorStream {

  /**
    * Cursor Stream Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class CursorStreamExtensions(val stream: CursorStream) extends AnyVal {

    @inline
    def onData(callback: js.Function) = stream.on("data", callback)

    @inline
    def onEnd(callback: js.Function) = stream.on("end", callback)

  }

}