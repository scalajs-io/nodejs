package io.scalajs.npm

import io.scalajs.nodejs.fs.Stats
import io.scalajs.util.ScalaJsHelper.{futureCallbackA1, futureCallbackA3}

import scala.concurrent.Promise
import scala.scalajs.js
import scala.scalajs.js.Dictionary

/**
  * watch package object
  * @author lawrence.daniels@gmail.com
  */
package object watch {

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
    def createMonitorFuture(root: String, options: WatchOptions = null): Promise[Monitor] = {
      futureCallbackA1[Monitor](watch.createMonitor(root, options, _))
    }

    /**
      * The first argument is the directory root you want to watch.
      * @param root    the directory root you want to watch
      * @param options the file watching options
      * @example watch.watchTree('/home/mikeal', function (f, curr, prev) { ... })
      */
    @inline
    def watchTreeFuture(root: String, options: WatchOptions = null): Promise[(Dictionary[Stats], Stats, Stats)] = {
      futureCallbackA3[js.Dictionary[Stats], Stats, Stats](watch.createMonitor(root, options, _))
    }

  }

}
