package io.scalajs.npm.moment

import io.scalajs.util.ScalaJsHelper._

/**
  * timezone package object
  * @author lawrence.daniels@gmail.com
  */
package object timezone {

  /**
    * Moment Extensions
    * @param moment the given [[Moment moment]] instance
    */
  implicit class MomentExtensions(val moment: Moment) extends AnyVal {

    @inline
    def tz(timeZone: String): Moment = {
      MomentTimezone
      moment.dynamic.tz(timeZone).asInstanceOf[Moment]
    }

  }

}
