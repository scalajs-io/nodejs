package org.scalajs.nodejs.stream

import org.scalajs.nodejs.buffer.Buffer
import org.scalajs.nodejs.errors
import org.scalajs.nodejs.events.EventEmitter
import org.scalajs.nodejs.util.ScalaJsHelper._

import scala.scalajs.js
import scala.scalajs.js.|

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
  def end(chunk: String | Buffer, encoding: String, callback: js.Function): Unit = js.native

  /**
    * Call this method when no more data will be written to the stream. If supplied, the callback
    * is attached as a listener on the 'finish' event.
    * Calling stream.write() after calling stream.end() will raise an error.
    * @param chunk    The data to write (<String> | <Buffer>)
    * @param encoding The encoding, if chunk is a String
    * @example writable.end([chunk][, encoding][, callback])
    */
  def end(chunk: String | Buffer, encoding: String = null): Unit = js.native

  /**
    * Call this method when no more data will be written to the stream. If supplied, the callback
    * is attached as a listener on the 'finish' event.
    * Calling stream.write() after calling stream.end() will raise an error.
    * @param chunk    The data to write (<String> | <Buffer>)
    * @param callback the Callback for when this chunk of data is flushed
    * @example writable.end([chunk][, encoding][, callback])
    */
  def end(chunk: String | Buffer, callback: js.Function): Unit = js.native

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
  def write(chunk: String | Buffer, encoding: String, callback: js.Function): Boolean = js.native

  /**
    * Flush all data, buffered since stream.cork() call.
    * @param chunk    The data to write (<String> | <Buffer>)
    * @param encoding The encoding, if chunk is a String
    * @return true, if the data was handled completely
    * @example writable.write(chunk[, encoding][, callback])
    */
  def write(chunk: String | Buffer, encoding: String = null): Boolean = js.native

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

    def endFuture(data: String | Buffer, encoding: String = null) = futureCallbackE0[errors.Error](writable.end(data, encoding, _))

    def endFuture() = futureCallbackE0[errors.Error](writable.end(_))

    def writeFuture(data: String | Buffer, encoding: String = null) = futureCallbackE0[errors.Error](writable.write(data, encoding, _))
    
    /////////////////////////////////////////////////////////////////////////////////
    //      Events
    /////////////////////////////////////////////////////////////////////////////////

    /**
      * Emitted when the stream and any of its underlying resources (a file descriptor, for example) have been closed.
      * The event indicates that no more events will be emitted, and no further computation will occur.
      */
    @inline
    def onClose(listener: js.Function) = writable.on("close", listener)

    /**
      * If a stream.write(chunk) call returns false, then the 'drain' event will indicate when it is appropriate
      * to begin writing more data to the stream.
      */
    @inline
    def onDrain(listener: js.Function) = writable.on("drain", listener)

    /**
      * Emitted if there was an error when writing or piping data.
      */
    @inline
    def onError(listener: errors.Error => Any) = writable.on("error", listener)

    /**
      * When the stream.end() method has been called, and all data has been flushed to the underlying system,
      * this event is emitted.
      */
    @inline
    def onFinish(listener: () => Any) = writable.on("finish", listener)

    /**
      * This is emitted whenever the stream.pipe() method is called on a readable stream, adding this writable to
      * its set of destinations.
      */
    @inline
    def onPipe(listener: js.Function) = writable.on("pipe", listener)

    /**
      * This is emitted whenever the stream.unpipe() method is called on a readable stream, removing this writable
      * from its set of destinations.
      */
    @inline
    def onUnpipe(listener: js.Function) = writable.on("unpipe", listener)

  }

}