package io.scalajs.npm.combinedstream

import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.stream.Readable

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * combined-stream - A stream that emits multiple other streams one after another.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait CombinedStream extends Readable {

  //////////////////////////////////////////////////////////////////
  //    Properties
  //////////////////////////////////////////////////////////////////

  /**
    * The amount of bytes (or characters) currently buffered by combinedStream.
    */
  def dataSize: Int = js.native

  /**
    * The maximum amount of bytes (or characters) to buffer for all source streams. If this value is exceeded,
    * combinedStream emits an 'error' event.
    */
  def maxDataSize: Int = js.native

  /**
    * Whether to apply back pressure to the underlying streams. If set to false, the underlying streams
    * will never be paused. If set to true, the underlying streams will be paused right after being appended,
    * as well as when delayedStream.pipe() wants to throttle.
    */
  def pauseStreams: Boolean = js.native

  //////////////////////////////////////////////////////////////////
  //    Methods
  //////////////////////////////////////////////////////////////////

  /**
    * Appends the given stream to the combinedStream object. If pauseStreams is set to `true`,
    * this stream will also be paused right away.
    *
    * streams can also be a function that takes one parameter called next. next is a function that
    * must be invoked in order to provide the next stream, see example above.
    *
    * Regardless of how the stream is appended, combined-stream always attaches an 'error' listener to it,
    * so you don't have to do that manually.
    *
    * Special case: stream can also be a String or Buffer.
    * @param callback the given callback function
    */
  def append(callback: js.Function1[js.Function1[Readable | Buffer | String, Readable], Any]): Unit = js.native

  /**
    * Appends the given stream to the combinedStream object. If pauseStreams is set to `true`,
    * this stream will also be paused right away.
    *
    * streams can also be a function that takes one parameter called next. next is a function that
    * must be invoked in order to provide the next stream, see example above.
    *
    * Regardless of how the stream is appended, combined-stream always attaches an 'error' listener to it,
    * so you don't have to do that manually.
    *
    * Special case: stream can also be a String or Buffer.
    * @param stream the given [[Readable stream]]
    */
  def append(stream: Readable): Unit = js.native

  /**
    * Appends the given stream to the combinedStream object. If pauseStreams is set to `true`,
    * this stream will also be paused right away.
    *
    * streams can also be a function that takes one parameter called next. next is a function that
    * must be invoked in order to provide the next stream, see example above.
    *
    * Regardless of how the stream is appended, combined-stream always attaches an 'error' listener to it,
    * so you don't have to do that manually.
    *
    * Special case: stream can also be a String or Buffer.
    * @param stream the given [[String string]] or [[Buffer buffer]]
    */
  def append(stream: String | Buffer): Unit = js.native

  /**
    * Same as combinedStream.end(), except it emits a 'close' event instead of 'end'.
    */
  def destroy(): Unit = js.native

  /**
    * You should not call this, combinedStream takes care of piping the appended streams into itself for you.
    */
  def write(data: js.Any): Unit = js.native

}

/**
  * CombinedStream Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("combined-stream", JSImport.Namespace)
object CombinedStream extends js.Object {

  /**
    * Returns a new combined stream object.
    * @param options the given [[CombineStreamOptions optional settings]]
    * @return a new combined stream object.
    */
  def create(options: CombineStreamOptions = js.native): CombinedStream = js.native

}