package io.scalajs.npm.moment

import io.scalajs.util.ScalaJsHelper._

/**
  * timezone package object
  * @author lawrence.daniels@gmail.com
  */
package object timezone {

  // preload the module
  MomentTimezone

  /**
    * Moment Extensions
    * @param moment the given [[Moment moment]] instance
    */
  final implicit class MomentExtensions(val moment: Moment) extends AnyVal {

    @inline
    def tz(timeZone: String): Moment = moment.dynamic.tz(timeZone).asInstanceOf[Moment]

  }

}
