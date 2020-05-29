package io.scalajs.nodejs
package fs

import _root_.net.exoego.scalajs.types.util.Factory
import com.thoughtworks.enableIf
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

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs14)
  def ref(): FSWatcher = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs14)
  def unref(): FSWatcher = js.native
}

/**
  * A successful call to fs.watchFile() method will return a new fs.StatWatcher object.
  */
@js.native
trait FSStatWatcher extends IEventEmitter {
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs14)
  def ref(): FSStatWatcher = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs14)
  def unref(): FSStatWatcher = js.native
}

@Factory
trait FSWatcherOptions extends js.Object {

  /** Specifies the character encoding to be used for the filename passed to the listener (default: "utf8") */
  var encoding: js.UndefOr[String] = js.undefined

  /** Indicates whether the process should continue to run as long as files are being watched (default: true) */
  var persistent: js.UndefOr[Boolean] = js.undefined

  /** Indicates whether all subdirectories should be watched, or only the current directory.
    * The applies when a directory is specified, and only on supported platforms (See Caveats) (default: false)
    */
  var recursive: js.UndefOr[Boolean] = js.undefined
}
