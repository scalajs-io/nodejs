package io.scalajs.nodejs

import org.scalatest.FunSpec

import scala.scalajs.js

/**
  * Assert Test
  * @author lawrence.daniels@gmail.com
  */
class AssertTest extends FunSpec {

  describe("Assert") {

    it("should handle deep comparisons") {
      Assert.deepEqual(js.Array(1, 2, 3), js.Array(1, 2, 3))
    }
  }

}
