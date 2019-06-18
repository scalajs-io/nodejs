package io.scalajs.nodejs.tty

import io.scalajs.nodejs.FileDescriptor
import io.scalajs.nodejs.net.Socket

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * The tty.WriteStream class is a subclass of net.Socket that represents the writable side of a TTY.
  * In normal circumstances, process.stdout and process.stderr will be the only tty.WriteStream instances
  * created for a Node.js process and there should be no reason to create additional instances.
  * @see https://nodejs.org/api/tty.html
  * @since 0.5.8
  */
@js.native
@JSImport("tty", "WriteStream")
class WriteStream(fd: FileDescriptor) extends Socket {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * A number specifying the number of columns the TTY currently has. This property is updated whenever
    * the 'resize' event is emitted.
    * @see [[WriteStreamEvents.onResize]]
    * @since 0.7.7
    */
  def columns: Int = js.native

  /**
    * Indicates whether the stream is a TTY
    */
  def isTTY: Boolean = js.native

  /**
    * A number specifying the number of rows the TTY currently has. This property is updated whenever the
    * 'resize' event is emitted.
    * @see [[WriteStreamEvents.onResize]]
    * @since 0.7.7
    */
  def rows: Int = js.native

}