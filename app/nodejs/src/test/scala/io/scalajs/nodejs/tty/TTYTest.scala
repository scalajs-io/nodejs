package io.scalajs.nodejs.tty

import org.scalatest.funspec.AnyFunSpec

/**
  * TTY Test
  * @author lawrence.daniels@gmail.com
  */
class TTYTest extends AnyFunSpec {

  describe("TTY") {

    it("should identify TTY devices") {
      assert(!TTY.isatty(1))
    }

  }

}
