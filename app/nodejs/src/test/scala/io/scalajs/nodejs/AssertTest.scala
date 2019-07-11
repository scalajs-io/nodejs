package io.scalajs.nodejs

import org.scalatest.funspec.AnyFunSpec

import scala.scalajs.js

/**
  * Assert Test
  * @author lawrence.daniels@gmail.com
  */
class AssertTest extends AnyFunSpec {

  describe("Assert") {

    it("should handle deep comparisons") {
      Assert.deepEqual(js.Array(1, 2, 3), js.Array(1, 2, 3))
    }
  }

}
