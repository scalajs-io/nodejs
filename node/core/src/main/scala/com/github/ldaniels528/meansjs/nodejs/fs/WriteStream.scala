package com.github.ldaniels528.meansjs.nodejs.fs

import com.github.ldaniels528.meansjs.nodejs.events.EventEmitter

import scala.scalajs.js

/**
  * WriteStream is a Readable Stream.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait WriteStream extends EventEmitter {

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
  implicit class WriteStreamExtensions(val rs: WriteStream) extends AnyVal {

    /**
      * Emitted when the WriteStream's file is opened.
      * callback: fd <Integer> - file descriptor used by the WriteStream.
      */
    def onOpen(listener: js.Function1[Integer, Unit]) = rs.on("open", listener)

  }

}