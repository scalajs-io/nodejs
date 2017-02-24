package io.scalajs.nodejs
package fs

import io.scalajs.nodejs.events.IEventEmitter

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * fs.FSWatcher - Objects returned from fs.watch() are of this type.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait FSWatcher extends IEventEmitter {

  /**
    * Stop watching for changes on the given fs.FSWatcher.
    * @example watcher.close()
    * @since 0.5.8
    */
  def close(): Unit = js.native

}

/**
  * File System Watcher Companion
  * @author lawrence.daniels@gmail.com
  */
object FSWatcher {

  /**
    * File System Watcher Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class FSWatcherExtensions(val watcher: FSWatcher) extends AnyVal {

    /**
      * Emitted when something changes in a watched directory or file. See more details in fs.watch().
      *
      * The filename argument may not be provided depending on operating system support. If filename is provided,
      * it will be provided as a Buffer if fs.watch() is called with it's encoding option set to 'buffer', otherwise
      * filename will be a string.
      * @param listener the event handler
      *                 <ul>
      *                 <li>event: String - The type of fs change</li>
      *                 <li>filename: String> | Buffer - The filename that changed (if relevant/available)</li>
      *                 </ul>
      * @since 0.5.8
      */
    @inline
    def onChange(listener: (String, js.Any) => Any): watcher.type = watcher.on("change", listener)

    /**
      * Emitted when an error occurs.
      * @param listener the event handler
      * @since 0.5.8
      */
    @inline
    def onError(listener: Error => Any): watcher.type = watcher.on("error", listener)

  }

}

/**
  * FS Watcher Options
  * @param encoding   Specifies the character encoding to be used for the filename passed to the listener (default: "utf8")
  * @param persistent Indicates whether the process should continue to run as long as files are being watched (default: true)
  * @param recursive  Indicates whether all subdirectories should be watched, or only the current directory.
  *                   The applies when a directory is specified, and only on supported platforms (See Caveats) (default: false)
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class FSWatcherOptions(val encoding: js.UndefOr[String] = js.undefined,
                       val persistent: js.UndefOr[Boolean] = js.undefined,
                       val recursive: js.UndefOr[Boolean] = js.undefined)
  extends js.Object