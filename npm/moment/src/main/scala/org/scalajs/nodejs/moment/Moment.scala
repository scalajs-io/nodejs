package org.scalajs.nodejs
package moment

import org.scalajs.nodejs.NodeRequire

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * Moment.js - Parse, validate, manipulate, and display dates in JavaScript.
  * @see [[http://momentjs.com/]]
  * @version 2.14.1
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Moment extends NodeModule {

  /////////////////////////////////////////////////////////////////////////////////
  //      Format Dates
  /////////////////////////////////////////////////////////////////////////////////

  def format(formatString: String = null): String = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Conversions
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * moment#native has been replaced by moment#toDate and has been deprecated as of 1.6.0
    */
  @deprecated("Use toDate() instead", since = "1.6.0")
  def native(): js.Date = js.native

  /**
    * This returns an array that mirrors the parameters from new Date().
    * @example moment().toArray(); // [2013, 1, 4, 14, 40, 16, 154];
    */
  def toArray(): js.Array[Int] = js.native

  /**
    * To get the native Date object that Moment.js wraps, use moment#toDate.
    * @see [[http://momentjs.com/docs/#/displaying/as-javascript-date/]]
    */
  def toDate(): js.Date = js.native

  /**
    * When serializing an object to JSON, if there is a Moment object, it will be represented as an ISO8601 string, adjusted to UTC.
    */
  def toJSON(): js.Any = js.native

  /**
    * Formats a string to the ISO8601 standard.
    */
  def toISOString(): String = js.native

  /**
    * This returns an object containing year, month, day-of-month, hour, minute, seconds, milliseconds.
    */
  def toObject(): js.Any = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Calendar Time
  /////////////////////////////////////////////////////////////////////////////////

  def calendar(): String = js.native

  def add(delta: Double, s: String): this.type = js.native

  def day(): Int = js.native

  def day(value: Int): this.type = js.native

  def date(): Int = js.native

  def date(value: Int): this.type = js.native

  def hour(): Int = js.native

  def hour(value: Int): this.type = js.native

  def millisecond(): Int = js.native

  def millisecond(value: Int): this.type = js.native

  def minute(): Int = js.native

  def minute(value: Int): this.type = js.native

  def month(): Int = js.native

  def month(value: Int): this.type = js.native

  def second(): Int = js.native

  def second(value: Int): this.type = js.native

  def subtract(delta: Double, s: String): this.type = js.native

  def utcOffset(): Int = js.native

  def utcOffset(value: Int): this.type = js.native

  def year(): Int = js.native

  def year(value: Int): this.type = js.native

  def weekday(): Int = js.native

  def weekday(value: Int): this.type = js.native

  @deprecated("use moment().utcOffset instead.", since = "2.0")
  def zone(): Int = js.native

  @deprecated("use moment().utcOffset instead.", since = "2.0")
  def zone(value: Int): this.type = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Relative Time
  /////////////////////////////////////////////////////////////////////////////////

  def apply(date: js.Date | String = null): this.type = js.native

  def apply(date: js.Date | String, formatString: String): this.type = js.native

  def fromNow(): String = js.native

  def endOf(s: String): this.type = js.native

  def startOf(s: String): this.type = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Multiple Locale Support
  /////////////////////////////////////////////////////////////////////////////////

  def locale(): String = js.native

}

/**
  * Moment Companion
  * @author lawrence.daniels@gmail.com
  */
object Moment {

  /**
    * Convenience method for retrieving the 'moment' module
    * @param require the implicit [[NodeRequire require function]]
    * @return the Moment instance
    */
  def apply()(implicit require: NodeRequire) = require[Moment]("moment")

}