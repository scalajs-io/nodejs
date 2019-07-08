package io.scalajs.npm.moment

import io.scalajs.util.ScalaJsHelper._

/**
  * moment duration format package object
  * @author lawrence.daniels@gmail.com
  */
package object durationformat {

  // load the module
  MomentDurationFormat

  implicit class MomentDurationEnrichment(val moment: Moment) extends AnyVal {

    @inline
    def duration(duration: Double, durationUnit: String): moment.type = {
      moment.dynamic.duration(duration, durationUnit).asInstanceOf[moment.type]
    }

  }

}
