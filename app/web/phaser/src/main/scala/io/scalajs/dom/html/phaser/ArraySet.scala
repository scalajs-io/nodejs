package io.scalajs.dom.html.phaser

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * ArraySet is a Set data structure (items must be unique within the set) that also maintains order.
  * This allows specific items to be easily added or removed from the Set.
  *
  * Item equality (and uniqueness) is determined by the behavior of Array.indexOf.
  *
  * This used primarily by the Input subsystem.
  * @param list The backing array: if specified the items in the list must be unique,
  *             per Array.indexOf, and the ownership of the array should be relinquished to the ArraySet.
  * @see http://phaser.io/docs/2.6.2/Phaser.ArraySet.html
  */
@js.native
@JSGlobal("Phaser.ArraySet")
class ArraySet[T](var list: js.Array[T] = js.native) extends js.Object {

  /**
    * Returns the first item and resets the cursor to the start.
    */
  var first: T = js.native

}
