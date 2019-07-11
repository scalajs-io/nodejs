package io.scalajs.npm.moment.business

import io.scalajs.npm.moment.Moment

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Utilities for working with week days and weekend days in Moment. It assumes a Western workweek,
  * in which weekends are Saturday and Sunday.
  * @see [[https://www.npmjs.com/package/moment-business]]
  * @author lawrence.daniels@gmail.com
  */
trait MomentBusiness extends js.Object {

  /**
    * Calculate the number of week days between startMoment and endMoment. Week days are Monday through Friday.
    * If endMoment comes before startMoment, then this function will return a negative value.
    * @param startMoment the start [[Moment moment]]
    * @param endMoment   the end [[Moment moment]]
    * @return the number of week days between startMoment and endMoment.
    */
  def weekDays(startMoment: Moment, endMoment: Moment): Int = js.native

  /**
    * Calculate the number of weekend days between the moment and otherMoment. Weekend days are Saturday and Sunday.
    * If endMoment comes before startMoment, then this function will return a negative value.
    * @param startMoment the start [[Moment moment]]
    * @param endMoment   the end [[Moment moment]]
    * @return the number of weekend days between the moment and otherMoment.
    */
  def weekendDays(startMoment: Moment, endMoment: Moment): Int = js.native

  /**
    * Add week days to a moment, modifying the original moment. Returns the moment.
    * @param moment the given [[Moment]]
    * @param amount the delta amount
    * @return the [[Moment]]
    */
  def addWeekDays(moment: Moment, amount: Double): Moment = js.native

  /**
    * Subtract week days from the moment, modifying the original moment. Returns the moment.
    * @param moment the given [[Moment]]
    * @param amount the delta amount
    * @return the [[Moment]]
    */
  def subtractWeekDays(moment: Moment, amount: Double): Moment = js.native

  /**
    * Whether or not the Moment is a week day (Monday - Friday).
    * @param moment the given [[Moment]]
    * @return true if the Moment is a week day (Monday - Friday)
    */
  def isWeekDay(moment: Moment): Boolean = js.native

  /**
    * Whether or not the Moment occurs on Saturday or Sunday.
    * @param moment the given [[Moment]]
    * @return true if the Moment occurs on Saturday or Sunday.
    */
  def isWeekendDay(moment: Moment): Boolean = js.native

}

/**
  * Moment Business Companion
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("moment-business", JSImport.Namespace)
object MomentBusiness extends MomentBusiness