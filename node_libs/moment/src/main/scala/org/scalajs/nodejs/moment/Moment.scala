package org.scalajs.nodejs.moment

import org.scalajs.nodejs.NodeRequire

import scala.scalajs.js

/**
  * Moment.js - Parse, validate, manipulate, and display dates in JavaScript.
  * @see [[http://momentjs.com/]]
  * @version 2.14.1
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Moment extends js.Object {

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

  def subtract(delta: Double, s: String): this.type = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Relative Time
  /////////////////////////////////////////////////////////////////////////////////

  def apply(dateString: String, formatString: String = null): this.type = js.native

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