package io.scalajs.nodejs.readline

import io.scalajs.nodejs.events.IEventEmitter

import scala.scalajs.js

/**
  * Readline Interface
  * @version 7.4.0
  * @see https://nodejs.org/api/readline.html#readline_class_interface
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Interface extends IEventEmitter {

  /**
    * Closes the Interface instance, relinquishing control on the input and output streams.
    * The 'close' event will also be emitted.
    * @example rl.close()
    */
  def close(): Unit = js.native

  /**
    * Pauses the readline input stream, allowing it to be resumed later if needed.
    * <b>Note</b>: that this doesn't immediately pause the stream of events. Several events may be emitted
    * after calling pause, including line.
    * @example rl.pause()
    */
  def pause(): Unit = js.native

  /**
    * Readies readline for input from the user, putting the current setPrompt options on a new line, giving the user
    * a new spot to write. Set preserveCursor to true to prevent the cursor placement being reset to 0.
    * This will also resume the input stream used with createInterface if it has been paused.
    * If output is set to null or undefined when calling createInterface, the prompt is not written.
    * @example rl.prompt([preserveCursor])
    */
  def prompt(preserveCursor: Boolean): Unit = js.native

  /**
    * Readies readline for input from the user, putting the current setPrompt options on a new line, giving the user
    * a new spot to write. Set preserveCursor to true to prevent the cursor placement being reset to 0.
    * This will also resume the input stream used with createInterface if it has been paused.
    * If output is set to null or undefined when calling createInterface, the prompt is not written.
    * @example rl.prompt([preserveCursor])
    */
  def prompt(): Unit = js.native

  /**
    * Prepends the prompt with query and invokes callback with the user's response. Displays the query to the user,
    * and then invokes callback with the user's response after it has been typed.
    * This will also resume the input stream used with createInterface if it has been paused.
    * If output is set to null or undefined when calling createInterface, nothing is displayed.
    * @example rl.question(query, callback)
    */
  def question(query: String, callback: js.Function): Unit = js.native

  /**
    * Resumes the readline input stream.
    * @example rl.resume()
    */
  def resume(): Unit = js.native

  /**
    * Sets the prompt, for example when you run node on the command line, you see > , which is Node.js's prompt.
    * @example rl.setPrompt(prompt)
    */
  def setPrompt(prompt: String): Unit = js.native

  /**
    * Writes data to output stream, unless output is set to null or undefined when calling createInterface.
    * key is an object literal to represent a key sequence; available if the terminal is a TTY.
    * This will also resume the input stream if it has been paused.
    * @example rl.write(data[, key])
    */
  def write(data: String, key: js.Any): Unit = js.native

  /**
    * Writes data to output stream, unless output is set to null or undefined when calling createInterface.
    * key is an object literal to represent a key sequence; available if the terminal is a TTY.
    * This will also resume the input stream if it has been paused.
    * @example rl.write(data[, key])
    */
  def write(data: String): Unit = js.native

}

/**
  * Readline Interface Companion
  * @author lawrence.daniels@gmail.com
  */
object Interface {

  /**
    * Readline Interface Events
    * @param readline the given [[Interface Readline Interface]]
    */
  implicit class ReadlineEvents(val readline: Interface) extends AnyVal {

    /**
      * Emitted when close() is called. Also emitted when the input stream receives its 'end' event.
      * The Interface instance should be considered "finished" once this is emitted. For example, when
      * the input stream receives {{{ ^D }}}, respectively known as EOT.
      */
    @inline
    def onClose(callback: () => Any) = readline.on("close", callback)

    /**
      * Emitted whenever the input stream receives an end of line (\n, \r, or \r\n), usually received when
      * the user hits enter, or return. This is a good hook to listen for user input.
      */
    @inline
    def onLine(callback: String => Any) = readline.on("line", callback)

    /**
      * Emitted whenever the input stream is paused. Also emitted whenever the input stream is not paused
      * and receives the SIGCONT event. (See events SIGTSTP and SIGCONT)
      */
    @inline
    def onPause(callback: js.Function) = readline.on("pause", callback)

    /**
      * Emitted whenever the input stream is resumed.
      */
    @inline
    def onResume(callback: js.Function) = readline.on("resume", callback)

    /**
      * Emitted whenever the input stream is sent to the background with {{{ ^Z }}}, respectively known as SIGTSTP,
      * and then continued with fg(1). This event only emits if the stream was not paused before sending the
      * program to the background.
      */
    @inline
    def onSIGCONT(callback: js.Function) = readline.on("SIGCONT", callback)

    /**
      * Emitted whenever the input stream receives a {{{ ^C }}}, respectively known as SIGINT. If there is no
      * SIGINT event listener present when the input stream receives a SIGINT, pause will be triggered.
      */
    @inline
    def onSIGINT(callback: js.Function) = readline.on("SIGINT", callback)

    /**
      * Emitted whenever the input stream receives a {{{ ^Z }}}, respectively known as SIGTSTP. If there is no
      * SIGTSTP event listener present when the input stream receives a SIGTSTP, the program will be sent
      * to the background. When the program is resumed with fg, the 'pause' and SIGCONT events will be emitted.
      * You can use either to resume the stream. The 'pause' and SIGCONT events will not be triggered if the
      * stream was paused before the program was sent to the background.
      */
    @inline
    def onSIGTSTP(callback: js.Function) = readline.on("SIGTSTP", callback)

  }

}