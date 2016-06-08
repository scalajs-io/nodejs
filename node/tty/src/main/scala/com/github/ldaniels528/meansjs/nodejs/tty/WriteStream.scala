package com.github.ldaniels528.meansjs.nodejs.tty

import com.github.ldaniels528.meansjs.nodejs.net
import com.github.ldaniels528.meansjs.nodejs.net.FileDescriptor

import scala.scalajs.js

/**
  * The tty.WriteStream class is a subclass of net.Socket that represents the writable side of a TTY.
  * In normal circumstances, process.stdout and process.stderr will be the only tty.WriteStream instances
  * created for a Node.js process and there should be no reason to create additional instances.
  * @since 0.5.8
  */
@js.native
trait WriteStream extends net.Socket {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * A number specifying the number of columns the TTY currently has. This property is updated whenever
    * the 'resize' event is emitted.
    * @see [[com.github.ldaniels528.meansjs.nodejs.tty.WriteStream.WriteStreamEvents.onResize]]
    * @since 0.7.7
    */
  def columns: Int = js.native

  /**
    * A number specifying the number of rows the TTY currently has. This property is updated whenever the
    * 'resize' event is emitted.
    * @see [[com.github.ldaniels528.meansjs.nodejs.tty.WriteStream.WriteStreamEvents.onResize]]
    * @since 0.7.7
    */
  def rows: Int = js.native

}

/**
  * Write Stream Companion
  * @author lawrence.daniels@gmail.com
  */
object WriteStream {

  /**
    * Write Stream Events
    * @param stream the given [[WriteStream stream]]
    */
  implicit class WriteStreamEvents(val stream: WriteStream) extends AnyVal {

    /**
      * The 'resize' event is emitted whenever either of the writeStream.columns or writeStream.rows properties have
      * changed. No arguments are passed to the listener callback when called.
      * @param listener the given event handler
      * @since 0.7.7
      */
    def onResize(listener: () => Any) = stream.on("resize", listener)

  }

}