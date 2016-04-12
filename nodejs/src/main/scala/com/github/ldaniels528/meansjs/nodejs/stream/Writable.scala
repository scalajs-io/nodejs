package com.github.ldaniels528.meansjs.nodejs.stream

import com.github.ldaniels528.meansjs.nodejs.events.EventEmitter

import scala.scalajs.js

/**
  * The Writable stream interface is an abstraction for a destination that you are writing data to.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Writable extends EventEmitter {

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Forces buffering of all writes.
    * Buffered data will be flushed either at stream.uncork() or at stream.end() call.
    * @example writable.cork()
    */
  def cork(): Unit

  /**
    * Call this method when no more data will be written to the stream. If supplied, the callback
    * is attached as a listener on the 'finish' event.
    * Calling stream.write() after calling stream.end() will raise an error.
    * @example writable.end([chunk][, encoding][, callback])
    */
  def end(chunk: js.Any, encoding: String, callback: js.Function): Unit

  def end(chunk: js.Any, encoding: String): Unit

  def end(chunk: js.Any, callback: js.Function): Unit

  def end(): Unit

  /**
    * Sets the default encoding for a writable stream.
    * @example writable.setDefaultEncoding(encoding)
    */
  def setDefaultEncoding(encoding: String): Unit

  /**
    * Flush all data, buffered since stream.cork() call.
    * @example writable.uncork()
    */
  def uncork(): Unit

  /**
    * Flush all data, buffered since stream.cork() call.
    * @example writable.write(chunk[, encoding][, callback])
    */
  def write(chunk: js.Any, encoding: String, callback: js.Function): Boolean

  def write(chunk: js.Any, encoding: String): Boolean

  def write(chunk: js.Any, callback: js.Function): Boolean

  def write(chunk: js.Any): Boolean

}
