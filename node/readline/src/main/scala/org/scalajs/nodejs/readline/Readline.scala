package org.scalajs.nodejs.readline

import org.scalajs.nodejs.{NodeModule, NodeRequire}
import org.scalajs.nodejs.events.EventEmitter
import org.scalajs.nodejs.events.EventEmitter

import scala.scalajs.js

/**
  * Readline allows reading of a stream (such as process.stdin) on a line-by-line basis.
  * To use this module, do require('readline').
  * Note that once you've invoked this module, your Node.js program will not terminate until you've closed the interface.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Readline extends NodeModule with EventEmitter {

  /**
    * Clears current line of given TTY stream in a specified direction. <tt>dir</tt> should have one of following values:
    * <ul>
    * <li>-1 - to the left from cursor</li>
    * <li>0 - the entire line</li>
    * <li>1 - to the right from cursor</li>
    * </ul>
    * @example readline.clearLine(stream, dir)
    */
  def clearLine(stream: js.Any, dir: Int): Unit = js.native

  /**
    * Clears the screen from the current position of the cursor down.
    * @example readline.clearScreenDown(stream)
    */
  def clearScreenDown(stream: js.Any): Unit = js.native

  /**
    * Creates a readline Interface instance.
    * @example readline.createInterface(options)
    */
  def createInterface(options: ReadlineOptions): Interface = js.native

  /**
    * Move cursor to the specified position in a given TTY stream.
    * @example readline.cursorTo(stream, x, y)
    */
  def cursorTo(stream: js.Any, x: Int, y: Int): Unit = js.native

  /**
    * Move cursor relative to it's current position in a given TTY stream.
    * @example readline.moveCursor(stream, dx, dy)
    */
  def moveCursor(stream: js.Any, dx: Int, dy: Int): Unit = js.native

}

/**
  * Readline Companion
  * @author lawrence.daniels@gmail.com
  */
object Readline {

  /**
    * Convenience method for retrieving the readline module
    * @param require the implicit [[NodeRequire require function]]
    * @return the Readline instance
    */
  def apply()(implicit require: NodeRequire) = require[Readline]("readline")

}