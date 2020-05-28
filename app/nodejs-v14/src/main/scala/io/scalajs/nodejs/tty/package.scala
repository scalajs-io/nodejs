package io.scalajs.nodejs

/**
  * tty package object
  */
package object tty {

  /**
    * Write Stream Events
    * @param stream the given [[WriteStream stream]]
    */
  implicit final class WriteStreamExtensions[W <: WriteStream](private val stream: W) extends AnyVal {

    /**
      * The 'resize' event is emitted whenever either of the writeStream.columns or writeStream.rows properties have
      * changed. No arguments are passed to the listener callback when called.
      * @param listener the given event handler
      * @since 0.7.7
      */
    @inline def onResize(listener: () => Any): W = stream.on("resize", listener)
  }
}
