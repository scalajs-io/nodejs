package io.scalajs.npm.streamthrottle

import io.scalajs.nodejs.process
import org.scalatest.FunSpec

/**
  * Throttle Test
  * @author lawrence.daniels@gmail.com
  */
class ThrottleTest extends FunSpec {

  describe("Throttle") {

    it("supports throttling streams") {
      process.stdin.pipe(new Throttle(new ThrottleOptions(rate = 10))).pipe(process.stdout)
    }

  }

}
