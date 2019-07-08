package io.scalajs.npm.moment.durationformat

import io.scalajs.nodejs.Assert
import io.scalajs.npm.moment.Moment
import org.scalatest.FunSpec

/**
  * Moment Duration Format Test Suite
  * @author lawrence.daniels@gmail.com
  */
class MomentDurationFormatTest extends FunSpec {

  describe("MomentDurationFormat") {

    it("formats durations as times") {
      val duration = Moment.duration(123, "minutes").format()
      Assert.equal(duration, "2:03:00")
    }

    it("formats durations as dates") {
      val duration = Moment.duration(123, "months").format()
      Assert.equal(duration, "10 years, 3 months")
    }

    it("formats durations using custom formats") {
      val duration = Moment.duration(123, "minutes").format("h:mm")
      Assert.equal(duration, "2:03")
    }

  }

}
