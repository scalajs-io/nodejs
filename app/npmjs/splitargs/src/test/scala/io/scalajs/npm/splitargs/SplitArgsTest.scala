package io.scalajs.npm.splitargs

import io.scalajs.nodejs.Assert
import org.scalatest.FunSpec

import scala.scalajs.js

/**
  * SplitArgs Tests
  * @author lawrence.daniels@gmail.com
  */
class SplitArgsTest extends FunSpec {

  describe("SplitArgs") {

    it("splits a line into tokens") {
      val line = "I said 'I am sorry.', and he said \"it doesn't matter.\""
      val args = SplitArgs(line)
      Assert.deepEqual(args, js.Array("I", "said", "I am sorry.,", "and", "he", "said", "it doesn\'t matter."))
    }

  }

}
