package com.github.ldaniels528.meansjs.angularjs

import scala.scalajs.js

/**
  * Selects a subset of items from array and returns it as a new array.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Filter extends js.Object {

  /**
    * Selects a subset of items from array and returns it as a new array.
    * @param filter
    * @param array      The source array.
    * @param expression The predicate to be used for selecting items from array.
    * @param comparator Comparator which is used in determining if the expected value (from the filter expression) and
    *                   actual value (from the object in the array) should be considered a match.
    * @return
    */
  def apply[T](filter: String)(array: js.Array[T], expression: js.Any, comparator: js.Any = js.undefined): js.Array[T] = js.native

}
