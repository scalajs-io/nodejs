package io.scalajs.npm.streamthrottle

import io.scalajs.nodejs.process
import org.scalatest.funspec.AnyFunSpec

/**
  * Throttle Test
  * @author lawrence.daniels@gmail.com
  */
class ThrottleTest extends AnyFunSpec {

  describe("Throttle") {

    it("supports throttling streams") {
      process.stdin.pipe(new Throttle(new ThrottleOptions(rate = 10))).pipe(process.stdout)
    }

  }

}
