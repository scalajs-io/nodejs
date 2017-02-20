package io.scalajs.nodejs.tty

import org.scalatest.FunSpec

/**
  * TTY Test
  * @author lawrence.daniels@gmail.com
  */
class TTYTest extends FunSpec {

  describe("TTY") {

    it("should identify TTY devices") {
      assert(!TTY.isatty(1))
    }

  }

}
