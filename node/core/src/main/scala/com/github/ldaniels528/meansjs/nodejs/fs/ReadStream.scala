package com.github.ldaniels528.meansjs.nodejs.fs

import com.github.ldaniels528.meansjs.nodejs.events.EventEmitter

import scala.scalajs.js

/**
  * ReadStream is a Readable Stream.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ReadStream extends EventEmitter {

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
  implicit class ReadStreamExtensions(val rs: ReadStream) extends AnyVal {

    /**
      * Emitted when the ReadStream's file is opened.
      * callback: fd <Integer> - file descriptor used by the ReadStream.
      */
    @inline
    def onOpen(listener: js.Function1[Integer, Unit]) = rs.on("open", listener)

  }

}
