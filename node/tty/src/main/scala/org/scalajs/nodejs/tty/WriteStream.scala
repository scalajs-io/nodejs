package org.scalajs.nodejs.tty

import org.scalajs.nodejs.net
import org.scalajs.nodejs.net.Socket

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * The tty.WriteStream class is a subclass of net.Socket that represents the writable side of a TTY.
  * In normal circumstances, process.stdout and process.stderr will be the only tty.WriteStream instances
  * created for a Node.js process and there should be no reason to create additional instances.
  * @since 0.5.8
  */
@js.native
trait WriteStream extends Socket {

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
    * A number specifying the number of rows the TTY currently has. This property is updated whenever the
    * 'resize' event is emitted.
    * @see [[WriteStreamEvents.onResize]]
    * @since 0.7.7
    */
  def rows: Int = js.native

  /**
    * Indicates whether the stream is a TTY
    */
  def isTTY: Boolean = js.native

}

/**
  * Write Stream class representation
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSName("WriteStream")
object WriteStream extends WriteStreamClass
