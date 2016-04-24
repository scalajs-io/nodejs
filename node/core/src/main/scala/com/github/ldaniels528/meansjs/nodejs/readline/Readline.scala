package com.github.ldaniels528.meansjs.nodejs.readline

import com.github.ldaniels528.meansjs.nodejs.NodeModule

import scala.scalajs.js

/**
  * Readline Node Module
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Readline extends NodeModule {

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
