package com.github.ldaniels528.meansjs.nodejs.fs

import com.github.ldaniels528.meansjs.nodejs.events.EventEmitter

import scala.scalajs.js

/**
  * File System Watcher
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait FSWatcher extends EventEmitter {

  /**
    * Stop watching for changes on the given fs.[[FSWatcher]].
    * @example watcher.close()
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
      * Emitted when something changes in a watched directory or file. See more details in [[Fs.watch() fs.watch()]].
      *
      * The filename argument may not be provided depending on operating system support. If filename is provided,
      * it will be provided as a Buffer if fs.watch() is called with it's encoding option set to 'buffer', otherwise
      * filename will be a string.
      */
    def onChange(listener: js.Function) = watcher.on("change", listener)

    /**
      * Emitted when an error occurs.
      */
    def onError(listener: js.Function) = watcher.on("error", listener)

  }

}