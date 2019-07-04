package io.scalajs.dom.html

import scala.scalajs.js
import scala.scalajs.js.Array

/**
  * phaser package object
  * @author lawrence.daniels@gmail.com
  */
package object phaser {

  type ButtonCode = Int

  /**
    * Group Extensions
    * @author lawrence.daniels@gmail.com
    */
  final implicit class GroupExtensions[T](val group: Group[T]) extends AnyVal {

    /**
      * Retrieves an array of all living entities
      * @param context the given callback context
      * @return the array of all living entities
      */
    @inline
    def findAlive(context: js.Any = group): Array[T] = {
      val items = js.Array[T]()
      group.foreachAlive(items.append(_), context)
      items
    }

    @inline
    def foreach(callback: T => Any, context: js.Any = group): Unit = group.forEach(callback, context)

    @inline
    def foreachAlive(callback: T => Any, context: js.Any = group): Unit = group.forEachAlive(callback, context)

    @inline
    def foreachDead(callback: T => Any, context: js.Any = group): Unit = group.forEachDead(callback, context)

  }

}
