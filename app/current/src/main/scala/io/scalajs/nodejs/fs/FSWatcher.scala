package io.scalajs.nodejs
package fs

import io.scalajs.nodejs.events.IEventEmitter

import scala.scalajs.js

/**
  * fs.FSWatcher - Objects returned from fs.watch() are of this type.
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
  * FS Watcher Options
  * @param encoding   Specifies the character encoding to be used for the filename passed to the listener (default: "utf8")
  * @param persistent Indicates whether the process should continue to run as long as files are being watched (default: true)
  * @param recursive  Indicates whether all subdirectories should be watched, or only the current directory.
  *                   The applies when a directory is specified, and only on supported platforms (See Caveats) (default: false)
  */
class FSWatcherOptions(var encoding: js.UndefOr[String] = js.undefined,
                       var persistent: js.UndefOr[Boolean] = js.undefined,
                       var recursive: js.UndefOr[Boolean] = js.undefined
) extends js.Object
