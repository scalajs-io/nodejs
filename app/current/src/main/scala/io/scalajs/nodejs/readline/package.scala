package io.scalajs.nodejs

package object readline {
  implicit final class InterfaceExtensions[T <: Interface](private val readline: T) extends AnyVal {

    /**
      * Emitted when close() is called. Also emitted when the input stream receives its 'end' event.
      * The Interface instance should be considered "finished" once this is emitted. For example, when
      * the input stream receives {{{ ^D }}}, respectively known as EOT.
      */
    @inline
    def onClose(callback: () => Any): T = readline.on("close", callback)

    /**
      * Emitted whenever the input stream receives an end of line (\n, \r, or \r\n), usually received when
      * the user hits enter, or return. This is a good hook to listen for user input.
      */
    @inline
    def onLine(callback: String => Any): T = readline.on("line", callback)

    /**
      * Emitted whenever the input stream is paused. Also emitted whenever the input stream is not paused
      * and receives the SIGCONT event. (See events SIGTSTP and SIGCONT)
      */
    @inline
    def onPause(callback: () => Any): T = readline.on("pause", callback)

    /**
      * Emitted whenever the input stream is resumed.
      */
    @inline
    def onResume(callback: () => Any): T = readline.on("resume", callback)

    /**
      * Emitted whenever the input stream is sent to the background with {{{ ^Z }}}, respectively known as SIGTSTP,
      * and then continued with fg(1). This event only emits if the stream was not paused before sending the
      * program to the background.
      */
    @inline
    def onSIGCONT(callback: () => Any): T = readline.on("SIGCONT", callback)

    /**
      * Emitted whenever the input stream receives a {{{ ^C }}}, respectively known as SIGINT. If there is no
      * SIGINT event listener present when the input stream receives a SIGINT, pause will be triggered.
      */
    @inline
    def onSIGINT(callback: () => Any): T = readline.on("SIGINT", callback)

    /**
      * Emitted whenever the input stream receives a {{{ ^Z }}}, respectively known as SIGTSTP. If there is no
      * SIGTSTP event listener present when the input stream receives a SIGTSTP, the program will be sent
      * to the background. When the program is resumed with fg, the 'pause' and SIGCONT events will be emitted.
      * You can use either to resume the stream. The 'pause' and SIGCONT events will not be triggered if the
      * stream was paused before the program was sent to the background.
      */
    @inline
    def onSIGTSTP(callback: () => Any): T = readline.on("SIGTSTP", callback)
  }
}
