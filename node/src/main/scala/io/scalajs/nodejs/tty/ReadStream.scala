package io.scalajs.nodejs.tty

import io.scalajs.nodejs.{FileDescriptor, NodeOptions}
import io.scalajs.nodejs.net.Socket

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * The tty.ReadStream class is a subclass of net.Socket that represents the readable side of a TTY.
  * In normal circumstances process.stdin will be the only tty.ReadStream instance in a Node.js process
  * and there should be no reason to create additional instances.
  * @version 7.4.0
  * @see https://nodejs.org/api/tty.html
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("tty", "ReadStream")
class ReadStream(fd: FileDescriptor, options: NodeOptions = js.native) extends Socket {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * A boolean that is true if the TTY is currently configured to operate as a raw device. Defaults to false.
    * @since 0.7.7
    */
  var isRaw: Boolean = js.native

  /**
    * Indicates whether the stream is a TTY
    */
  def isTTY: Boolean = js.native

  /**
    * Turns on/off raw mode
    * @param mode mode If true, configures the tty.ReadStream to operate as a raw device. If false, configures the
    *             tty.ReadStream to operate in its default mode. The readStream.isRaw property will be set to the
    *             resulting mode.
    * @since 0.7.7
    */
  def setRawMode(mode: Boolean): Unit = js.native

}
