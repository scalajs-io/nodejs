package com.github.ldaniels528.meansjs.nodejs.watch

import com.github.ldaniels528.meansjs.nodejs.{NodeModule, NodeRequire}
import com.github.ldaniels528.meansjs.nodejs.fs.Stats
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * watch - Utilities for watching file trees.
  * @version 0.18.0
  * @see https://www.npmjs.com/package/watch
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Watch extends NodeModule {

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
    * @param root The directory root you want to walk.
    * @param options  The options object is passed to watch.watchTree.
    * @param callback The callback receives the monitor object.
    * @example watch.walk(dir, options, callback)
    */
  def walk(root: String, options: WatchOptions, callback: js.Function): Unit = js.native

  /**
    * Walks a directory tree?
    * @param root The directory root you want to walk.
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
  * Watch Companion
  * @author lawrence.daniels@gmail.com
  */
object Watch {

  /**
    * Convenience method for retrieving the 'watch' module
    * @param require the implicit [[NodeRequire require function]]
    * @return the Watch instance
    */
  def apply()(implicit require: NodeRequire) = require[Watch]("watch")
  
  /**
    * Watch Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class WatchExtensions(val watch: Watch) extends AnyVal {

    /**
      * This function creates an EventEmitter that gives notifications for different changes that happen to the file and
      * directory tree under the given root argument.
      * @param root    The directory root you want to monitor.
      * @param options The options object is passed to watch.watchTree.
      * @example watch.createMonitor('/home/mikeal', function (monitor) { ... })
      */
    @inline
    def createMonitorFuture(root: String, options: WatchOptions = null) = {
      futureCallbackA1[Monitor](watch.createMonitor(root, options, _))
    }

    /**
      * The first argument is the directory root you want to watch.
      * @param root    the directory root you want to watch
      * @param options the file watching options
      * @example watch.watchTree('/home/mikeal', function (f, curr, prev) { ... })
      */
    @inline
    def watchTreeFuture(root: String, options: WatchOptions = null) = {
      futureCallbackA3[js.Dictionary[Stats], Stats, Stats](watch.createMonitor(root, options, _))
    }

  }

}