package io.scalajs.nodejs

import scala.scalajs.js
import org.scalatest.funspec.AnyFunSpec

/**
  * Assert Test
  */
class AssertTest extends AnyFunSpec {
  describe("Assert") {
    it("should handle deep comparisons") {
      Assert.deepStrictEqual(js.Array(1, 2, 3), js.Array(1, 2, 3))
    }
  }
}
