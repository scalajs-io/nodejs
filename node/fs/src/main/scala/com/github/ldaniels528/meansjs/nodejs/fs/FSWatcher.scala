package com.github.ldaniels528.meansjs.nodejs.fs

import com.github.ldaniels528.meansjs.nodejs.events.EventEmitter

import scala.scalajs.js

/**
  * fs.FSWatcher - Objects returned from fs.watch() are of this type.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait FSWatcher extends EventEmitter {

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
    @inline def onChange(listener: (String, js.Any) => Any) = watcher.on("change", listener)

    /**
      * Emitted when an error occurs.
      * @param listener the event handler
      * @since 0.5.8
      */
    @inline def onError(listener: js.Error => Any) = watcher.on("error", listener)

  }

}