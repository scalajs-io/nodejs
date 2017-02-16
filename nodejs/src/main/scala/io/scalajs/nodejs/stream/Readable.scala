package io.scalajs.nodejs.stream

import io.scalajs.RawOptions
import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.events.IEventEmitter
import io.scalajs.nodejs.{Error, stream}

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * The Readable stream interface is the abstraction for a source of data that you are reading from.
  * In other words, data comes out of a Readable stream.
  * @see https://nodejs.org/api/stream.html#stream_readable_streams
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Readable extends IEventEmitter {

  var _read: js.Function0[Any] = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Undocumented method
    * @see https://github.com/nodejs/node-v0.x-archive/blob/cfcb1de130867197cbc9c6012b7e84e08e53d032/lib/fs.js#L1597-L1620
    */
  def close(callback: js.Function = js.native): Unit = js.native

  /**
    * This method returns whether or not the readable has been explicitly paused by client code (using stream.pause()
    * without a corresponding stream.resume()).
    * @example readable.isPaused()
    */
  def isPaused(): Boolean = js.native

  /**
    * This method will cause a stream in flowing mode to stop emitting 'data' events, switching out of flowing mode.
    * Any data that becomes available will remain in the internal buffer.
    * @example readable.pause()
    */
  def pause(): this.type = js.native

  /**
    * This method pulls all the data out of a readable stream, and writes it to the supplied destination,
    * automatically managing the flow so that the destination is not overwhelmed by a fast readable stream.
    * Multiple destinations can be piped to safely.
    * @example readable.pipe(destination[, options])
    */
  def pipe(destination: Writable, options: RawOptions = js.native): this.type = js.native

  /**
    * TODO find documentation for this method
    */
  def push(value: js.Any): this.type = js.native

  /**
    * The read() method pulls some data out of the internal buffer and returns it. If there is no data available,
    * then it will return null.
    * <p/>If you pass in a size argument, then it will return that many bytes. If size bytes are not available,
    * then it will return null, unless we've ended, in which case it will return the data remaining in the buffer.
    * <p/>If you do not specify a size argument, then it will return all the data in the internal buffer.
    * <p/>This method should only be called in paused mode. In flowing mode, this method is called automatically
    * until the internal buffer is drained.
    * @example readable.read([size])
    */
  def read[T](size: Int = js.native): T = js.native

  /**
    * This method will cause the readable stream to resume emitting 'data' events.
    * This method will switch the stream into flowing mode. If you do not want to consume
    * the data from a stream, but you do want to get to its 'end' event, you can call
    * stream.resume() to open the flow of data.
    * @example readable.resume()
    */
  def resume(): this.type = js.native

  /**
    * Call this function to cause the stream to return strings of the specified encoding instead of Buffer objects.
    * For example, if you do readable.setEncoding('utf8'), then the output data will be interpreted as UTF-8 data,
    * and returned as strings. If you do readable.setEncoding('hex'), then the data will be encoded in hexadecimal
    * string format.
    * <p/>This properly handles multi-byte characters that would otherwise be potentially mangled if you simply pulled
    * the Buffers directly and called buf.toString(encoding) on them. If you want to read the data as strings,
    * always use this method.
    * <p/>Also you can disable any encoding at all with readable.setEncoding(null). This approach is very useful
    * if you deal with binary data or with large multi-byte strings spread out over multiple chunks.
    * @example readable.setEncoding(encoding)
    */
  def setEncoding(encoding: String): this.type = js.native

  /**
    * This method will remove the hooks set up for a previous stream.pipe() call.
    * <p/>If the destination is not specified, then all pipes are removed.
    * <p/>If the destination is specified, but no pipe is set up for it, then this is a no-op.
    * @example readable.unpipe([destination])
    */
  def unpipe(destination: Writable = js.native): Unit = js.native

  /**
    * This is useful in certain cases where a stream is being consumed by a parser, which needs
    * to "un-consume" some data that it has optimistically pulled out of the source, so that the
    * stream can be passed on to some other party.
    * <p/><b>Note</b> that stream.unshift(chunk) cannot be called after the 'end' event has been triggered;
    * a runtime error will be raised.
    * <p>If you find that you must often call stream.unshift(chunk) in your programs, consider implementing
    * a Transform stream instead.
    * @example readable.unshift(chunk)
    */
  def unshift(chunk: js.Any): Unit = js.native

  /**
    * Versions of Node.js prior to v0.10 had streams that did not implement the entire Streams API as it is today.
    * (See Compatibility for more information.)
    * <p/>If you are using an older Node.js library that emits 'data' events and has a stream.pause() method that is
    * advisory only, then you can use the wrap() method to create a Readable stream that uses the old stream as its
    * data source.
    * <p/>You will very rarely ever need to call this function, but it exists as a convenience for interacting with
    * old Node.js programs and libraries.
    * @example readable.wrap(stream)
    */
  def wrap(stream: js.Any): Unit = js.native

}

/**
  * Readable Companion
  * @author lawrence.daniels@gmail.com
  */
object Readable {

  /**
    * Stream Reading Iterator
    * @author lawrence.daniels@gmail.com
    */
  class StreamReadingIterator[T](readable: stream.Readable) extends scala.Iterator[T] {
    private var result: T = readable.read[T]()

    override def hasNext: Boolean = result != null

    override def next(): T = {
      val value = result
      result = readable.read[T]()
      value
    }
  }

  /**
    * Reader Extensions
    * @param readable the given [[stream.Readable]]
    */
  implicit class ReaderExtensions(val readable: stream.Readable) extends AnyVal {

    @inline
    def iterator[A]: scala.Iterator[A] = new StreamReadingIterator[A](readable)

  }

  /**
    * Readable Events
    * @author lawrence.daniels@gmail.com
    */
  implicit class ReadableEvents(val readable: Readable) extends AnyVal {

    @inline
    def readOption[T]() = Option(readable.read[T]())

    /////////////////////////////////////////////////////////////////////////////////
    //      Events
    /////////////////////////////////////////////////////////////////////////////////

    /**
      * Emitted when the stream and any of its underlying resources (a file descriptor, for example) have been closed.
      * The event indicates that no more events will be emitted, and no further computation will occur.
      */
    @inline
    def onClose(listener: js.Function): readable.type = readable.on("close", listener)

    /**
      * Attaching a 'data' event listener to a stream that has not been explicitly paused will switch the stream into
      * flowing mode. Data will then be passed as soon as it is available.
      */
    @inline
    def onData(listener: Buffer | String => Any): readable.type = readable.on("data", listener)

    /**
      * This event fires when there will be no more data to read. Note that the 'end' event will not fire unless the
      * data is completely consumed. This can be done by switching into flowing mode, or by calling stream.read()
      * repeatedly until you get to the end.
      */
    @inline
    def onEnd(listener: () => Any): readable.type = readable.on("end", listener)

    /**
      * Emitted if there was an error when writing or piping data.
      */
    @inline
    def onError(listener: Error => Any): readable.type = readable.on("error", listener)

    /**
      * When a chunk of data can be read from the stream, it will emit a 'readable' event. In some cases, listening
      * for a 'readable' event will cause some data to be read into the internal buffer from the underlying system,
      * if it hadn't already.
      */
    @inline
    def onReadable(listener: js.Function): readable.type = readable.on("readable", listener)

  }

}