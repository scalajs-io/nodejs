package com.github.ldaniels528.meansjs.nodejs.stream

import com.github.ldaniels528.meansjs.nodejs.events.EventEmitter

import scala.scalajs.js

/**
  * The Readable stream interface is the abstraction for a source of data that you are reading from.
  * In other words, data comes out of a Readable stream.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Readable extends EventEmitter {

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * This method returns whether or not the readable has been explicitly paused by client code (using stream.pause()
    * without a corresponding stream.resume()).
    * @example readable.isPaused()
    */
  def isPaused(): Boolean

  /**
    * This method will cause a stream in flowing mode to stop emitting 'data' events, switching out of flowing mode.
    * Any data that becomes available will remain in the internal buffer.
    * @example readable.pause()
    */
  def pause(): this.type

  /**
    * This method pulls all the data out of a readable stream, and writes it to the supplied destination,
    * automatically managing the flow so that the destination is not overwhelmed by a fast readable stream.
    * Multiple destinations can be piped to safely.
    * @example readable.pipe(destination[, options])
    */
  def pipe(destination: js.Any, options: js.Any): this.type

  /**
    * This method pulls all the data out of a readable stream, and writes it to the supplied destination,
    * automatically managing the flow so that the destination is not overwhelmed by a fast readable stream.
    * Multiple destinations can be piped to safely.
    * @example readable.pipe(destination[, options])
    */
  def pipe(destination: js.Any): this.type

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
  def read(size: Int): js.Any

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
  def read(): js.Any

  /**
    * This method will cause the readable stream to resume emitting 'data' events.
    * This method will switch the stream into flowing mode. If you do not want to consume
    * the data from a stream, but you do want to get to its 'end' event, you can call
    * stream.resume() to open the flow of data.
    * @example readable.resume()
    */
  def resume(): this.type

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
  def setEncoding(encoding: String): this.type

  /**
    * This method will remove the hooks set up for a previous stream.pipe() call.
    * <p/>If the destination is not specified, then all pipes are removed.
    * <p/>If the destination is specified, but no pipe is set up for it, then this is a no-op.
    * @example readable.unpipe([destination])
    */
  def unpipe(destination: js.Any): Unit

  /**
    * This method will remove the hooks set up for a previous stream.pipe() call.
    * <p/>If the destination is not specified, then all pipes are removed.
    * <p/>If the destination is specified, but no pipe is set up for it, then this is a no-op.
    * @example readable.unpipe([destination])
    */
  def unpipe(): Unit

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
  def unshift(chunk: js.Any)

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
  def wrap(stream: js.Any): Unit

}
