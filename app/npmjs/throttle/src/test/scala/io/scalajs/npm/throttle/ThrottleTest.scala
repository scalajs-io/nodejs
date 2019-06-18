package io.scalajs.npm.throttle

import io.scalajs.nodejs.process
import org.scalatest.FunSpec

/**
  * Throttle Test Suite
  * @author lawrence.daniels@gmail.com
  */
class ThrottleTest extends FunSpec {

  describe("Throttle") {

    it("reduce the throughput of streams") {

      process.stdin.pipe(new Throttle(100 * 1024)).pipe(process.stdout)

    }

  }

}
