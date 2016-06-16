package org.scalajs.nodejs.stream

import org.scalajs.nodejs.buffer.Buffer
import org.scalajs.nodejs.errors
import org.scalajs.nodejs.events.EventEmitter
import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.nodejs.events.EventEmitter
import org.scalajs.nodejs.util.ScalaJsHelper

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
  def cork(): Unit = js.native

  /**
    * Call this method when no more data will be written to the stream. If supplied, the callback
    * is attached as a listener on the 'finish' event.
    * Calling stream.write() after calling stream.end() will raise an error.
    * @param chunk    The data to write (<String> | <Buffer>)
    * @param encoding The encoding, if chunk is a String
    * @param callback the Callback for when this chunk of data is flushed
    * @example writable.end([chunk][, encoding][, callback])
    */
  def end(chunk: String, encoding: String, callback: js.Function): Unit = js.native

  /**
    * Call this method when no more data will be written to the stream. If supplied, the callback
    * is attached as a listener on the 'finish' event.
    * Calling stream.write() after calling stream.end() will raise an error.
    * @param chunk    The data to write (<String> | <Buffer>)
    * @param encoding The encoding, if chunk is a String
    * @example writable.end([chunk][, encoding][, callback])
    */
  def end(chunk: String, encoding: String): Unit = js.native

  /**
    * Call this method when no more data will be written to the stream. If supplied, the callback
    * is attached as a listener on the 'finish' event.
    * Calling stream.write() after calling stream.end() will raise an error.
    * @param chunk    The data to write (<String> | <Buffer>)
    * @param callback the Callback for when this chunk of data is flushed
    * @example writable.end([chunk][, encoding][, callback])
    */
  def end(chunk: String, callback: js.Function): Unit = js.native

  /**
    * Call this method when no more data will be written to the stream. If supplied, the callback
    * is attached as a listener on the 'finish' event.
    * Calling stream.write() after calling stream.end() will raise an error.
    * @param chunk The data to write (<String> | <Buffer>)
    * @example writable.end([chunk][, encoding][, callback])
    */
  def end(chunk: String): Unit = js.native

  /**
    * Call this method when no more data will be written to the stream. If supplied, the callback
    * is attached as a listener on the 'finish' event.
    * Calling stream.write() after calling stream.end() will raise an error.
    * @param chunk    The data to write (<String> | <Buffer>)
    * @param callback the Callback for when this chunk of data is flushed
    * @example writable.end([chunk][, encoding][, callback])
    */
  def end(chunk: Buffer, callback: js.Function): Unit = js.native

  /**
    * Call this method when no more data will be written to the stream. If supplied, the callback
    * is attached as a listener on the 'finish' event.
    * Calling stream.write() after calling stream.end() will raise an error.
    * @param chunk The data to write (<String> | <Buffer>)
    * @example writable.end([chunk][, encoding][, callback])
    */
  def end(chunk: Buffer): Unit = js.native

  /**
    * Call this method when no more data will be written to the stream. If supplied, the callback
    * is attached as a listener on the 'finish' event.
    * Calling stream.write() after calling stream.end() will raise an error.
    * @param callback the Callback for when this chunk of data is flushed
    * @example writable.end([chunk][, encoding][, callback])
    */
  def end(callback: js.Function): Unit = js.native

  /**
    * Call this method when no more data will be written to the stream. If supplied, the callback
    * is attached as a listener on the 'finish' event.
    * Calling stream.write() after calling stream.end() will raise an error.
    * @example writable.end([chunk][, encoding][, callback])
    */
  def end(): Unit = js.native

  /**
    * Sets the default encoding for a writable stream.
    * @example writable.setDefaultEncoding(encoding)
    */
  def setDefaultEncoding(encoding: String): this.type = js.native

  /**
    * Flush all data, buffered since stream.cork() call.
    * @example writable.uncork()
    */
  def uncork(): Unit = js.native

  /**
    * Flush all data, buffered since stream.cork() call.
    * @param chunk    The data to write (<String> | <Buffer>)
    * @param encoding The encoding, if chunk is a String
    * @param callback the Callback for when this chunk of data is flushed
    * @return true, if the data was handled completely
    * @example writable.write(chunk[, encoding][, callback])
    */
  def write(chunk: String, encoding: String, callback: js.Function): Boolean = js.native

  /**
    * Flush all data, buffered since stream.cork() call.
    * @param chunk    The data to write (<String> | <Buffer>)
    * @param encoding The encoding, if chunk is a String
    * @return true, if the data was handled completely
    * @example writable.write(chunk[, encoding][, callback])
    */
  def write(chunk: String, encoding: String): Boolean = js.native

  /**
    * Flush all data, buffered since stream.cork() call.
    * @param chunk The data to write (<String> | <Buffer>)
    * @return true, if the data was handled completely
    * @example writable.write(chunk[, encoding][, callback])
    */
  def write(chunk: String): Boolean = js.native

  /**
    * Flush all data, buffered since stream.cork() call.
    * @param chunk    The data to write (<String> | <Buffer>)
    * @param callback the Callback for when this chunk of data is flushed
    * @return true, if the data was handled completely
    * @example writable.write(chunk[, encoding][, callback])
    */
  def write(chunk: Buffer, callback: js.Function): Boolean = js.native

  /**
    * Flush all data, buffered since stream.cork() call.
    * @param chunk The data to write (<String> | <Buffer>)
    * @return true, if the data was handled completely
    * @example writable.write(chunk[, encoding][, callback])
    */
  def write(chunk: Buffer): Boolean = js.native

}

/**
  * Writable Companion
  * @author lawrence.daniels@gmail.com
  */
object Writable {

  /**
    * Writable Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class WritableExtensions(val writable: Writable) extends AnyVal {

    def endFuture(buffer: Buffer) = futureCallbackE0[errors.Error](writable.end(buffer, _))

    def endFuture(data: String, encoding: String) = futureCallbackE0[errors.Error](writable.end(data, encoding, _))

    def endFuture() = futureCallbackE0[errors.Error](writable.end(_))

    def writeFuture(buffer: Buffer) = futureCallbackE0[errors.Error](writable.write(buffer, _))

    def writeFuture(data: String, encoding: String) = futureCallbackE0[errors.Error](writable.write(data, encoding, _))
    
    /////////////////////////////////////////////////////////////////////////////////
    //      Events
    /////////////////////////////////////////////////////////////////////////////////

    /**
      * Emitted when the stream and any of its underlying resources (a file descriptor, for example) have been closed.
      * The event indicates that no more events will be emitted, and no further computation will occur.
      */
    @inline
    def onClose(callback: js.Function) = writable.on("close", callback)

    /**
      * If a stream.write(chunk) call returns false, then the 'drain' event will indicate when it is appropriate
      * to begin writing more data to the stream.
      */
    @inline
    def onDrain(callback: js.Function) = writable.on("drain", callback)

    /**
      * Emitted if there was an error when writing or piping data.
      */
    @inline
    def onError(callback: js.Function) = writable.on("error", callback)

    /**
      * When the stream.end() method has been called, and all data has been flushed to the underlying system,
      * this event is emitted.
      */
    @inline
    def onFinish(callback: js.Function) = writable.on("finish", callback)

    /**
      * This is emitted whenever the stream.pipe() method is called on a readable stream, adding this writable to
      * its set of destinations.
      */
    @inline
    def onPipe(callback: js.Function) = writable.on("pipe", callback)

    /**
      * This is emitted whenever the stream.unpipe() method is called on a readable stream, removing this writable
      * from its set of destinations.
      */
    @inline
    def onUnpipe(callback: js.Function) = writable.on("unpipe", callback)

  }

}