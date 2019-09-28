package io.scalajs.nodejs
package stream

import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.util.PromiseHelper._

import scala.concurrent.Future
import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.typedarray.Uint8Array
import scala.scalajs.js.|

/**
  * The Writable stream interface is an abstraction for a destination that you are writing data to.
  */
@js.native
@JSImport("stream", "Writable")
class WritableClass(options: WritableOptions = js.native) extends Writable

// TODO: Merge WritableClass and trait?
/**
  * The Writable stream interface is an abstraction for a destination that you are writing data to.
  */
@js.native
trait Writable extends LegacyStream {

  /////////////////////////////////////////////////////////////////////////////////
  //      Internal Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * All Writable stream implementations must provide a writable._write() method to send data to the underlying resource.
    * @param chunk    The chunk to be written. Will always be a buffer unless the decodeStrings option was set to false.
    * @param encoding If the chunk is a string, then encoding is the character encoding of that string.
    *                 If chunk is a Buffer, or if the stream is operating in object mode, encoding may be ignored.
    * @param callback Call this function (optionally with an error argument) when processing is complete for the supplied chunk.
    */
  def _write(chunk: String, encoding: String, callback: js.Function1[Error, Any]): Unit = js.native

  /**
    * All Writable stream implementations must provide a writable._write() method to send data to the underlying resource.
    * @param chunk    The chunk to be written. Will always be a buffer unless the decodeStrings option was set to false.
    * @param callback Call this function (optionally with an error argument) when processing is complete for the supplied chunk.
    */
  def _write(chunk: Buffer, callback: js.Function1[Error, Any]): Unit = js.native

  /**
    * The writable._writev() method may be implemented in addition to writable._write() in stream implementations
    * that are capable of processing multiple chunks of data at once. If implemented, the method will be called with
    * all chunks of data currently buffered in the write queue.
    * @param chunks   The chunks to be written. Each chunk has following format: { chunk: ..., encoding: ... }.
    * @param callback A callback function (optionally with an error argument) to be invoked when processing is
    *                 complete for the supplied chunks.
    */
  def _writev(chunks: js.Array[Chunk], callback: js.Function1[Error, Any]): Unit = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Forces buffering of all writes.
    * Buffered data will be flushed either at stream.uncork() or at stream.end() call.
    * @example writable.cork()
    */
  def cork(): Unit = js.native

  def end(chunk: String | Uint8Array, callback: js.Function1[Error, Any]): Unit = js.native
  def end(chunk: String | Uint8Array): Unit                                     = js.native

  def end(chunk: String, encoding: String, callback: js.Function1[Error, Any]): Unit = js.native
  def end(chunk: String, encoding: String): Unit                                     = js.native
  def end(callback: js.Function1[Error, Any] = js.native): Unit                      = js.native

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

  def write(chunk: Uint8Array | String, callback: js.Function1[Error, Any] = js.native): Boolean = js.native
  def write(chunk: String, encoding: String): Boolean                                            = js.native
  def write(chunk: String, encoding: String, callback: js.Function1[Error, Any]): Boolean        = js.native
}

/**
  * Writable Companion
  */
object Writable {

  /**
    * Writable Events
    */
  implicit class WritableEvents[T <: Writable](val writable: T) extends AnyVal {

    /**
      * Emitted when the stream and any of its underlying resources (a file descriptor, for example) have been closed.
      * The event indicates that no more events will be emitted, and no further computation will occur.
      */
    @inline
    def onClose(listener: () => Any): writable.type = writable.on("close", listener)

    /**
      * If a stream.write(chunk) call returns false, then the 'drain' event will indicate when it is appropriate
      * to begin writing more data to the stream.
      */
    @inline
    def onDrain(listener: () => Any): writable.type = writable.on("drain", listener)

    /**
      * Emitted if there was an error when writing or piping data.
      */
    @inline
    def onError(listener: Error => Any): writable.type = writable.on("error", listener)

    /**
      * When the stream.end() method has been called, and all data has been flushed to the underlying system,
      * this event is emitted.
      */
    @inline
    def onFinish(listener: () => Any): writable.type = writable.on("finish", listener)

    /**
      * This is emitted whenever the stream.pipe() method is called on a readable stream, adding this writable to
      * its set of destinations.
      */
    @inline
    def onPipe(listener: Readable => Any): writable.type = writable.on("pipe", listener)

    /**
      * This is emitted whenever the stream.unpipe() method is called on a readable stream, removing this writable
      * from its set of destinations.
      */
    @inline
    def onUnpipe(listener: Readable => Any): writable.type = writable.on("unpipe", listener)

  }

  /**
    * Writable Extensions
    */
  implicit final class WritableExtensions[T <: Writable](val writable: T) extends AnyVal {

    @inline
    def endFuture(chunk: Buffer): Future[Unit] = promiseWithError0[Error](writable.end(chunk, _))

    @inline
    def endFuture(chunk: String, encoding: String = null): Future[Unit] = {
      promiseWithError0[Error](writable.end(chunk, encoding, _))
    }

    @inline
    def endFuture(): Future[Unit] = promiseWithError0[Error](writable.end)

    @inline
    def writeFuture(chunk: Uint8Array): Future[Unit] = {
      promiseWithError0[Error](writable.write(chunk, _))
    }

    @inline
    def writeFuture(chunk: String, encoding: String = null): Future[Unit] = {
      promiseWithError0[Error](writable.write(chunk, encoding, _))
    }
  }

}

/**
  * Represents a chunk of data
  * @param chunk    the chunk of data
  * @param encoding the data's optional encoding
  */
class Chunk(val chunk: Buffer | String, val encoding: js.UndefOr[String] = js.undefined) extends js.Object

class WritableOptions(val highWaterMark: js.UndefOr[Int] = js.undefined,
                      val decodeStrings: js.UndefOr[Boolean] = js.undefined,
                      val defaultEncoding: js.UndefOr[String] = js.undefined,
                      val objectMode: js.UndefOr[Boolean] = js.undefined,
                      val emitClose: js.UndefOr[Boolean] = js.undefined,
                      val write: js.UndefOr[js.Function] = js.undefined,
                      val writev: js.UndefOr[js.Function] = js.undefined,
                      val destroy: js.UndefOr[js.Function] = js.undefined,
                      val `final`: js.UndefOr[js.Function] = js.undefined,
                      val autoDestroy: js.UndefOr[Boolean] = js.undefined)
    extends js.Object
