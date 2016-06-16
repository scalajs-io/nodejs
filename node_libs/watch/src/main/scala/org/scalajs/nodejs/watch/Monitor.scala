package org.scalajs.nodejs.watch

import org.scalajs.nodejs.events.EventEmitter
import org.scalajs.nodejs.fs.Stats
import org.scalajs.nodejs.events.EventEmitter
import org.scalajs.nodejs.fs.Stats

import scala.scalajs.js

/**
  * Monitor
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Monitor extends EventEmitter {

  def files: js.Dictionary[Stats] = js.native

  def stop(): Unit = js.native

}

/**
  * Monitor Companion
  * @author lawrence.daniels@gmail.com
  */
object Monitor {

  /**
    * Monitor Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class MonitorExtensions(val monitor: Monitor) extends AnyVal {

    /**
      * A file has been changed. Three arguments, the filename, the current stat object, and the previous stat object.
      * @example monitor.on("changed", function (f, curr, prev) { ... })
      */
    def onChanged(callback: (String, Stats, Stats) => Any) = monitor.on("changed", callback)

    /**
      * New file has been created. Two arguments, the filename and the stat object.
      * @example monitor.on("created", function (f, stat) { ... })
      */
    def onCreated(callback: (String, Stats) => Any) = monitor.on("created", callback)

    /**
      * A file has been moved or deleted. Two arguments, the filename and the stat object for the fd.
      * @example monitor.on("removed", function (f, stat) { ... })
      */
    def onRemoved(callback: (String, Stats) => Any) = monitor.on("removed", callback)

  }

}