package io.scalajs.npm.watch

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * watch - Utilities for watching file trees.
  * @version 0.18.0
  * @see https://www.npmjs.com/package/watch
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Watch extends js.Object {

  /**
    * This function creates an EventEmitter that gives notifications for different changes that happen to the file and
    * directory tree under the given root argument.
    * @param root     The directory root you want to monitor.
    * @param options  The options object is passed to watch.watchTree.
    * @param callback The callback receives the monitor object.
    * @example watch.createMonitor(root, [options,] callback)
    */
  def createMonitor(root: String, options: WatchOptions, callback: js.Function): Unit = js.native

  /**
    * This function creates an EventEmitter that gives notifications for different changes that happen to the file and
    * directory tree under the given root argument.
    * @param root     The directory root you want to monitor.
    * @param callback The callback receives the monitor object.
    * @example watch.createMonitor(root, [options,] callback)
    */
  def createMonitor(root: String, callback: js.Function): Unit = js.native

  /**
    * Unwatch a previously watched directory root using watch.watchTree.
    * @param root the directory root you want to stop watching
    * @example watch.unwatchTree(root)
    */
  def unwatchTree(root: String): Unit = js.native

  /**
    * Walks a directory tree?
    * @param root     The directory root you want to walk.
    * @param options  The options object is passed to watch.watchTree.
    * @param callback The callback receives the monitor object.
    * @example watch.walk(dir, options, callback)
    */
  def walk(root: String, options: WatchOptions, callback: js.Function): Unit = js.native

  /**
    * Walks a directory tree?
    * @param root     The directory root you want to walk.
    * @param callback The callback receives the monitor object.
    * @example watch.walk(dir, options, callback)
    */
  def walk(root: String, callback: js.Function): Unit = js.native

  /**
    * The first argument is the directory root you want to watch.
    * @param root     the directory root you want to watch
    * @param options  the file watching options
    * @param callback the result callback
    * @example watch.watchTree(root, [options,] callback)
    */
  def watchTree(root: String, options: WatchOptions, callback: js.Function): Unit = js.native

  /**
    * The first argument is the directory root you want to watch.
    * @param root     the directory root you want to watch
    * @param callback the result callback
    * @example watch.watchTree(root, [options,] callback)
    */
  def watchTree(root: String, callback: js.Function): Unit = js.native

}

/**
  * Watch Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("watch", JSImport.Namespace)
object Watch extends Watch