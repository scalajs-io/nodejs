package org.scalajs.browser

import scala.scalajs.js

/**
  * phaser package object
  * @author lawrence.daniels@gmail.com
  */
package object phaser {

  /**
    * Group Extensions
    * @author lawrence.daniels@gmail.com
    */
  final implicit class GroupExtensions[T](val group: Phaser.Group[T]) extends AnyVal {

    /**
      * Retrieves an array of all living entities
      * @param context the given callback context
      * @return the array of all living entities
      */
    def findAlive(context: Any = group) = {
      val items = js.Array[T]()
      group.foreachAlive(items.append(_), context)
      items
    }

    def foreach(callback: T => Any, context: Any = group) = group.forEach(callback, context)

    def foreachAlive(callback: T => Any, context: Any = group) = group.forEachAlive(callback, context)

  }

}
