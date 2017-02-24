package io.scalajs.nodejs
package fs

import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.stream.Writable
import io.scalajs.util.PromiseHelper._

import scala.concurrent.Promise
import scala.scalajs.js
import scala.scalajs.js.|

/**
  * fs.WriteStream - WriteStream is a Writable Stream.
  * @see https://nodejs.org/api/fs.html#fs_class_fs_writestream
  */
@js.native
trait WriteStream extends Writable {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * The number of bytes written so far. Does not include data that is still queued for writing.
    */
  def bytesWritten: Double = js.native

  /**
    * The path to the file the stream is writing to as specified in the first argument to fs.createWriteStream().
    * If path is passed as a string, then writeStream.path will be a string. If path is passed as a Buffer, then
    * writeStream.path will be a Buffer.
    */
  def path: Buffer | String = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Undocumented method
    * @see https://github.com/nodejs/node-v0.x-archive/blob/cfcb1de130867197cbc9c6012b7e84e08e53d032/lib/fs.js#L1597-L1620
    */
  def close(callback: js.Function1[Unit, Any]): Unit = js.native

}

/**
  * Write Stream Companion
  * @author lawrence.daniels@gmail.com
  */
object WriteStream {

  /**
    * Write Stream Events
    * @author lawrence.daniels@gmail.com
    */
  implicit class WriteStreamEvents(val stream: WriteStream) extends AnyVal {

    /**
      * Emitted when the WriteStream's underlying file descriptor has been closed using the fs.close() method.
      * @param listener the event handler
      * @since 0.1.93
      */
    @inline
    def onClose(listener: () => Any): stream.type = stream.on("close", listener)

    /**
      * Emitted when the WriteStream's file is opened.
      * @param listener the event handler
      *                 <ul>
      *                 <li>fd: Integer - file descriptor used by the ReadStream.</li>
      *                 </ul>
      * @since 0.1.93
      */
    @inline
    def onOpen(listener: FileDescriptor => Any): stream.type = stream.on("open", listener)

  }

  /**
    * Write Stream Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class WriteStreamExtensions(val stream: WriteStream) extends AnyVal {

    @inline
    def closeAsync: Promise[Unit] = promiseCallback1[Unit](stream.close)

  }

}