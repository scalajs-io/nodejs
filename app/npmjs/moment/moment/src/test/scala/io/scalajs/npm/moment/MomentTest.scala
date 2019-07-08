package io.scalajs.npm.moment

import io.scalajs.nodejs.Assert
import org.scalatest.FunSpec

/**
  * Moment Tests
  * @author lawrence.daniels@gmail.com
  */
class MomentTest extends FunSpec {

  describe("Moment") {

    it("should convert date formatted strings to date objects") {
      val input = "9/01/2016 6:17a"
      info(s"input => $input")

      val output = Moment(input, "M/DD/YYYY h:mma").toString
      info(s"output => $output")

      Assert.equal(output, "Thu Sep 01 2016 06:17:00 GMT-0700")
    }
  }

}
