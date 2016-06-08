package com.github.ldaniels528.meansjs.nodejs

/**
  * tty package object
  * @author lawrence.daniels@gmail.com
  */
package object tty {

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
