package io.scalajs.nodejs.fs

import io.scalajs.nodejs.FileDescriptor
import io.scalajs.nodejs.stream.Readable

import scala.scalajs.js

/**
  * fs.ReadStream - ReadStream is a Readable Stream.
  * @see https://nodejs.org/api/stream.html#stream_class_stream_readable
  */
@js.native
trait ReadStream extends Readable {

  /**
    * The path to the file the stream is reading from as specified in the first argument to fs.createReadStream().
    * If path is passed as a string, then readStream.path will be a string. If path is passed as a Buffer, then
    * readStream.path will be a Buffer.
    */
  def path: js.Any = js.native

}

/**
  * Read Stream Companion
  * @author lawrence.daniels@gmail.com
  */
object ReadStream {

  /**
    * Read Stream Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class ReadStreamExtensions(val stream: ReadStream) extends AnyVal {

    /**
      * Emitted when the ReadStream's underlying file descriptor has been closed using the fs.close() method.
      * @param listener the event handler
      * @since 0.1.93
      */
    @inline
    def onClose(listener: () => Any): stream.type = stream.on("close", listener)

    /**
      * Emitted when the ReadStream's file is opened.
      * @param listener the event handler
      *                 <ul>
      *                 <li>fd: Integer - file descriptor used by the ReadStream.</li>
      *                 </ul>
      * @since 0.1.93
      */
    @inline
    def onOpen(listener: FileDescriptor => Any): stream.type = stream.on("open", listener)

  }

}
