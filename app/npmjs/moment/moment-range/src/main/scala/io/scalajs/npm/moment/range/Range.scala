package io.scalajs.npm.moment
package range

import io.scalajs.collection.Iterator

import scala.scalajs.js

import scala.scalajs.js.|

/**
  * Represents a Range
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Range extends js.Object {

  def add(range: Range): this.type = js.native

  def add(units: Int, unit: String): this.type = js.native

  def adjacent(range: Range): Boolean = js.native

  def by(timeUnit: String, options: RangeOptions = js.native): Iterator[this.type] = js.native

  def center(): this.type = js.native

  def contains(date: js.Date, options: RangeOptions = js.native): Boolean = js.native

  def diff(timeUnit: String = js.native): Int = js.native

  def intersect(range: Range): Boolean = js.native

  def isEqual(range: Range): Boolean = js.native

  def isSame(range: Range): Boolean = js.native

  /**
    * Find out if your moment falls within a date range
    * @param range
    * @return
    */
  def overlaps(range: Range): Boolean = js.native

  def range(dates: js.Array[_]): this.type = js.native

  def range(timeInterval: String): this.type = js.native

  def range(start: js.Date | Moment | String, end: js.Date | Moment | String): this.type = js.native

  def reverseBy(timeUnit: String, options: RangeOptions = js.native): Iterator[this.type] = js.native

  def reverseByRange(timeUnit: String, options: RangeOptions = js.native): Iterator[this.type] = js.native

  /**
    * Subtracting one range from another.
    * @param range the other range
    * @return the difference
    */
  def subtract(range: Range): this.type = js.native

  def toDate(): js.Array[js.Date] = js.native

  override def valueOf(): Int = js.native

  def within(range: Range): Boolean = js.native

}

/**
  * Range Options
  * @param exclusive indicates whether the range is exclusive
  */

class RangeOptions(val exclusive: js.UndefOr[Boolean] = js.undefined,
                   val step: js.UndefOr[Int] = js.undefined) extends js.Object