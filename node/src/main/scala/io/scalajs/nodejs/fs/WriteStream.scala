package io.scalajs.nodejs.fs

import io.scalajs.nodejs.stream.Writable
import io.scalajs.nodejs.FileDescriptor
import io.scalajs.nodejs.stream.Writable

import scala.scalajs.js

/**
  * fs.WriteStream - WriteStream is a Writable Stream.
  * @version 6.2.1
  */
@js.native
trait WriteStream extends Writable {

  /**
    * The number of bytes written so far. Does not include data that is still queued for writing.
    */
  def bytesWritten: Double = js.native

  /**
    * The path to the file the stream is writing to as specified in the first argument to fs.createWriteStream().
    * If path is passed as a string, then writeStream.path will be a string. If path is passed as a Buffer, then
    * writeStream.path will be a Buffer.
    */
  def path: js.Any = js.native

}

/**
  * Write Stream Companion
  * @author lawrence.daniels@gmail.com
  */
object WriteStream {

  /**
    * Write Stream Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class WriteStreamExtensions(val stream: WriteStream) extends AnyVal {

    /**
      * Emitted when the WriteStream's underlying file descriptor has been closed using the fs.close() method.
      * @param listener the event handler
      * @since 0.1.93
      */
    @inline def onClose(listener: () => Any) = stream.on("close", listener)

    /**
      * Emitted when the WriteStream's file is opened.
      * @param listener the event handler
      *                 <ul>
      *                 <li>fd: Integer - file descriptor used by the ReadStream.</li>
      *                 </ul>
      * @since 0.1.93
      */
    @inline def onOpen(listener: FileDescriptor => Any) = stream.on("open", listener)

  }

}