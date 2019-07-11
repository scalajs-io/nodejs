package io.scalajs.npm.moment
package timezone

import io.scalajs.nodejs.Assert
import org.scalatest.funspec.AnyFunSpec

/**
  * MomentTimezone Test Suite
  * @author lawrence.daniels@gmail.com
  */
class MomentTimezoneTest extends AnyFunSpec {

  describe("MomentTimezone") {

    // sure the moment-timezone module is loaded
    MomentTimezone

    it("should convert a date formatted string an ISO date with a user-defined timezone") {
      val input = "9/01/2016 6:17a"
      info(s"input => $input")

      val output = Moment(input, "M/DD/YYYY h:mma").tz("America/New_York").toISOString()
      info(s"output => $output")

      Assert.equal(output, "2016-09-01T13:17:00.000Z")
    }

    it("should apply a timezone and custom formatting to a moment object") {
      val input = "2014-06-01T12:00:00Z"
      info(s"input => $input")

      val moment = Moment(input)
      val output = moment.tz("America/Los_Angeles").format("ha z")
      info(s"output => $output")

      Assert.equal(output, "5am PDT")
    }

  }

}
